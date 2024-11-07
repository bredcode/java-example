package org.example.object.vehicle.polymorphism.comparable;

public interface Vehicle extends Comparable<Vehicle> {
    int getEnergyAmount();
    void drive();
}