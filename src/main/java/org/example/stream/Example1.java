package org.example.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example1 {
    public static void main(String[] args) {
        // 데이터 소스
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // 스트림 생성
        List<String> filteredNames = names.stream()
                // 중간 처리: 함수형 프로그래밍으로 이름이 'C'로 시작하는지 필터링
                .filter(name -> name.startsWith("C"))
                // 중간 처리: 함수형 프로그래밍으로 이름을 대문자로 변환
                .map(name -> name.toUpperCase())
                // 최종 연산: 함수형 프로그래밍으로 결과를 리스트로 수집
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println(filteredNames); // [CHARLIE]
    }
}


