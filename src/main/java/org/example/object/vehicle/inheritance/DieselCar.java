package org.example.object.vehicle.inheritance;

class DieselCar extends Car {
    DieselCar(String name, int energyAmount) {
        super(name, "Diesel", energyAmount);
    }

    void refuelDiesel(int amount) {
        System.out.println(this.name + "에 " + amount + "만큼 경유를 추가합니다.");
        super.fillEnergy(amount);
    }
}