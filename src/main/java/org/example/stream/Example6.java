package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example6 {
    public static void main(String[] args) {
        // 숫자 정렬 후 문자열로 이어 붙이기
        List<Integer> list = Arrays.asList(10,40,9,15);
        String result = list.stream()
                .sorted()
                .map(item -> Integer.toString(item))
                .collect(Collectors.joining());
        System.out.println(result);
    }
}


