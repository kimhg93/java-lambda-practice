package com.practice.lambda.scope_closure;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 클로저
 * 람다 표현식이 외부 스코프에 있는 변수를 캡처하고, 해당 변수를 람다 표현식 내부에서 사용할 수 있는 개념을 말한다.
 * 캡처된 변수는 람다 표현식이 만들어진 시점의 외부 변수의 값을 유지하며, 람다 표현식 내부에서 변경될 수 없는 final 또는 effectively final 상태여야 한다.
 */
public class ClosureExample {

    private static int b = 5;

    private static Stream<Integer> calculator(Stream<Integer> stream, int a){
        // 외부 스코프인 a, b를 참조해서 사용함
        return stream.map(x -> x*a+b);
    }

    public static void main(String[] args) {
        int a = 10;

        // a 변수는 람다 표현식 내부에서 캡처되어 사용되고 있으며, 람다 표현식은 a를 클로저로 유지한다.
        Supplier<Integer> supplier = () -> a;
        System.out.println(supplier.get());

        // 외부변수 a와 b를 참조하여 연산 하는 예시
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = calculator(list.stream(), 2)
                .collect(Collectors.toList());
        System.out.println(result.toString());

    }
}
