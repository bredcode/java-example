package org.example.algorithm.problem.sort.절댓값정렬;

import java.util.*;

public class Main1 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 첫 줄에서 N을 읽음
        sc.nextLine(); // 개행 문자 제거 (필수!)

        // 두 번째 줄의 숫자들을 읽고 배열에 저장
        String[] input = sc.nextLine().split(" ");
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // 정렬: 절댓값 기준 오름차순, 같다면 원래 값 기준 오름차순
        Arrays.sort(arr, (a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) return a - b; // 절댓값 같다면 원래 값 비교
            return absA - absB;
        });

        // 출력 (공백으로 구분, 마지막 공백 제거)
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        new Main1().solution();
    }
}
