package org.example.object.vehicle.polymorphism.comparable;

public class Truck implements Vehicle {
    private String name;
    private int energyAmount;

    public Truck(String name, int energyAmount) {
        this.name = name;
        this.energyAmount = energyAmount;
    }

    @Override
    public int getEnergyAmount() {
        return energyAmount;
    }

    @Override
    public void drive() {
        System.out.println("트럭 " + name + "을(를) 운전합니다. 연료량: " + energyAmount);
    }

    @Override
    public int compareTo(Vehicle other) {
        return Integer.compare(this.energyAmount, other.getEnergyAmount());
    }

    @Override
    public String toString() {
        return "트럭: " + name + " - 연료량: " + energyAmount;
    }
}