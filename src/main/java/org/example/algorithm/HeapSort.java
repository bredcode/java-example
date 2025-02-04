package org.example.algorithm;

public class HeapSort {
    private int[] heap;
    private int cnt;

    public HeapSort(int size) {
        heap = new int[size + 1];  // 1번 인덱스부터 사용
        cnt = 0;
    }

    public void push(int data) {
        // 원소 수 증가
        cnt++;
        heap[cnt] = data;

        // 자식과 부모 관계를 설정
        int cur = cnt;
        int par = cur / 2;

        // 최소 힙 정의에 따라 부모와 자식을 비교하여 스왑
        while (cur > 1 && heap[cur] < heap[par]) {
            // 스왑
            int temp = heap[cur];
            heap[cur] = heap[par];
            heap[par] = temp;

            // cur을 부모로 변경하고 반복
            cur = par;
            par = cur / 2;
        }
    }

    // 힙에서 원소를 제거하고 반환
    public Integer pop() {
        if (cnt == 0) {
            return null;  // 힙이 비어 있으면 null 반환
        }

        // 루트 데이터 pop
        int data = heap[1];

        // 힙의 마지막 데이터를 루트로 가져옴
        heap[1] = heap[cnt];
        cnt--;

        // 자식과 비교하며 힙 속성 유지
        int cur = 1;
        while (true) {
            int child = cur * 2;

            // 두 자식 중 더 작은 값을 선택
            if (child < cnt && heap[child] > heap[child + 1]) {
                child++;
            }

            // 더 이상 자식이 없거나 현재 값이 자식보다 작으면 종료
            if (child > cnt || heap[cur] < heap[child]) {
                break;
            }

            // 스왑
            int temp = heap[cur];
            heap[cur] = heap[child];
            heap[child] = temp;

            cur = child;
        }

        return data;
    }

    // 힙 정렬 메서드
    public int[] heapSort(int[] arr) {
        // 배열의 모든 원소를 힙에 삽입
        for (int elem : arr) {
            push(elem);
        }

        // 정렬된 배열을 담을 리스트
        int[] sortedArr = new int[arr.length];

        // 힙에서 원소를 하나씩 pop하여 정렬된 배열에 추가
        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = pop();
        }

        return sortedArr;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort(10);
        int[] arr = {29, 10, 14, 37, 8, 27};

        System.out.println("정렬 전 배열:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 힙 정렬 실행
        int[] sortedArr = heapSort.heapSort(arr);

        System.out.println("정렬된 배열:");
        for (int num : sortedArr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
