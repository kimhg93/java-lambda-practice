package com.practice.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * 스트림 사용 시 아래와 같은 경우 더 간결하게 줄일 수 있다.
 */
public class Simplified {

    public static void main(String[] args) {
        List<Integer> collection = new ArrayList<>();
        int[] array = new int[10];
        Stream<Integer> stream = collection.stream();

        // forEach
        collection.stream().forEach(System.out::println);
        collection.forEach(System.out::println);

        // Stream to Array
        collection.stream().toArray();
        collection.toArray();

        // Array to Stream
        Arrays.asList().stream();
        Arrays.stream(array);
        Stream.of(array);

        // 빈 스트림
        Collections.emptyList().stream();
        Stream.empty();

        // 조건에 일치하는 첫번째 요소
        stream.filter(it -> it > 0).findFirst().isPresent();
        stream.anyMatch(it -> it > 0);

        // 스트림 요소 카운트
        stream.collect(counting());
        stream.count();

        // max
        stream.collect(maxBy(Comparator.comparing(it -> it)));
        stream.max(Comparator.comparing(it -> it));

        // min
        stream.sorted(Comparator.comparing(it -> it)).findFirst();
        stream.min(Comparator.comparing(it -> it));

        // collect (전체 요소 문자열로 변환 하는 예시. map 과 collect 의 조건은 바뀔 수 있음)
        stream.collect(mapping(it -> it.toString(), Collectors.joining(", ")));
        stream.map(it -> it.toString()).collect(Collectors.joining(", "));

        // reduce (전체 sum 구하는 예시. 처리 조건은 바뀔 수 있음)
        stream.collect(reducing((a,b) -> a+b)) ;
        stream.reduce((a,b) -> a+b);

        // int 값의 sum
        stream.collect(summingInt(it -> it.intValue()));
        stream.mapToInt(it -> it.intValue()).sum();

        // peek 요소+1 값을 리턴
        stream.map(it -> { it+=1; return it;});
        stream.peek(it -> it+=1);

        // 조건에 일치하지 않는 요소가 있는지 여부
        boolean b = !stream.anyMatch(it -> it != null);
        b = stream.noneMatch(it -> it != null);

        // 모든 요소가 조건을 만족하는지 여부
        b = !stream.anyMatch(it -> !(it != null));
        b = stream.allMatch(it -> it != null);

        // 조건에 일치하는 요소가 있는지 여부
        stream.map(it -> it.toString()).anyMatch(it -> it != null);
        stream.anyMatch(it -> it != null);

        // 지정된 범위의 Array 값을 반환
        IntStream.range(0, 10).mapToObj(x -> array[x]);
        Arrays.stream(array, 0, 10);

    }
}
