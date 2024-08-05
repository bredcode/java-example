package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example5 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // findFirst 예제
        Optional<Integer> first = numbers.stream().findFirst();
        first.ifPresent(value -> System.out.println("처음 값 : " + value));

        // max 예제
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        max.ifPresent(value -> System.out.println("max 값 : " + value));

        // Optional을 사용하여 값이 없는 경우 처리
        Optional<Integer> emptyMax = numbers.stream().filter(num -> num > 5).findFirst();
        int defaultValue = emptyMax.orElse(0);
        System.out.println("값이 없는 경우 : " + defaultValue);
    }
}


