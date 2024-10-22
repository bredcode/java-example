package org.example.vehicle.inheritance;

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

        // 다형성
        // Q. Bike객체이지만 Type이 Vehicle이면 bike1.fillEnergy는 Vehicle의 fillEnergy가 호출될까 아니면 Bike의 fillEnergy가 호출될까?
        Vehicle bike1 = new Bike("o토바이", "오토바이", 10);
        bike1.fillEnergy(10);
        Vehicle car1 = new Car("차차", "자동차", 10);
        car1.fillEnergy(10);

        // Q. ElectricCar에 멤버변수 speed가 선언되어있다면 electricCar1.speed는 될까?
        //  Car electricCar1 = new ElectricCar("GV70", 10);
        //  System.out.println(electricCar1.speed);


        // 정리
        // 메서드 호출은 '현재 변수 타입'이 아닌 '실제 객체의 타입'에 의해 결정,
        // 필드 호출은 '실제 객체의 타입'이 아닌 '현재 변수의 타입'에 의해 결정.
    }
}

