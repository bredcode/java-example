package org.example.algorithm.problem.sort.국영수;

import java.util.*;

public class Main2 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수 입력
        sc.nextLine(); // 개행 문자 제거

        List<Student2> students = new ArrayList<>();

        // 학생 정보 입력
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(" ");
            students.add(new Student2(data[0],
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3])));
        }

        // 정렬 수행 (익명 클래스를 활용한 Comparator)
        students.sort(new Comparator<Student2>() {
            @Override
            public int compare(Student2 s1, Student2 s2) {
                // 국어 점수 내림차순
                if (s1.getKorean() != s2.getKorean()) {
                    return Integer.compare(s2.getKorean(), s1.getKorean());
                }
                // 영어 점수 오름차순
                if (s1.getEnglish() != s2.getEnglish()) {
                    return Integer.compare(s1.getEnglish(), s2.getEnglish());
                }
                // 수학 점수 내림차순
                if (s1.getMath() != s2.getMath()) {
                    return Integer.compare(s2.getMath(), s1.getMath());
                }
                // 이름 사전순(오름차순)
                return s1.getName().compareTo(s2.getName());
            }
        });

        // 정렬된 학생들의 이름 출력
        for (Student2 s : students) {
            System.out.println(s.getName());
        }

        sc.close();
    }

    public static void main(String[] args) {
        new Main1().solution();
    }
}

// 학생 정보 저장용 클래스
class Student2 {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student2(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public int getKorean() {
        return korean;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }
}