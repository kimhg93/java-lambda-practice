## Stream 연산

####중간 연산

1. filter(Predicate<T> predicate): 조건에 맞는 요소만을 포함한 새로운 스트림을 반환한다.
2. map(Function<T, R> mapper): 주어진 함수를 사용하여 각 요소를 변환한 새로운 스트림을 반환한다.
3. flatMap(Function<T, Stream<R>> mapper): 주어진 함수를 사용하여 각 요소를 스트림으로 변환하고, 결과 스트림들을 하나의 스트림으로 합친다.
4. distinct(): 중복 요소를 제거한 새로운 스트림을 반환한다.
5. sorted(): 자연 순서대로 정렬된 스트림을 반환한다.
6. sorted(Comparator<T> comparator): 주어진 비교자를 사용하여 정렬된 스트림을 반환한다.
7. peek(Consumer<T> action): 스트림의 각 요소에 주어진 작업을 수행하며, 주로 디버깅 목적으로 사용된다.
8. limit(long maxSize): 주어진 크기 이하의 길이를 가진 스트림을 반환한다.
9. skip(long n): 처음 n개의 요소를 생략한 스트림을 반환한다.

***

####최종 연산

1. forEach(Consumer<T> action): 각 요소에 주어진 작업을 수행한다.
2. toArray(): 스트림의 요소들을 배열로 반환한다.
3. reduce(BinaryOperator<T> accumulator): 스트림의 요소들을 하나의 값으로 줄인다.
4. collect(Collector<T, A, R> collector): 스트림의 요소들을 컬렉션 또는 다른 형태의 값으로 변환한다.
5. min(Comparator<T> comparator): 주어진 비교자를 사용하여 최소 요소를 찾는다.
6. max(Comparator<T> comparator): 주어진 비교자를 사용하여 최대 요소를 찾는다.
7. count(): 스트림의 요소 개수를 반환한다.
8. anyMatch(Predicate<T> predicate): 주어진 조건을 만족하는 요소가 있는지 확인한다.
9. allMatch(Predicate<T> predicate): 모든 요소가 주어진 조건을 만족하는지 확인한다.
10. noneMatch(Predicate<T> predicate): 모든 요소가 주어진 조건을 만족하지 않는지 확인한다.
11. findFirst(): 스트림의 첫 번째 요소를 반환한다.
12. findAny(): 스트림의 임의의 요소를 반환한다.