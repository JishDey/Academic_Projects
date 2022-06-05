package com.jdey.vehicles;

public class Vehicle
{
    private int position;
    String color; 

    public Vehicle(int position) {
        this.position = position;
    }

    public Vehicle(){
        this(0);
    }

    public int getPosition() {
        return position;
    }

    public void move(int n) {
        position += n;
    }

    public String getColor() {
        return color;
    }
}