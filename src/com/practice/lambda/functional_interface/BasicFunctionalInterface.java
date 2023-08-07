package com.practice.lambda.functional_interface;

import java.util.function.*;

/**
 * 기본 함수형 인터페이스
 *
 * 함수형 인터페이스는 람다 표현식과 함수형 프로그래밍을 지원하기 위해 자바 8에서 추가된 개념이다.
 * 단 하나의 추상 메서드를 가져야 하며, 인터페이스 내에 디폴트 메서드나 정적 메서드가 있어도 상관없다.
 * 이러한 특징 때문에 함수형 인터페이스는 람다 표현식의 타겟 타입으로 사용될 수 있다.
 */
public class BasicFunctionalInterface {

    public static void main(String[] args) {

        /**
         * Consumer<T>
         * 역할: 단일 인자를 받아서 그것을 소비(사용)하는 함수를 정의하는 인터페이스
         * 사용 용도: 주로 인자를 받아서 어떤 동작을 수행하고 결과를 반환하지 않을 때 사용. 주로 출력과 같은 부작용을 위해 사용
         *
         * Stream API 의 peek 에서 사용
         */
        // 문자열을 전달받아 Consumer 를 통해 출력
        Consumer<String> printString = str -> System.out.println(str);
        printString.accept("Hello world");


        /**
         * Supplier<T>
         * 역할: 인자를 받지 않고 결과를 생성(공급)하는 함수를 정의하는 인터페이스
         * 사용 용도: 주로 인자 없이 결과를 생성해야 할 때 사용. 데이터를 생성하거나 초기화하는 용도로 사용
         */
        // 랜덤 숫자를 제공하는 Supplier 를 생성하고 Consumer 를 통해 출력
        Supplier<Integer> getRandomNumber = () -> (int) (Math.random() * 100);
        Consumer<Integer> printSupplier = num -> System.out.println(getRandomNumber.get() * num);
        printSupplier.accept(100);


        /**
         * Function<T, R>
         * 역할: 단일 인자를 받아서 다른 타입의 결과를 반환하는 함수를 정의하는 인터페이스.
         * 사용 용도: 데이터 변환, 매핑, 추출 등에서 사용. 주로 입력을 받아서 결과를 반환하는 변환 작업에 사용.
         *
         * Stream API 의 map
         */
        // 랜덤 숫자를 제공하는 Supplier 를 생성하고 Integer 를 String 으로 변환하는 Function 을 생성, Consumer 를 통해 출력
        Supplier<Integer> getRandomNumber2 = () -> (int) (Math.random() * 1000);
        Function<Integer, String> intToString = num -> Integer.toString(num);
        Consumer<String> printFunction = str -> System.out.println(str);
        printFunction.accept(intToString.apply(getRandomNumber2.get()));


        /**
         * Predicate<T>
         * 역할: 단일 인자를 받아서 boolean 값을 반환하는 함수를 정의하는 인터페이스.
         * 사용 용도: 주어진 조건에 대한 검사나 필터링에 사용. 조건을 만족하는지 검사하는데 사용.
         *
         * Stream API 의 filter
         */
        // 랜덤 숫자를 제공하는 Supplier 를 생성하고, 소수 여부를 체크하는 Predicate 생성, String 결과를 반환하는 Function 을 생성,
        // Supplier 에서 제공한 random 숫자를 Function 으로 전달해 Predicate 로 소수판별을 하고 random 숫자와 결과를 Consumer 를 통해 출력
        Supplier<Integer> getRandomNumber3 = () -> (int) (Math.random() * 1000);
        Predicate<Integer> checkPrimeNumber = num -> isPrime(num); // 소수 판별
        Function<Integer, String> isPrime =  num -> num + " is Prime? " + checkPrimeNumber.test(num);
        Consumer<String> result = str -> System.out.println(str);
        result.accept(isPrime.apply(getRandomNumber3.get()));


        /**
         * BiFunction<T, U, R>
         * 역할: 두 개의 인자를 받아서 다른 타입의 결과를 반환하는 함수를 정의하는 인터페이스.
         * 사용 용도: 두 개의 인자를 받아서 둘을 조합하여 결과를 생성하는 작업에 사용. 두 개의 입력을 받아서 결과를 반환하는 변환 작업에 사용.
         */
        // 랜덤 숫자를 제공하는 Supplier 를 생성하고, 결과로 String 을 반환하는 BiFunction 을 생성,
        // Supplier 에서 제공한 두개의 Random 숫자를 BiFunction 으로 전달해 두수를 더한 결과를 Consumer 를 통해 출력
        Supplier<Integer> getRandomNumber4 = () -> (int) (Math.random() * 1000);
        BiFunction<Integer, Integer, String> addNumber = (a, b) -> a+" + " + b + " = " + (a+b);
        Consumer<String> printAddNumber = str -> System.out.println(str);
        printAddNumber.accept(addNumber.apply(getRandomNumber4.get(), getRandomNumber4.get()));

    }

    // 1000이하 소수 판별
    public static boolean isPrime(int num){
        boolean[] arr = new boolean[1001];
        for(int i=2; i<=1000; i++){
            for (int j = i*i; j <= 1000; j+=i) {
                arr[j] = true;
            }
        }
        return !arr[num];
    }
}
