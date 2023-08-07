package com.practice.lambda.scope_closure;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 스코프
 * 람다 표현식은 외부 스코프의 변수를 캡처할 수 있다. 이때 캡처된 변수를 람다 표현식의 바디에서 사용할 수 있으며, 해당 변수는 클로저로 동작한다.
 * 캡처된 변수는 사실상 람다 표현식의 인스턴스의 일부가 되며, 람다 표현식 내부에서 변경될 수 없는 final 혹은 effectively final 상태여야 한다.
 * 이렇게 함으로써 스레드 안정성과 메모리 안정성을 보장한다.
 */
public class ScopeExample {

    static String name = "홍길동";

    public static void main(String[] args) {

        // name 변수는 람다 표현식 내부에서 캡처되어 사용되고 있으며, 이때 name 변수는 클로저로 동작.
        Supplier<String> supplier = () -> "Hello, " + name;
        System.out.println(supplier.get());

        // 외부 스코프의 변수와 이름이 충돌할 경우, 람다 표현식 내부에서 외부 변수를 명시적으로 지정해야 한다. 이를 "shadowing"이라고도 한다.
        // 아래는 람다 표현식 내부에서 외부의 name 변수를 name이라는 새로운 변수로 shadowing 하고 있다.
        Supplier<String> supplier2 = () -> {
            String name = "철수";
            return "Hello, " + name;
        };
        System.out.println(supplier2.get());



        // 람다에서 사용되는 외부 변수는 final 혹은 유사 final 상태여야 한다.
        // 아래 예시는 외부에서 캡처되는 변수를 변경 시도하면 에러가 발생한다.
        // 이 파이널을 우회하기 위해 객체의 내부 값을 변경하는 형태로 처리가 가능하다.
        int sum = 0;
        int[] arr = {0};
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Function<List<Integer>, Integer> finalTest = list -> {
            // list.forEach(num -> sum += num); // sum 변수가 final 이 아니므로 에러 발생
            // return sum;
            list.forEach(num -> arr[0] += num); // sum 변수 대신 array 를 참조하여 내부 값을 변경하는 형태로 우회
            return arr[0];
        };
        System.out.println(finalTest.apply(numbers));
        // 위와 같이 배열 내부의 값을 변경하는 형태로 사용 할 경우 side effect 의 가능성이 존재
        // 아래와 같이 stream 구조로 변경하는 것이 바람직
        sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }


}

