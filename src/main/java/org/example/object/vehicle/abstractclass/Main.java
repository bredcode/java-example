package org.example.object.vehicle.abstractclass;

public class Main {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar("테슬라", 30);
        electricCar.fillEnergy(10);
        electricCar.charge(10);
        electricCar.beep();
        electricCar.drive();

        GasolineCar gasolineCar = new GasolineCar("소나타", 20);
        gasolineCar.fillEnergy(10);
        gasolineCar.refuelGasoline(10);
        gasolineCar.beep();
        gasolineCar.drive();

        DieselCar dieselCar = new DieselCar("그랜저", 10);
        dieselCar.fillEnergy(10);
        dieselCar.refuelDiesel(10);
        dieselCar.beep();
        dieselCar.drive();
    }
}