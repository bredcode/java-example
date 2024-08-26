package org.example.vehicle.inheritance;

class GasolineCar extends Car {
    GasolineCar(String name, int energyAmount) {
        super(name, "Gasoline", energyAmount);
    }

    void refuelGasoline(int amount) {
        System.out.println(this.name + "에 " + amount + "만큼 휘발유를 추가합니다.");
        super.fillEnergy(amount);
    }
}