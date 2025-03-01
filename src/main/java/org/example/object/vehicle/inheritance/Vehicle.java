package org.example.object.vehicle.inheritance;

class Vehicle {
    String name;
    String type;
    int energyAmount;

    Vehicle(String name, String type, int energyAmount) {
        this.name = name;
        this.type = type;
        this.energyAmount = energyAmount;
    }

    void drive() {
        System.out.println("[Vehicle] [" + this.type + "] " + this.name + "을(를) 운전합니다.\n");
    }

    void fillEnergy(int amount) {
        this.energyAmount += amount;
        System.out.println("[Vehicle] 충전 되었습니다. 현재양: " + this.energyAmount);
    }
}
