package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectExample2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Edward");

        // 이름이 "C"로 시작하는 요소만 필터링하여 리스트로 수집
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("C"))
                .collect(Collectors.toList());

        System.out.println(filteredNames); // 출력: [Charlie]
    }
}