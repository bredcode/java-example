package org.example.algorithm.problem.sort.절댓값정렬;

import java.util.*;

public class Main2 {
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

        // 퀵 정렬 실행
        sort(arr, 0, N - 1);

        // 출력 (공백으로 구분, 마지막 공백 제거)
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i]);
            if (i < N - 1) System.out.print(" ");
        }
    }

    // 퀵 정렬 함수
    public Integer[] sort(Integer[] data, int start, int end) {
        if (start >= end) {
            return data;
        }

        int left = start;
        int right = end;
        int pivot = data[left];

        while (left < right) {
            while ((Math.abs(data[right]) > Math.abs(pivot) ||
                    (Math.abs(data[right]) == Math.abs(pivot) && data[right] > pivot))
                    && right > left) {
                right--;
            }

            while ((Math.abs(data[left]) < Math.abs(pivot) ||
                    (Math.abs(data[left]) == Math.abs(pivot) && data[left] < pivot))
                    && left < right) {
                left++;
            }
            data[right] = data[left];
        }

        data[left] = pivot;

        sort(data, start, left - 1);
        sort(data, left + 1, end);

        return data;
    }
    public static void main(String[] args) {
        new Main2().solution();
    }
}
