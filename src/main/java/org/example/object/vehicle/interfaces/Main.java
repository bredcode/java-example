package org.example.object.vehicle.interfaces;

public class Main {
    public static void main(String[] args) {
        Vehicle bike = new Bike("5토바이", "오토바이", 20);
        bike.fillEnergy(20);
        bike.drive();

        ElectricCar electricCar = new ElectricCar("테슬라", 30);
        electricCar.fillEnergy(10);
        electricCar.drive();

        GasolineCar gasolineCar = new GasolineCar("소나타", 20);
        gasolineCar.fillEnergy(10);
        gasolineCar.drive();

        DieselCar dieselCar = new DieselCar("그랜저", 10);
        dieselCar.fillEnergy(10);
        dieselCar.drive();
    }
}