package com.example.autowire.type;


public class Car {
    private Car_Specifics specs;

    public void setSpecs(Car_Specifics specs) {
        this.specs = specs;
    }
/*    public Car(Car_Specifics specs) {
        this.specs = specs;
    }*/

    public void displayDetails(){
        System.out.println("Car details" + specs.toString());
    }
}
