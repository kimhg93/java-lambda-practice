package com.practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 커스텀 컬렉터
 * 스트림의 요소를 원하는 방식으로 수집하는 기능을 제공하는 인터페이스이다. java.util.stream.Collector 인터페이스를 통해 커스텀 컬렉터를 구현할 수 있다.
 * 기본적으로 제공되는 컬렉터 외에도 복잡한 수집 작업이 필요한 경우 커스텀 컬렉터를 사용하여 요구 사항에 맞게 데이터를 수집하고 변형할 수 있다.
 *
 * 커스텀 컬렉터를 구현하기 위해서는 Collector 인터페이스의 메서드들을 구현해야 한다
 *
 * Collector 인터페이스
 * Supplier<A> supplier(): 빈 결과 컨테이너를 생성하는 함수를 반환한다
 * BiConsumer<A, T> accumulator(): 스트림의 요소를 결과 컨테이너에 축적하는 함수를 반환한다
 * BinaryOperator<A> combiner(): 두 결과 컨테이너를 병합하는 함수를 반환한다 병렬 처리 시에 사용된다
 * Function<A, R> finisher(): 결과 컨테이너를 최종 결과로 변환하는 함수를 반환한다
 * Set<Characteristics> characteristics(): 컬렉터의 특성을 정의하는 특성 집합을 반환한다
 *
 * 커스텀 컬렉터는 Collector.of() 메서드를 이용하여 구현할 수도 있다.
 * Collector.of() 메서드를 사용하면 위에서 언급한 메서드들을 직접 구현하지 않아도 더 간편하게 커스텀 컬렉터를 생성할 수 있다.
 */
public class CustomCollectors {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "grape");

        // 커스텀 컬렉터를 이용하여 길이가 4 이하인 문자열을 추출
       List<String> customCollector1 = words.stream()
                .collect(Collector.of(
                        ArrayList::new, // Supplier: 빈 ArrayList를 생성
                        (list, str) -> {
                            if(str.length() <= 4) list.add(str); // accumulator: 길이가 4 이하인 문자열들을 리스트에 추가
                        },
                        (list1, list2) -> {
                            list1.addAll(list2); // combiner: 두 리스트를 합침
                            return list1;
                        },
                        Collector.Characteristics.IDENTITY_FINISH
                ));
        System.out.println(customCollector1);


        // CustomCollector 클래스를 생성해서 collector 를 적용 하는 예시
        List<Integer> numbers = new ArrayList<>();
        for(int i=20; i<=40; i++){
            numbers.add(i);
        }
        // 숫자 리스트에서 홀수와 짝수를 분리하여 두 개의 리스트로 수집하는 커스텀 컬렉터
        CustomCollector<Integer> customCollector2 = numbers.stream()
                .collect(CustomCollector.partitioningBy(num -> num % 2 == 0));

        List<Integer> even = customCollector2.get(true);
        List<Integer> odd = customCollector2.get(false);

        System.out.println(even);
        System.out.println(odd);
    }
}

class CustomCollector<T> {

    private final List<T> evenList;
    private final List<T> oddList;

    public CustomCollector(List<T> evenList, List<T> oddList){
        this.evenList = evenList;
        this.oddList = oddList;
    }

    public static <T> Collector<T, ?, CustomCollector<T>> partitioningBy(Predicate<? super T> predicate) {
        return Collector.of(
            () -> new CustomCollector<>(new ArrayList<>(), new ArrayList<>()), // CustomCollector 생성
            (customCollector, num) -> {
                if(predicate.test(num)) customCollector.evenList.add(num); // 짝수 여부 판별 후 각 리스트에 add
                else customCollector.oddList.add(num);
            },
            (left, right) -> {
                left.evenList.addAll(right.evenList); // 짝수 홀수 별 리스트 취합
                left.oddList.addAll(right.oddList);
                return left;
            }
        );
    }

    public List<T> get(boolean partition){
        return partition ? evenList : oddList;
    }

}