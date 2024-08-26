package org.example.vehicle.abstractclass;

public class Main {
    public static void main(String[] args) {
        Vehicle electricCar = new ElectricCar("테슬라", 30);
        electricCar.fillEnergy(10);
        ((ElectricCar) electricCar).charge(10);
        ((ElectricCar) electricCar).beep();
        electricCar.drive();

        Vehicle gasolineCar = new GasolineCar("소나타", 20);
        gasolineCar.fillEnergy(10);
        ((GasolineCar) gasolineCar).refuelGasoline(10);
        ((GasolineCar) gasolineCar).beep();
        gasolineCar.drive();

        Vehicle dieselCar = new DieselCar("그랜저", 10);
        dieselCar.fillEnergy(10);
        ((DieselCar) dieselCar).refuelDiesel(10);
        ((DieselCar) dieselCar).beep();
        dieselCar.drive();
    }
}