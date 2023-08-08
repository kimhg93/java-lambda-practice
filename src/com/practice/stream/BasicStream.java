package com.practice.stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * 스트림(Stream)
 * 스트림은 자바 8에서 소개된 새로운 데이터 처리 방식이다.
 * 기존의 자바에서는 데이터를 다루는 방법으로 주로 반복문을 사용하거나, 컬렉션에 저장된 데이터를 가져와서 처리하는 방식을 사용했지만
 * 이러한 방식은 코드가 길어지고 가독성이 떨어지는 등의 문제가 있었다.
 * 스트림은 데이터를 처리하는데 있어서 더욱 효율적이고 간결한 코드를 작성할 수 있게 도와준다.
 *
 * 스트림의 특징
 * 선언형 프로그래밍: 스트림을 사용하면 무엇을 원하는지를 선언적으로 표현할 수 있다. 무엇을 처리해야 하는지에 초점을 맞춘다.
 *                  이로 인해 코드의 가독성이 증가하고, 더욱 직관적으로 작성할 수 있습니다.
 *
 * 내부 반복: 기존의 컬렉션 처리 방식은 외부 반복을 사용한다. 명시적으로 컬렉션의 요소를 하나씩 꺼내서 처리해야 했지만
 *          스트림은 내부적으로 반복을 처리하므로 요소를 하나씩 처리하는 코드를 작성할 필요가 없습니다.
 *
 * 지연 평가: 스트림은 지연 평가를 지원한다. 이는 스트림의 요소들이 실제로 필요할 때에만 처리된다는 의미이다.
 *          스트림의 요소를 필터링하여 새로운 스트림을 생성한 경우, 해당 스트림의 요소들은 필터링 과정이 수행될 때에만 계산되며,
 *          필요 없는 요소는 계산되지 않는다. 이로 인해 불필요한 계산을 피할 수 있다.
 *
 * 병렬 처리 지원: 스트림은 병렬 처리를 지원한다. 멀티코어 CPU를 활용하여 데이터를 병렬로 처리할 수 있으므로, 대량의 데이터를 빠르게 처리할 수 있다.
 *
 * 스트림은 컬렉션과는 다른 개념이지만, 기존의 컬렉션과 함께 사용할 수도 있다.
 * 스트림은 요소들의 흐름으로 볼 수 있으며, 이를 활용하여 데이터를 다루는 다양한 기능들을 제공한다.
 * 따라서 스트림을 잘 이해하고 사용한다면 데이터 처리에 있어서 더욱 효율적이고 간결한 코드를 작성할 수 있다.
 */
public class BasicStream {

    public static void main(String[] args) {

        // 스트림 생성

        // List 로 부터 스트림 생성
        List<String> list = Arrays.asList("apple", "banana", "orange");
        Stream<String> streamFromList = list.stream();

        // Set 으로 부터 스트림 생성
        Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Stream<Integer> streamFromSet = set.stream();

        // Map 으로 부터 스트림 생성
        Map<String, Integer> map = new HashMap<>();
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

        // 배열로 부터 스트림 생성
        Integer[] numberArray = {1, 2, 3, 4, 5};
        Stream<Integer> streamFromArray = Arrays.stream(numberArray);

        String[] stringArray = {"a", "b", "c"};
        Stream<String> streamFromStringArray = Arrays.stream(stringArray);

        // 무한 스트림 생성
        Stream<Integer> InfiniteStream = Stream.iterate(0, n -> n+2);
        Stream<Double> randomStream = Stream.generate(Math::random);

    }
}
