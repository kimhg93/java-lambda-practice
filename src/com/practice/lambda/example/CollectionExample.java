package com.practice.lambda.example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 컬렉션 예제
 *
 * 컬렉션 데이터를 다루는 작업이 빈번하게 발생하며, 람다 표현식을 활용하면 간결하고 효율적인 코드를 작성.
 * 주로 컬렉션의 요소를 필터링하거나 매핑하는 작업을 수행
 * 예를 들어, 리스트에서 특정 조건을 만족하는 요소들을 찾거나, 맵의 키 또는 값들을 변경하는 등의 작업을 람다 표현식으로 처리.
 */
public class CollectionExample {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=20; i++){
            numbers.add(i);
        }

        // 리스트에서 짝수만 필터링
        List<Integer> even = numbers.stream()
                .filter(num -> num%2 == 0)
                .collect(Collectors.toList());
        System.out.println("짝수 : " + even.toString());

        // 리스트의 홀수만 필터링
        List<Integer> odd = numbers.stream()
                .filter(num -> num%2 != 0)
                .collect(Collectors.toList());
        System.out.println("홀수 : " + odd);

        // 리스트의 각 수의 제곱
        List<Integer> squared = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
        System.out.println("각 수의 제곱 : " + squared.toString());

        // 리스트의 모든 요소를 합산
        int sum = numbers.stream().mapToInt(num -> num.intValue()).sum();
        System.out.println("전체 합 : " + sum);

        // 문자열 리스트에서 길이가 5 이하인 문자열만 필터링
        List<String> words = Arrays.asList("asdff", "asdfqwef", "zxcv", "ASdfefs", "dfdf", "a", "qwerdfg");
        List<String> longWords = words.stream()
                .filter(str -> str.length() > 5)
                .collect(Collectors.toList());
        System.out.println("길이가 5 이상인 문자열 : " + longWords);

        // 맵의 키 값을 대문자로 변경
        Map<String, Integer> map = new HashMap<>();
        map.put("abcd", 1234);
        map.put("qwer", 4567);
        map.put("zxcv", 5678);

        Map<String, Integer> convertMap = new HashMap<>();
        map.forEach((key, value) -> convertMap.put(key.toUpperCase(), value));
        System.out.println("맵의 키를 대문자로 변환 : " + convertMap.toString());
    }
}
