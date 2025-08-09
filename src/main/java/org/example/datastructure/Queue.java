package org.example.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
    public static void main(String[] args) {
        // 큐 생성
        Deque<Integer> queue = new ArrayDeque<>();

        // 데이터 넣기 (enqueue)
        queue.offer(5);
        queue.offer(4);
        queue.offer(3);
        queue.offer(2);
        queue.offer(1);

        // 전체 큐 확인
        System.out.println("큐 내용: " + queue); // [5, 4, 3, 2, 1] (toString은 front부터 보임)

        // 큐 front와 rear 확인
        if (!queue.isEmpty()) {
            int front = queue.peek(); // 가장 먼저 들어온 값 확인
            System.out.println("큐 front: " + front); // 5
        } else {
            System.out.println("큐가 비어있습니다.");
        }

        // 데이터 빼기 (dequeue)
        System.out.println("dequeue(): " + queue.poll()); // 5
        System.out.println("dequeue(): " + queue.poll()); // 4
        System.out.println("dequeue(): " + queue.poll()); // 3
        System.out.println("dequeue(): " + queue.poll()); // 2
        System.out.println("dequeue(): " + queue.poll()); // 1

        // 큐가 비었는지 확인
        System.out.println("isEmpty: " + queue.isEmpty()); // true

        // 큐 크기 확인
        System.out.println("size: " + queue.size()); // 0
    }
}
