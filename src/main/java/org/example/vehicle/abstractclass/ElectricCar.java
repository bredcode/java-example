package org.example.vehicle.abstractclass;

class ElectricCar extends Car {
    ElectricCar(String name, int energyAmount) {
        super(name, "Electric", energyAmount);
    }

    @Override
    void beep() {
        System.out.println("[ElectricCar] " + this.name + "의 경적소리: 일렉일렉!!");
    }

    void charge(int amount) {
        System.out.println("[ElectricCar] " + this.name + "에 " + amount + "만큼 전기를 추가합니다.");
        fillEnergy(amount);
    }
}