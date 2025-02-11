package org.example.algorithm;

import java.util.Arrays;

class CountingSort {
    public int[] sort(int[] data) {
        // data 배열에서 가장 큰 수 찾기
        int maxValue = Arrays.stream(data).max().orElse(0);

        // countingArr 배열을 0으로 초기화된 배열로 생성 (크기는 maxValue + 1)
        int[] countingArr = new int[maxValue + 1];

        // 현재 값을 토대로 countingArr의 인덱스 위치에 값을 +1 해줌
        for (int num : data) {
            countingArr[num]++;
        }

        // countingArr의 값이 1 이상일 때
        // 해당 인덱스 값을 data에 넣어주면 정렬 완료
        int idx = 0;
        for (int i = 0; i < countingArr.length; i++) {
            while (countingArr[i] > 0) {
                data[idx++] = i;
                countingArr[i]--;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2, 8, 7, 9, 7, 9};

        CountingSort countingSort = new CountingSort();
        System.out.println("원래 배열: " + Arrays.toString(arr));
        int[] sortedArr = countingSort.sort(arr.clone());
        System.out.println("정렬된 배열: " + Arrays.toString(sortedArr));
    }
}