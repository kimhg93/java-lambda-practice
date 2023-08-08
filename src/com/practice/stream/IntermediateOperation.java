package com.practice.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 중개 연산
 * 스트림의 중개 연산은 스트림의 요소를 변환하거나, 걸러내는 등의 작업을 수행한다.
 * 중개 연산은 스트림을 리턴하며, 여러 개의 중개 연산을 연결하여 사용할 수 있다. 중개 연산은 최종 연산이 호출되기 전까지는 실제로 수행되지 않는다.
 * 중개 연산은 스트림 파이프라인을 구성하여 데이터를 가공하는데 유용하게 사용된다.
 *
 * 주요 중개 연산
 * filter(Predicate<T> predicate): 조건에 맞지 않는 요소를 걸러낸다 Predicate에 따라 요소를 검사하고, 조건을 만족하는 요소만 남긴다.
 * map(Function<T, R> mapper): 각 요소를 변환 Function에 따라 요소를 변환하고, 변환된 결과로 새로운 스트림을 생성한다.
 * flatMap(Function<T, Stream<R>> mapper): 중첩된 스트림을 해제 Function에 따라 요소를 스트림으로 변환하고, 각 스트림의 요소를 하나의 스트림으로 합친다.
 * distinct(): 중복 요소를 제거. 스트림에서 중복되는 요소를 제거한 후, 유일한 요소들로 이루어진 스트림을 리턴.
 * sorted(): 요소를 정렬. 기본적으로는 Comparable 인터페이스를 구현한 객체에 대해 자연 정렬을 수행하며, Comparator를 지정하여 커스텀 정렬도 가능하다.
 * limit(long maxSize): 스트림의 크기를 제한. 주어진 maxSize만큼의 요소로 구성된 스트림을 리턴.
 * skip(long n) 처음 n개의 요소를 건너뛴다. 처음 n개의 요소를 제외한 나머지 요소로 구성된 스트림을 리턴.
 */

public class IntermediateOperation {

    public IntermediateOperation(){}

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "grape");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 5);
        IntermediateOperation intermediateOperation = new IntermediateOperation();


        // Stream<T> filter(Predicate<? super T> predicate)
        // 길이가 5이상인 단어만 필터링
        Stream<String> filteredStream = words.stream()
                .filter(str -> str.length() >= 5);
        intermediateOperation.print(filteredStream);

        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        // 각 수를 제곱한 결과를 반환
        Stream<Integer> squaredStream = numbers.stream()
                .map(n -> n*n);
        intermediateOperation.print(squaredStream);

        // <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        Stream<Integer> flatmapStream = nestedList.stream()
                .flatMap(List::stream);
        intermediateOperation.print(flatmapStream);


        // Stream<T> distinct()
        Stream<Integer> distinctStream = numbers.stream()
                .distinct();
        intermediateOperation.print(distinctStream);


        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<? super T> comparator)
        Stream<Integer> sortedStream = numbers.stream()
                .sorted();
        intermediateOperation.print(sortedStream);

        Stream<Integer> reverseOrderStream = numbers.stream()
                .sorted(Comparator.reverseOrder());
        intermediateOperation.print(reverseOrderStream);

        Stream<String> lengthOrderStream = words.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()));
        intermediateOperation.print(lengthOrderStream);


        // Stream<T> limit(long maxSize)
        Stream<Integer> limitedStream = numbers.stream()
                .limit(5);
        intermediateOperation.print(limitedStream);


        // Stream<T> skip(long n)
        Stream<Integer> skippedStream = numbers.stream()
                .skip(3);
        intermediateOperation.print(skippedStream);

    }

    public <T> void print(Stream<T> stream){
        System.out.println(stream.map(it -> {
            if(it instanceof Integer) return Integer.toString((Integer) it);
            else return it.toString();
        }).collect(Collectors.joining(", ")));
    }
}
