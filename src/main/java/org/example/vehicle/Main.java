package org.example.vehicle;

import org.example.carpbread.CarpBread;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("탈것", "운송 수단", 0);
        vehicle.fillEnergy(10);
        vehicle.drive();

        Bike bike = new Bike("5토바이", "오토바이", 20);
        bike.fillEnergy(20);
        bike.drive();

        Car car = new Car("차", "자동차", 50);
        car.fillEnergy(10);
        car.drive();

        ElectricCar electricCar = new ElectricCar("테슬라", 30);
        electricCar.charge(10);
        electricCar.drive();

        GasolineCar gasolineCar = new GasolineCar("소나타", 20);
        gasolineCar.refuelGasoline(10);
        gasolineCar.drive();

        DieselCar dieselCar = new DieselCar("그랜저", 10);
        dieselCar.refuelDiesel(10);
        dieselCar.drive();

        // Q. ElectricCar에 멤버변수 speed가 선언되어있다면 electricCar1.speed는 될까?
        // Car electricCar1 = new ElectricCar("GV70", 10);
        // System.out.println(electricCar1.speed);

        // 다형성
        Vehicle bike1 = new Bike("o토바이", "오토바이", 10);
        bike1.fillEnergy(10);
        Vehicle car1 = new Car("차차", "자동차", 10);
        car1.fillEnergy(10);
    }
}

