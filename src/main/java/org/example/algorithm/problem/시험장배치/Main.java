package org.example.algorithm.problem.시험장배치;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // 모든 capability의 경우를 찾는 코드
    public List<int[]> findAllCapabilities(int N, int M, int[] capability) {
        List<int[]> results = new ArrayList<>();
        findCapability(N, M, capability, 0, new int[M], results);
        return results;
    }

    private void findCapability(int N, int M, int[] capability, int index, int[] current, List<int[]> results) {
        if (index == M) {
            // 모든 방에 배치가 끝났으면, 각 방에 배치된 인원의 합이 N과 일치하는지 체크
            if (sum(current) == N) {
                results.add(current.clone());
            }
            return;
        }

        // 현재 방에 들어갈 수 있는 가능한 인원수를 0부터 capability[index]까지 반복
        for (int i = 0; i <= capability[index]; i++) {
            current[index] = i;
            findCapability(N, M, capability, index + 1, current, results);
        }
    }

    private int sum(int[] array) {
        int total = 0;
        for (int num : array) {
            total += num;
        }
        return total;
    }
    // 여기까지

    // 하늘님 코드
    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 1;
        int remainingStudents = N;
        for (int i = 0; i < M; i++) {
            int capacityInClass = capacity[i];
            if (remainingStudents >= capacityInClass) {
                answer *= combination(remainingStudents, capacityInClass);
                remainingStudents -= capacityInClass;
            } else {
                answer *= combination(remainingStudents, remainingStudents);
                remainingStudents = 0;
            }
        }
        answer *= permutation(K, M);
        return answer;
    }
    private long combination(int n, int r) {
        if (r > n) return 0;
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
    private long permutation(int n, int r) {
        return factorial(n) / factorial(n - r);
    }
    private long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main();

        // 예시
        int N = 10;
        int M = 3;
        int K = 4;
        int[] capability = new int[]{3, 3, 4};
        List<int[]> capabilities = main.findAllCapabilities(N, M, capability);

        // 결과 출력
        long res = 0;
        for (int[] cap : capabilities) {
            res += main.solution(N, M, K, cap);
        }
        System.out.println(res); // 100800

        // 예시
        N = 10;
        M = 3;
        K = 4;
        capability = new int[]{5, 3, 4};
        capabilities = main.findAllCapabilities(N, M, capability);

        // 결과 출력
        res = 0;
        for (int[] cap : capabilities) {
            res += main.solution(N, M, K, cap);
        }
        System.out.println(res); // 428400
    }
}
