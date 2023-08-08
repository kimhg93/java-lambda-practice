package com.practice.lambda.basic_example;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 조건부 처리 예제
 *
 * 조건에 따라 다른 동작을 람다 표현식을 활용하면 조건부 처리를 더욱 간결하고 효율적으로 할 수 있다.
 * 예를 들어, 조건에 따라서 다른 값을 반환하거나, 다른 동작을 수행하는 등의 작업을 람다 표현식으로 표현할 수 있다.
 */
public class ConditionalExample {

    public static void main(String[] args) {

        // 입력된 수가 짝수 홀수 여부를 검사
        int num = 5;
        Predicate<Integer> isEven = n -> n%2 == 0;
        if(isEven.test(num)) System.out.println(num + " = 짝수");
        else System.out.println(num + " = 홀수");


        // 주말 여부를 검사
        boolean isWeekend = false;
        Function<Boolean, String> messageFunc = isWeekend ? a -> "주말이다" : b -> "주말이 아니다";
        String message = messageFunc.apply(isWeekend);
        System.out.println(message);


        // 입력된 수가 양수, 음수, 0 인지 여부를 검사
        int num2 = 10;
        Predicate<Integer> isPositive = n -> n > 0;
        Predicate<Integer> isNegative = n -> n < 0;
        Predicate<Integer> isZero = n -> n == 0;

        if(isPositive.test(num2)){
            System.out.println("양수!");
        } else if(isNegative.test(num2)){
            System.out.println("음수!");
        } else if(isZero.test(num2)){
            System.out.println("0!");
        }


        // 문자열이 특정 패턴을 만족하는지 여부를 검사
        String input = "Hello World";
        Predicate<String> containsHello = str -> str.contains("Hello");
        Predicate<String> startWithHi = str -> str.startsWith("Hi");
        Predicate<String> endWithWorld = str -> str.endsWith("World");

        if(containsHello.test(input)){
            System.out.println(input + " 이 포함됨");
        } else if(startWithHi.test(input)){
            System.out.println(input + " 으로 시작함");
        } else if(endWithWorld.test(input)){
            System.out.println(input + " 으로 끝남");
        } else {
            System.out.println("일치 패턴 없음");
        }

    }
}
