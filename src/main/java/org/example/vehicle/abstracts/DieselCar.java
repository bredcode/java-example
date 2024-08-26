package org.example.vehicle.abstracts;

class DieselCar extends Car {
    DieselCar(String name, int energyAmount) {
        super(name, "Diesel", energyAmount);
    }

    @Override
    void beep() {
        System.out.println(this.name + "의 경적소리: 디제에엘!!");
    }

    void refuelDiesel(int amount) {
        System.out.println(this.name + "에 " + amount + "만큼 경유를 추가합니다.");
        fillEnergy(amount);
    }
}