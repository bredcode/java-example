package org.example.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example4 {
    public static void main(String[] args) {
        // 절댓값이 최대인 값 찾기
        List<Integer> listAbs = Arrays.asList();
        int maxVal = listAbs.stream()
                .max((x,y) -> Math.abs(x) - Math.abs(y))
                .orElse(0);
        System.out.println(maxVal);
    }
}


