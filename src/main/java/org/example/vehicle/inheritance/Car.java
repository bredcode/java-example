package org.example.vehicle.inheritance;

class Car extends Vehicle {
    Car(String name, String type, int energyAmount) {
        super(name, type, energyAmount);
    }

    @Override
    void fillEnergy(int amount) {
        System.out.println("[Car] 충전중...");
        super.fillEnergy(amount);
    }
}
