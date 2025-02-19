package org.example.algorithm.problem.sort.국영수;

import java.util.*;

public class Main1 {
    public void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 학생 수 입력
        sc.nextLine(); // 개행 문자 제거

        List<Student1> students = new ArrayList<>();

        // 학생 정보 입력
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split(" ");
            students.add(new Student1(data[0],
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3])));
        }

        // 정렬 수행
        students.sort(
                Comparator.comparing(Student1::getKorean).reversed() // 국어 내림차순
                .thenComparing(Student1::getEnglish) // 영어 오름차순
                .thenComparing(Comparator.comparing(Student1::getMath).reversed()) // 수학 내림차순
                .thenComparing(Student1::getName) // 이름 오름차순
        );

        // 정렬된 학생들의 이름 출력
        for (Student1 s : students) {
            System.out.println(s.getName());
        }

        sc.close();
    }

    public static void main(String[] args) {
        new Main1().solution();
    }
}

// 학생 정보 저장용 클래스
class Student1 {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student1(String name, int korean, int english, int math) {
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
