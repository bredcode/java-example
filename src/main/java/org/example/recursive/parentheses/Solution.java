package org.example.recursive.parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    /**
     * @param w: 균형잡힌 괄호 문자열
     * @return 올바른 괄호 문자열
     */
    public String solution(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if (w.isEmpty()) {
            return w;
        }

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        int left = 0;
        int right = 0;
        int idx = 0;
        for (int i = 0; i < w.length(); i++) {
            if (w.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                idx = i;
                break;
            }
        }
        String u = w.substring(0, idx + 1);
        String v = w.substring(idx + 1);

        // 3. 문자열 u가 "올바른 괄호 문자열"이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        if (isCorrect(u)) {
            return u + solution(v);
        }

        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
        // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
        // 4-3. ')'를 다시 붙입니다.
        // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
        return "(" + solution(v) + ")" + reverse(u);
    }

    private boolean isCorrect(String s) {
        // 스택을 이용하면 올바른 문자열인지 확인할 수 있다.
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        // 첫 번째와 마지막 문자 제거
        for (int i = 1; i < u.length() - 1; i++) {
            // 나머지 문자열의 괄호 방향 뒤집기
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }
}

