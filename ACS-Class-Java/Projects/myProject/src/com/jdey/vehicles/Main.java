package com.jdey.vehicles;
public class Main
{
    public static void main(String[] args) {
        Vehicle[] vehicleList = new Vehicle[2];

        vehicleList[0] = new Car("Honda", 6586);
        vehicleList[1] = new Truck("Ford", 5876);

        for (int i = 0; i < vehicleList.length; i++) {
            System.out.println(vehicleList[i].getColor());
        }
    }
}

