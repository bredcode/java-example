package org.example.object.vehicle.abstractclass;

abstract class Car implements Vehicle {
    protected String name;
    protected String type;
    protected int energyAmount;

    Car(String name, String type, int energyAmount) {
        this.name = name;
        this.type = type;
        this.energyAmount = energyAmount;
    }

    @Override
    public void drive() {
        System.out.println("[Car] " + "[" + this.type + "] " + this.name + "을(를) 운전합니다.\n");
    }

    @Override
    public void fillEnergy(int amount) {
        System.out.println("[Car] " + "충전중...");
        this.energyAmount += amount;
        System.out.println("[Car] " + "충전 되었습니다. 현재양: " + this.energyAmount);
    }

    abstract void beep();
}