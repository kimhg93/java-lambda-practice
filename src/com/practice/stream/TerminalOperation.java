package com.practice.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 최종 연산
 * 스트림의 최종 연산은 스트림 파이프라인에서 최종적으로 결과를 도출하는 역할을 한다. 
 * 최종 연산은 스트림을 닫고, 스트림에서 최종 결과를 얻기 위해 스트림을 소모(consume)한다. 
 * 즉, 스트림을 사용하여 원하는 최종 결과를 계산하고, 더 이상 스트림을 사용할 수 없게 된다.
 *
 * 주요 최종 연산
 * forEach(Consumer<T> action): 각 요소에 대해 주어진 동작을 수행한다.
 * count(): 스트림의 요소 개수를 반환한다.
 * collect(Collector<T, A, R> collector): 스트림의 요소를 수집하여 컬렉션, 맵 등의 자료구조로 변환한다.
 * min(Comparator<? super T> comparator): 주어진 Comparator에 따라 스트림에서 최소 요소를 반환한다.
 * max(Comparator<? super T> comparator): 주어진 Comparator에 따라 스트림에서 최대 요소를 반환한다.
 * reduce(T identity, BinaryOperator<T> accumulator): 스트림의 요소를 반복적으로 처리하여 하나의 값을 리듀스(축소)한다.
 * anyMatch(Predicate<T> predicate): 스트림의 요소 중 하나라도 주어진 조건에 맞는 요소가 있는지 확인한다.
 * allMatch(Predicate<T> predicate): 스트림의 모든 요소가 주어진 조건에 맞는지 확인한다.
 * noneMatch(Predicate<T> predicate): 스트림의 요소가 모두 주어진 조건을 만족하지 않는지 확인한다.
 * findFirst(): 스트림에서 첫 번째 요소를 반환한다.
 * findAny(): 스트림에서 아무 요소나 하나를 반환한다.
 * 
 */
public class TerminalOperation {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "grape");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 3, 5);

        // void forEach(Consumer<? super T> action)
        numbers.forEach(System.out::println);
        words.stream().forEach(str -> System.out.println(str.length()));


        // long count()
        long count = numbers.stream().count();
        System.out.println(count);


        // <R, A> R collect(Collector<? super T, A, R> collector)
        Map<Integer, List<String>> lengthMap = words.stream()
                .collect(Collectors.groupingBy(str -> str.length()));
        System.out.println(lengthMap);

        Map<Boolean, List<Integer>> oddAndEven = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num%2 == 0));
        System.out.println(oddAndEven);

        double average = numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(average);


        // Optional<T> min(Comparator<? super T> comparator) ** Optional 은 비어있는 상태를 나타냄
        int min = numbers.stream()
                .min(Comparator.comparingInt(a -> a))
                .orElse(0);
        System.out.println(min);

        words.stream()
                .min(Comparator.comparingInt(String::length))
                .ifPresent(str -> System.out.println(str));


        // Optional<T> max(Comparator<? super T> comparator)
        int max = numbers.stream()
                .max(Comparator.comparing(a -> a))
                .orElse(0);
        System.out.println(max);

        words.stream()
                .max(Comparator.comparing(String::length))
                .ifPresent(str -> System.out.println(str));


        // T reduce(T identity, BinaryOperator<T> accumulator)
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a+b);
        System.out.println(sum);


        // boolean anyMatch(Predicate<? super T> predicate)
        boolean hasOddNumber = numbers.stream()
                .anyMatch(n -> n%2 != 0);
        System.out.println(hasOddNumber);

        // boolean allMatch(Predicate<? super T> predicate)
        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println(allPositive);

        // boolean noneMatch(Predicate<? super T> predicate)
        boolean noNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println(noNegative);


        // Optional<T> findFirst()
        String firstWordWithB = words.stream()
                .filter(str -> str.startsWith("b"))
                .findFirst()
                .orElse("");
        System.out.println(firstWordWithB);

        // Optional<T> findAny()
        String anyString = words.stream()
                .findAny()
                .orElse("");
        System.out.println(anyString);
    }
}
