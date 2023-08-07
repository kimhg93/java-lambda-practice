package com.practice.lambda.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 사칙연산 예제
 *
 * Operation 함수형 인터페이스를 정의하고, 덧셈, 뺄셈, 곱셈, 나눗셈 등의 연산을 람다 표현식으로 구현하여 calculate 메서드에 전달.
 * calculate 메서드에서는 해당 람다 표현식을 호출하여 숫자 계산을 수행.
 */
@FunctionalInterface
interface Operation {
    int calculate(int a, int b);
}

public class OperationExample {

    static int calculate(int a, int b, Operation operation){
        return operation.calculate(a, b);
    }

    public static void main(String[] args) {
        int x = 20;
        int y = 10;

        List<Integer> list = new ArrayList<>();

        Operation add = (a, b) -> a+b;
        int resultAdd = calculate(x, y, add);
        System.out.println("resultAdd = " + resultAdd);

        Operation minus = (a, b) -> a-b;
        int resultMinus = calculate(x, y, minus);
        System.out.println("resultMinus = " + resultMinus);

        Operation multiply = (a, b) -> a*b;
        int resultMultiply = calculate(x, y, multiply);
        System.out.println("resultMultiply = " + resultMultiply);

        Operation divide = (a, b) -> a/b;
        int resultDivide = calculate(x, y, divide);
        System.out.println("resultDivide = " + resultDivide);
    }


}

