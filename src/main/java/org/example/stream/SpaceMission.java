package org.example.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class SpaceObject {
    String type;
    int dist;

    SpaceObject(String type, int dist) {
        this.type = type;
        this.dist = dist;
    }
}

public class SpaceMission {
    public static List<Integer> solution(List<SpaceObject> arr) {
        return arr.stream()
                .filter(obj -> obj.type.equals("planet"))
                .map(obj -> obj.dist)
                .sorted(Comparator.comparingInt(Math::abs))
                .limit(3)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<SpaceObject> arr = new ArrayList<>();
        arr.add(new SpaceObject("planet", 10));
        arr.add(new SpaceObject("star", -3));
        arr.add(new SpaceObject("milkyway", 2));
        arr.add(new SpaceObject("planet", 5));
        arr.add(new SpaceObject("planet", -7));
        arr.add(new SpaceObject("star", 4));
        arr.add(new SpaceObject("planet", 6));
        arr.add(new SpaceObject("planet", -1));
        arr.add(new SpaceObject("star", 8));
        arr.add(new SpaceObject("milkyway", -9));

        List<Integer> result = solution(arr);
        System.out.println(result);
    }
}
