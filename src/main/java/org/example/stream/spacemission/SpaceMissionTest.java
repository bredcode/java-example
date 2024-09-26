package org.example.stream.spacemission;

import java.util.ArrayList;
import java.util.List;

class SpaceObject_T {
    String type;
    int dist;

    SpaceObject_T(String type, int dist) {
        this.type = type;
        this.dist = dist;
    }
}

public class SpaceMission_T {
    public static List<Integer> solution(List<SpaceObject_T> arr) {
        // 풀이 작성
    }

    public static void main(String[] args) {
        List<SpaceObject_T> arr = new ArrayList<>();
        arr.add(new SpaceObject_T("planet", 10));
        arr.add(new SpaceObject_T("star", -3));
        arr.add(new SpaceObject_T("milkyway", 2));
        arr.add(new SpaceObject_T("planet", 5));
        arr.add(new SpaceObject_T("planet", -7));
        arr.add(new SpaceObject_T("star", 4));
        arr.add(new SpaceObject_T("planet", 6));
        arr.add(new SpaceObject_T("planet", -1));
        arr.add(new SpaceObject_T("star", 8));
        arr.add(new SpaceObject_T("milkyway", -9));

        List<Integer> result = solution(arr);
        System.out.println(result);
    }
}
