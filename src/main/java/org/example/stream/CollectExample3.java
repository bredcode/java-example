package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // 이름을 키로, 이름의 길이를 값으로 하는 맵으로 수집
        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(
                        name -> name,    // Key: 이름
                        name -> name.length()  // Value: 이름의 길이
                ));

        System.out.println(nameLengthMap); // 출력: {Alice=5, Bob=3, Charlie=7}
    }
}