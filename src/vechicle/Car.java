package vechicle;

import dataGenerator.PartGenerator;

import java.util.ArrayList;
import java.util.List;

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
        this.partList = PartGenerator.generatePartSet(this);

    }

    public ArrayList<Part> getBrokenPartsList(){
        ArrayList<Part> brokenPartsList = new ArrayList<>();
        for (Part part:partList
        ) {
            if (part.isBroke)
                brokenPartsList.add(part);
        }
        return brokenPartsList;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + color + " " + value + "zł " + mileage + "km"+partList;
    }

}
