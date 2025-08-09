package org.example.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
    public static void main(String[] args) {
        // 스택 생성
        Deque<Integer> stack = new ArrayDeque<>();

        // 데이터 넣기 (push)
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        // 전체 스택 확인
        System.out.println("스택 내용: " + stack); // [1, 2, 3, 4, 5] (toString은 top부터 보임)

        // 스택 top 확인
        if (!stack.isEmpty()) {
            int top = stack.peek(); // pop 없이 top 값 확인
            System.out.println("스택 top: " + top); // 1
        } else {
            System.out.println("스택이 비어있습니다.");
        }

        // 데이터 빼기 (pop)
        System.out.println("pop(): " + stack.pop()); // 1
        System.out.println("pop(): " + stack.pop()); // 2
        System.out.println("pop(): " + stack.pop()); // 3
        System.out.println("pop(): " + stack.pop()); // 4
        System.out.println("pop(): " + stack.pop()); // 5

        // 스택이 비었는지 확인
        System.out.println("isEmpty: " + stack.isEmpty()); // true

        // 스택 크기 확인
        System.out.println("size: " + stack.size()); // 0
    }
}
