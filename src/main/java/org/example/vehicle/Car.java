package org.example.vehicle;

class Car extends Vehicle {
    Car(String name, String type, int energyAmount) {
        super(name, type, energyAmount);
    }

    @Override
    void fillEnergy(int amount) {
        super.fillEnergy(amount);
    }
}
