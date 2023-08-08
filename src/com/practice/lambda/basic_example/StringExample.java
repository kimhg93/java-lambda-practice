package com.practice.lambda.basic_example;

/**
 * 문자열 처리 예제
 *
 * StringLengthCalculator와 StringConverter라는 함수형 인터페이스를 정의하고,
 * 람다 표현식을 사용하여 문자열의 길이를 구하고 대문자로 변환하는 메서드를 구현.
 */
@FunctionalInterface
interface StringLengthCalculator {
    int calculateLength(String str);
}

@FunctionalInterface
interface StringConverter {
    String convert(String str);
}

public class StringExample {

    public static void main(String[] args) {
        String s = "Hello World";

        // 문자열의 길이를 반환하는 람다 표현식
        // 기본 함수형 인터페이스를 이용한 방식
        //Function<String, Integer> lengthCalculator = str -> str.length();
        //int length = lengthCalculator.apply(s);
        // 커스텀 함수형 인터페이스를 이용한 방식
        StringLengthCalculator lengthCalculator = str -> str.length();
        int length = lengthCalculator.calculateLength(s);
        System.out.println("문자열 길이 : " + length);

        // 문자열을 대문자로 변환 하는 람다 표현식
        // 기본 함수형 인터페이스를 이용한 방식
        //Function<String, String> converter = str -> str.toUpperCase();
        //String upperCase = converter.apply(s);
        // 커스텀 함수형 인터페이스를 이용한 방식
        StringConverter converter = str -> str.toUpperCase();
        String upperCase = converter.convert(s);
        System.out.println("대문자 변환 : " + upperCase);
    }

}
