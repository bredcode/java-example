package org.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println("원본 리스트: " + numbers);

        List<Integer> squaredEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println("짝수의 제곱 리스트: " + squaredEvens);
        System.out.println("스트림 사용 후 원본 리스트: " + numbers);

        numbers.stream().forEach(System.out::println);
    }
}


