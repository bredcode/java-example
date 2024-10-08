package org.example.zb.세금;

import java.util.*;

class Solution {
    public int[] solution(int N, int K, int[] arr, int[][] queries) {
        // 이진 탐색 기본 조건: 배열이 정렬되어 있어야 함
        Arrays.sort(arr);

        int[] result = new int[K];

        // 각 쿼리에 대해 처리
        for (int i = 0; i < K; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            // x 이상인 첫 번째 인덱스 찾기
            int left = lowerBound(arr, x);

            // y 이하인 마지막 인덱스 찾기
            int right = upperBound(arr, y);

            // 구간 내에 있는 원소의 개수 계산
            result[i] = right - left;
        }

        return result;
    }


    // target 이상인 값이 처음으로 나오는 인덱스를 찾음 (lower bound)
    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // target 이하인 값이 마지막으로 나오는 인덱스를 찾음 (upper bound)
    private int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}