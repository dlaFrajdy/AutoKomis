package vechicle;

import dataGenerator.PartGenerator;

import java.util.ArrayList;

public class Car {


    public String producer;
    public String model;
    public String color;
    public double value;
    public int mileage;
    private ArrayList<Part> partList;


    public Car(String producer, String model, String color, double value, int mileage) {
        this.producer = producer;
        this.model = model;
        this.color = color;
        this.value = value;
        this.mileage = mileage;
        this.partList = PartGenerator.GeneratePartSet(this);
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + color + " " + value + "zł " + mileage + "km"+"\n"+partList;
    }

}
