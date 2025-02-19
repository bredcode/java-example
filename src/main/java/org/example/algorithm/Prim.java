package org.example.algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {
    int to;
    int cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

public class Prim {
    // Prim 알고리즘으로 MST의 총 비용을 계산하는 메소드
    public static int prim(int start, ArrayList<ArrayList<Edge>> graph, int N) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int totalCost = 0;

        // 시작 노드를 방문 처리하고, 해당 노드와 연결된 간선을 큐에 추가
        visited[start] = true;
        for (Edge edge : graph.get(start)) {
            pq.offer(edge);
        }

        // 우선순위 큐가 빌 때까지 반복
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            // 이미 방문한 노드이면 무시 (사이클 방지)
            if (visited[curr.to]) {
                continue;
            }

            // 새로운 노드 방문 처리, 비용 누적
            visited[curr.to] = true;
            totalCost += curr.cost;

            // 현재 노드와 연결된 모든 간선을 큐에 추가
            for (Edge nextEdge : graph.get(curr.to)) {
                if (!visited[nextEdge.to]) {
                    pq.offer(nextEdge);
                }
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int N = 6;  // 노드의 개수
        int M = 9;  // 간선의 개수

        // [from, to, cost] 형태의 간선 정보
        int[][] input = {
                {1, 2, 5},
                {1, 3, 4},
                {2, 3, 2},
                {2, 4, 7},
                {3, 4, 6},
                {3, 5, 11},
                {4, 5, 3},
                {4, 6, 8},
                {5, 6, 8}
        };

        // 그래프를 인접 리스트로 구성 (노드 번호가 1부터 시작하므로 크기는 N+1)
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 무방향 그래프이므로 양쪽에 간선 정보를 추가
        for (int i = 0; i < M; i++) {
            int from = input[i][0];
            int to = input[i][1];
            int cost = input[i][2];
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }

        int mstCost = prim(1, graph, N);
        System.out.println("Minimum Spanning Tree Cost: " + mstCost);
    }
}
