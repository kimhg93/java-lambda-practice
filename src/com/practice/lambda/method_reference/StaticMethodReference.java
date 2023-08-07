package com.practice.lambda.method_reference;

import java.util.Arrays;

/**
 * 정적 메서드 참조
 *
 * 람다 표현식이 단순히 정적 메서드를 호출하는 경우, 정적 메서드 참조를 사용하여 코드를 더 간결하게 만들 수 있다.
 * 정적 메서드 참조는 클래스명::메서드명 형태로 표현되며, 해당 클래스의 정적 메서드를 가리킨다.
 * 메서드 참조를 사용하면 람다 표현식의 인자들을 그대로 전달하여 정적 메서드를 호출하는 것과 동일한 결과를 얻을 수 있다.
 */
public class StaticMethodReference {
    public static void main(String[] args) {

        String[] names = {"asdf", "data", "3ewfb", "cvdfie", "file"};
        // Arrays.sort 메서드를 정적 메서드 참조로 사용하여 문자열 배열을 정렬
        Arrays.sort(names, StaticMethodReference::compareNames);

        // 정렬된 결과 출력
        for (String name : names) {
            System.out.println(name);
        }
    }

    // 정적 메서드로 비교 로직 구현
    public static int compareNames(String a, String b) {
        return a.compareTo(b);
    }
}
