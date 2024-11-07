package org.example.object.animal;

public class Dog implements Animal {
    @Override
    public void move() {
        System.out.println("강아지가 달립니다");
    }

    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }
}
