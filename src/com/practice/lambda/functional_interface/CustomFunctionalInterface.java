package com.practice.lambda.functional_interface;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 커스텀 함수형 인터페이스
 *
 * @FunctionalInterface 어노테이션은 함수형 인터페이스임을 나타내기 위해 사용된다.
 * 이 어노테이션을 붙인 인터페이스가 함수형 인터페이스임을 컴파일러에게 알려준다.
 * 또한, 해당 인터페이스가 함수형 인터페이스의 조건을 만족하는지 검사하여 오류를 방지하는 역할을 한다.
 * 함수형 인터페이스는 단 하나의 추상메서드를 가지며, 내에 디폴트 메서드나 정적 메서드가 있어도 상관없다.
 *
 * 일반적으로 기본 함수형 인터페이스를 활용하며, 기본 함수형 인터페이스로 충족되지 않는 경우에 한정하여 커스텀 함수형 인터페이스를 작성한다.
 */
@FunctionalInterface
interface CustomFunctionalInterface {
    int operate(int a, int b);

    // 디폴트 메서드
    default void print(int a, int b){
        System.out.println("default method > " + a + ", " + b);
    }

    // 정적 메서드
    static void printSomething(String text){
        System.out.println(text);
    }
}

class Main{

    public static void main(String[]args){
        // 결과 출력을 위한 기본 함수형 인터페이스
        Consumer<Integer> printFunction = num -> System.out.println(num);
        Supplier<Integer> randomNumber = () -> (int) (Math.random() * 1000);

        // 디폴트 메서드 테스트
        CustomFunctionalInterface defaultTest = (a, b) -> a+b;
        defaultTest.print(randomNumber.get(), randomNumber.get());
        // 정적 메서드 테스트
        CustomFunctionalInterface.printSomething("static method test!!");

        CustomFunctionalInterface add = (a, b) -> a+b;
        printFunction.accept(add.operate(randomNumber.get(), randomNumber.get()));

        CustomFunctionalInterface minus = (a, b) -> a-b;
        printFunction.accept(minus.operate(randomNumber.get(), randomNumber.get()));

        CustomFunctionalInterface multiply = (a, b) -> a*b;
        printFunction.accept(multiply.operate(randomNumber.get(), randomNumber.get()));

        CustomFunctionalInterface divide = (a, b) -> a/b;
        printFunction.accept(divide.operate(randomNumber.get(), randomNumber.get()));

    }

}