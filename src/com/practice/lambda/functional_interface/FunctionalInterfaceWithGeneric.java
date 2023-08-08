package com.practice.lambda.functional_interface;

/**
 * 함수형 인터페이스와 제네릭
 * 함수형 인터페이스를 제네릭으로 만들어 상황에서 유연하고 타입 안전한 함수를 만들 수 있게 한다.
 */
public class FunctionalInterfaceWithGeneric {

    public static void main(String[] args) {
        // 1개의 파라미터
        GenericFunction1<String> addString = str -> str+"!!";
        String result1 = addString.convert("Test");
        System.out.println(result1);

        GenericFunction1<Integer> addInt = num -> num+1;
        int num1 = addInt.convert(10);
        System.out.println(num1);

        // 2개의 파라미터
        GenericFunction2<Integer, String> intToString = num -> Integer.toString(num);
        String result2 = intToString.convert(1234);
        System.out.println(result2);

        GenericFunction2<String, Integer> stringToInt = Integer::parseInt;
        int num2 = stringToInt.convert("1234");
        System.out.println(num2);

        // 3개의 파라미터
        GenericFunction3<String, Integer, Integer> addStringInt = (s, n) -> Integer.parseInt(s)+n;
        int num3 = addStringInt.convert("100", 10);
        System.out.println(num3);

    }
}

@FunctionalInterface
interface GenericFunction1<T> {
    T convert(T t);
}

@FunctionalInterface
interface GenericFunction2<T, R> {
    R convert(T t);
}

@FunctionalInterface
interface GenericFunction3<T, N, R> {
    R convert(T t, N n);
}