package org.example.algorithm;

import java.util.Arrays;

public class QuickSort {
    public int[] sort(int[] data, int start, int end) {
        if (start >= end) { // 종료 조건
            return data;
        }

        int left = start;
        int right = end;
        int pivot = data[left];

        while (left < right) {
            while (data[right] >= pivot && right > left) {
                right--;
            }
            data[left] = data[right];

            while (data[left] <= pivot && left < right) {
                left++;
            }
            data[right] = data[left];
        }

        data[left] = pivot;

        // 왼쪽과 오른쪽 부분을 재귀적으로 정렬
        sort(data, start, left - 1);
        sort(data, left + 1, end);

        return data;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {6, 8, 3, 2, 4, 5, 1, 7};
        System.out.println("원래 배열: " + Arrays.toString(arr));

        int[] sortedArr = quickSort.sort(arr, 0, arr.length - 1);
        System.out.println("정렬된 배열: " + Arrays.toString(sortedArr));
    }
}
