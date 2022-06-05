package com.jdey.vehicles;
public class Truck extends Vehicle
{
    String model;
    int licencePlate;

    public Truck (String model, int licencePlate) {
        super(0);
        this.model = model;
        this.licencePlate = licencePlate;
        this.color = "black";
    }

    
    public void move()
    {
        super.move(5);
    }
    
    
}