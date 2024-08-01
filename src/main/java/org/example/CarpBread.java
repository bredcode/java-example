package org.example;

public class CarpBread {
    int id;
    String color;
    String name;

    public CarpBread(int id, String color, String name) {
        this.id = id;
        this.color = color;
        this.name = name;
    }

    void cook() {
        System.out.println("<<< 조리 시작 >>>");
        System.out.println("[정보] 색상 : " + color + " 이름 : " + name);
    }
}
