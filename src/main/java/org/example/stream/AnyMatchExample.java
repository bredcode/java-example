package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AnyMatchExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);

        boolean hasEven = numbers.stream()
                .anyMatch(n -> n % 2 == 0);

        System.out.println(hasEven); // 출력: false
    }
}