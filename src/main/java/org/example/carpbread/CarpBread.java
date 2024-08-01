package org.example.carpbread;

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

    public static boolean validateColor(String color) {
        if (color.equals("mint") || color.equals("brown") || color.equals("yellow") || color.equals("gray")) {
            return true;
        }
        throw new IllegalArgumentException("유효하지 않은 색상입니다: " + color);
    }
}

