package org.example.algorithm;

import java.util.Arrays;

public class MergeSort {
    public int[] merge(int[] left, int[] right) {
        int[] sortedArr = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                sortedArr[k++] = left[i++];
            } else {
                sortedArr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            sortedArr[k++] = left[i++];
        }

        while (j < right.length) {
            sortedArr[k++] = right[j++];
        }

        return sortedArr;
    }

    public int[] sort(int[] data) {
        if (data.length <= 1) {
            return data;
        }

        int mid = data.length / 2;
        int[] left = Arrays.copyOfRange(data, 0, mid);
        int[] right = Arrays.copyOfRange(data, mid, data.length);

        return merge(sort(left), sort(right));
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {29, 10, 14, 37, 8, 27};
        System.out.println("Original array: " + Arrays.toString(arr));

        int[] sortedArr = mergeSort.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(sortedArr));
    }
}
