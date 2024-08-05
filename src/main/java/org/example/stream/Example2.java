package org.example.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
//        // Stream API 사용 전
//        List<String> strings = Arrays.asList(
//                "apple", "banana", "cherry", "grape"
//        );
//
//        List<String> filtered = new ArrayList<>();
//        for (String s : strings) {
//            if (s.length() > 4) {
//                filtered.add(s);
//            }
//        }
//
//        List<String> upperCased = new ArrayList<>();
//        for (String s : filtered) {
//            upperCased.add(s.toUpperCase());
//        }
//
//        upperCased.sort(new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                return Integer.compare(s1.length(), s2.length());
//            }
//        });
//
//        for (String s : upperCased) {
//            System.out.println(s);
//        }

        // Stream API 사용 후
        List<String> strings = Arrays.asList(
                "apple", "banana", "cherry", "grape"
        );

        List<String> result = strings.stream()
                .filter(s -> s.length() > 4)
                .map(String::toUpperCase)
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());

        result.forEach(System.out::println);
    }
}


