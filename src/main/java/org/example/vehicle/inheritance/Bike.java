package org.example.vehicle.inheritance;

class Bike extends Vehicle {
    Bike(String name, String type, int energyAmount) {
        super(name, type, energyAmount);
    }

    @Override
    void fillEnergy(int amount) {
        this.energyAmount += amount;
        System.out.println(this.name + "에 " + amount + "만큼 연료를 추가합니다. 현재 연료량: " + this.energyAmount);
    }
}
