package org.example.object.vehicle.inheritance;

class ElectricCar extends Car {
    ElectricCar(String name, int energyAmount) {
        super(name, "Electric", energyAmount);
    }

    void charge(int amount) {
        System.out.println("[ElectricCar] " + this.name + "에 " + amount + "만큼 전기를 추가합니다.");
        super.fillEnergy(amount);
    }
}