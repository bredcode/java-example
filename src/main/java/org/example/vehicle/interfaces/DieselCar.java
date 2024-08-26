package org.example.vehicle.interfaces;

class DieselCar implements Vehicle {
    private String name;
    private String type;
    private int energyAmount;

    DieselCar(String name, int energyAmount) {
        this.name = name;
        this.type = "Diesel";
        this.energyAmount = energyAmount;
    }

    @Override
    public void drive() {
        System.out.println("[" + this.type + "] " + this.name + "을(를) 운전합니다.\n");
    }

    @Override
    public void fillEnergy(int amount) {
        this.energyAmount += amount;
        System.out.println(this.name + "에 " + amount + "만큼 경유를 추가합니다. 현재 경유량: " + this.energyAmount);
    }

    void refuelDiesel(int amount) {
        System.out.println(this.name + "에 " + amount + "만큼 경유를 추가합니다.");
        fillEnergy(amount);
    }
}