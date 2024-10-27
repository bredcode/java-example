package org.example.vehicle.interfaces;

public class Bike implements Vehicle {
    private String name;
    private String type;
    private int energyAmount;

    Bike(String name, String type, int energyAmount) {
        this.name = name;
        this.type = type;
        this.energyAmount = energyAmount;
    }

    @Override
    public void drive() {
        System.out.println("[Bike] " + "[" + this.type + "] " + this.name + "을(를) 운전합니다.\n");
    }

    @Override
    public void fillEnergy(int amount) {
        this.energyAmount += amount;
        System.out.println("[Bike] " + this.name + "에 " + amount + "만큼 연료를 추가합니다. 현재 연료량: " + this.energyAmount);
    }
}
