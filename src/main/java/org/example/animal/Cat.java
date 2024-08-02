package org.example.animal;

public class Cat implements Animal {
    @Override
    public void move() {
        System.out.println("고양이가 움직입니다.");
    }

    @Override
    public void makeSound() {
        System.out.println("냐옹");
    }
}
