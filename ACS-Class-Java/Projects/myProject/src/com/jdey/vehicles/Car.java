package com.jdey.vehicles;
public class Car extends Vehicle
{
    String model;
    int licencePlate;

    public Car (String model, int licencePlate) {
        super(0);
        this.model = model;
        this.licencePlate = licencePlate;
        this.color = "white";
    }
    
    public void move()
    {
        super.move(5);
    }
    
    
}