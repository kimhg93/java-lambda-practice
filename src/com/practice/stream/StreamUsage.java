package com.practice.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "banana", "orange", "grape", "Kiwi");

        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=20; i++){
            numbers.add(i);
        }
        numbers.add(10);
        numbers.add(20);

        // 문자열 리스트 대문자로 변환
        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseWords.toString());

        // 숫자 리스트의 합계 구하기
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);

        // 문자열 리스트를 하나로 합치기
        String listString = words.stream()
                .collect(Collectors.joining("+"));
        System.out.println(listString);

        // 숫자 리스트에서 최댓값 구하기
        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println(max);

        // 숫자 리스트에서 홀수의 합과 짝수의 합 구하기
        Map<Boolean, Integer> sumOddAndEven = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n%2 == 0, Collectors.summingInt(Integer::intValue)));
        System.out.println("홀수 " + sumOddAndEven.get(false));
        System.out.println("짝수 " + sumOddAndEven.get(true));

        // 문자열 리스트에서 가장 긴 문자열 찾기
        String longWords = words.stream()
                .max(Comparator.comparing(String::length))
                .orElse("");
        System.out.println(longWords);

        // 숫자 리스트에서 중복되지 않는 값 필터링
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);

        // 문자열 리스트를 정렬하고 대문자가 먼저 나오도록 하기
        List<String> sortedWords = words.stream()
                .sorted(Comparator.comparing(str -> str.toLowerCase())) // 소문자로 변환하고 정렬
                .sorted() // 원본 다시 정렬(대문자가 우선순위)
                .collect(Collectors.toList());
        System.out.println(sortedWords);

        // 객체 리스트에서 특정 조건을 만족하는 객체 필터링
        List<Person> people = Arrays.asList(new Person("길동", 20)
                , new Person("영희", 29)
                , new Person("철수", 30)
                , new Person("민수", 40));

        List<Person> filterPeople = people.stream()
                .filter(p -> p.getAge() >= 30)
                .collect(Collectors.toList());
        System.out.println(filterPeople);

    }
}

class Person {
    private int age;
    private String name;

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}