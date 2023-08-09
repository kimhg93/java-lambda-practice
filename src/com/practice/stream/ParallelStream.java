package com.practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 병렬 스트림
 * 병렬 스트림은 스트림 API를 활용하여 데이터를 병렬적으로 처리하는 기능을 제공한다. 스트림은 기본적으로 순차적으로 처리되지만, 
 * 병렬 스트림을 사용하면 스트림의 요소들을 여러 개의 쓰레드에서 동시에 처리하여 작업을 빠르게 수행할 수 있다.
 * 병렬 스트림은 Java의 멀티코어 CPU를 최대한 활용하여 성능 향상을 도모한다.
 */
public class ParallelStream {

    public ParallelStream() {}

    public static void main(String[] args) {
        ParallelStream parallelStream = new ParallelStream();
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<=20; i++){
            numbers.add(i);
        }

        // 순차(기본) 스트림
        numbers.stream()
                .forEach(num -> System.out.print(num + " "));

        System.out.println();

        // 병렬 스트림
        numbers.parallelStream()
                .forEach(num -> System.out.print(num + " "));

        System.out.println();

        // 다시 순차 스트림으로 변환
        numbers.parallelStream()
                .sequential()
                .forEach(num -> System.out.print(num + " "));

        System.out.println();

        // 병렬 스트림의 성능 테스트
        long startTime, endTime;

        startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, 100000000)
                .mapToDouble(Math::sqrt)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("순차 스트림 : " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1, 100000000)
                .parallel()
                .mapToDouble(Math::sqrt)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("병렬 스트림 : " + (endTime - startTime) + "ms");


        // 병렬 스트림의 동기화 예시
        Integer[] arr = new Integer[10000000];
        long[] sum = {0};
        for(int i=0; i<arr.length; i++){
            arr[i] = i+1;
        }
        List<Integer> numbers2 = Arrays.asList(arr);

        // 동기화 하지 않았을때 잘못된 결과 출력
        numbers2.parallelStream()
                .forEach(num -> sum[0] += num);
        System.out.println(sum[0]);

        sum[0] = 0;

        // 강제로 동기화 처리 이후 정상적인 결과 출력
        // synchronized 를 사용하면 어차피 1개의 스레드만 접근하기 때문에 순차처리가 빠르다.
        numbers2.parallelStream()
                .forEach(num -> {
                    synchronized (sum) {
                        sum[0] += num;
                    }
                });
        System.out.println(sum[0]);

    }

    public <T> void print(Stream<T> stream){
        System.out.println(stream.map(it -> {
            if(it instanceof Integer) return Integer.toString((int) it);
            else return it.toString();
        }).collect(Collectors.joining(", ")));
    }
}
