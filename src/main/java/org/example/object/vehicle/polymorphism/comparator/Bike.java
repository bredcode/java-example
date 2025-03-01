package org.example.object.vehicle.polymorphism.comparator;

public class Bike implements Vehicle {
    private String name;
    private int energyAmount;

    public Bike(String name, int energyAmount) {
        this.name = name;
        this.energyAmount = energyAmount;
    }

    @Override
    public int getEnergyAmount() {
        return energyAmount;
    }

    @Override
    public void drive() {
        System.out.println("바이크 " + name + "을(를) 운전합니다. 연료량: " + energyAmount);
    }

    @Override
    public String toString() {
        return "바이크: " + name + " - 연료량: " + energyAmount;
    }
}