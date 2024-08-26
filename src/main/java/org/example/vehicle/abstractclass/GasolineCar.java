package org.example.vehicle.abstractclass;

class GasolineCar extends Car {
    GasolineCar(String name, int energyAmount) {
        super(name, "Gasoline", energyAmount);
    }

    @Override
    void beep() {
        System.out.println(this.name + "의 경적소리: 가솔가솔!!");
    }

    void refuelGasoline(int amount) {
        System.out.println(this.name + "에 " + amount + "만큼 휘발유를 추가합니다.");
        fillEnergy(amount);
    }
}