package org.example.algorithm;
import java.util.Arrays;

class BubbleSort {
    public int[] sort(int[] data) {
        int length = data.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Swap
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] arr = {28, 10, 14, 37, 8, 27};

        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("원래 배열: " + Arrays.toString(arr));
        int[] sortedArr = bubbleSort.sort(arr.clone());
        System.out.println("정렬된 배열: " + Arrays.toString(sortedArr));
    }
}

/**
 *   만약 버블 정렬에서 반복문 내에서 swap이 발생하지 않는다면
 *   모두 정렬된 것이나 마찬가지므로 더이상 버블소트를 진행하지 않아도 된다.
 */
class AdvancedBubbleSort {
    public int[] sort(int[] data) {
        int length = data.length;
        boolean isSwap;

        for (int i = 0; i < length; i++) {
            isSwap = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Swap
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    isSwap = true;
                }
            }

            if (!isSwap) {
                break;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        int[] arr = {28, 10, 14, 37, 8, 27};

        AdvancedBubbleSort advancedBubbleSort = new AdvancedBubbleSort();
        System.out.println("원래 배열: " + Arrays.toString(arr));
        int[] sortedArrAdvanced = advancedBubbleSort.sort(arr.clone());
        System.out.println("정렬된 배열: " + Arrays.toString(sortedArrAdvanced));
    }
}
