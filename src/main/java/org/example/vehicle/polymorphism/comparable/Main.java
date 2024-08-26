package org.example.vehicle.polymorphism.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("MY-CAR", 50)); // Car 객체를 Vehicle 타입으로 저장
        vehicles.add(new Bike("MY-BIKE ", 15)); // Bike 객체를 Vehicle 타입으로 저장
        vehicles.add(new Truck("MY-TRUCK", 75)); // Truck 객체를 Vehicle 타입으로 저장
        vehicles.add(new Car("YOUR-CAR", 30)); // Car 객체를 Vehicle 타입으로 저장
        vehicles.add(new Bike("YOUR-BIKE", 25)); // Bike 객체를 Vehicle 타입으로 저장

        // 정렬 전 출력
        System.out.println("[정렬 전]");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        // Comparable을 구현한 클래스들의 기본 정렬 기준을 사용하여 정렬
        Collections.sort(vehicles);

        // 정렬 후 출력
        System.out.println("\n[정렬 후]");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}