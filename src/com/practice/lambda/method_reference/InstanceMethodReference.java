package com.practice.lambda.method_reference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 인스턴스 메서드 참조
 *
 * 람다 표현식이 인스턴스 메서드를 호출하는 경우, 인스턴스 메서드 참조를 사용하여 코드를 더 간결하게 만들 수 있다.
 *
 * 한정적(바운드) 인스턴스 메서드 참조: 이 유형은 특정 객체의 메서드를 참조한다.객체참조::메서드명
 *
 * 비한정적(언바운드) 인스턴스 메서드 참조: 이 유형은 특정 객체에 종속되지 않은 메서드를 참조한다.
 * 메서드를 호출할 때 첫 번째 인수로 메서드의 수신자(해당 메서드를 호출할 객체)가 전달된다. 클래스명::메서드명
 */
public class InstanceMethodReference {

    public static void main(String[] args) {
        String text = "Hello World";

        List<String> list = new ArrayList<>();
        Function<List<String>, String> test = List::toString;

        // String.toUpperCase() 비한정적 메서드 참조
        Function<String, String> toUpperCase = String::toUpperCase;
        String result = toUpperCase.apply(text);
        System.out.println(result);

        // String.length() 비한정적 메서드 참조
        Function<String, Integer> getLength = String::length;
        int length = getLength.apply(text);
        System.out.println(length);

        // SomeClass 에서 substring(0,5) 를 수행하는 SomeClass.startWith5words() 한정적 메서드 참조
        SomeClass s = new SomeClass();
        Function<String, String> startWith5Words = s::startWith5words;
        String result2 = startWith5Words.apply(text);
        System.out.println(result2);
    }

}

class SomeClass {
    public String startWith5words(String str){
        return str.substring(0,5);
    }
}


