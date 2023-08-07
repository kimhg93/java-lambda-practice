package com.practice.lambda.method_reference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 생성자 참조
 * 객체를 생성하는 데 사용된다. 람다 표현식이 생성자를 호출하는 경우, 생성자 참조를 사용하여 코드를 더 간결하게 만들 수 있다.
 * 생성자 참조는 클래스명::new 형태로 표현되며, 해당 클래스의 생성자를 가리킨다.
 * 메서드 참조와 달리 생성자 참조에서는 new 키워드를 사용하여 객체를 생성한다.
 */
public class ConstructorReference {

    public static void main(String[] args) {

        // 매개변수가 없는 생성자 참조
        Supplier<String> createString = String::new;
        String str = createString.get();
        System.out.println(str); // 빈 문자열 출력


        // 매개변수가 존재하는 생성자 참조
        Function<String, Person> createPerson = Person::new;
        Person person = createPerson.apply("홍길동");
        System.out.println(person.getName());


        // 매개변수가 여러개인 생성자 참조
        BiFunction<Integer, Integer, Number> createNumber = Number::new;
        Number number = createNumber.apply(20, 10);
        System.out.println(number.add());


        // 배열의 생성자 참조
        Function<Integer, int[]> createArray = int[]::new;
        int[] array = createArray.apply(10);
        System.out.println(array.length);

    }

}
class Number {
    private int n;
    private int m;

    public Number(int n, int m){
        this.n = n;
        this.m = m;
    }
    public int add(){
        return n + m;
    }
}

class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}