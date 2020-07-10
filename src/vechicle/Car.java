package vechicle;

import dataGenerator.PartGenerator;

import java.util.ArrayList;


public class Car {


    public String producer;
    public String model;
    public String color;
    public double value;
    public int mileage;
    public ArrayList<Part> partList;
    private ArrayList<Repair> repairHistory;


    public Car(String producer, String model, String color, double value, int mileage) {
        this.producer = producer;
        this.model = model;
        this.color = color;
        this.value = value;
        this.mileage = mileage;
        this.partList = PartGenerator.generatePartSet(this);
        this.repairHistory = new ArrayList<>();
    }

    public void addRepairToHistory(Repair repair) {
        this.repairHistory.add(repair);
    }

    public ArrayList<Part> getBrokenPartsList() {
        ArrayList<Part> brokenPartsList = new ArrayList<>();
        for (Part part : partList
        ) {
            if (part.isBroke)
                brokenPartsList.add(part);
        }
        return brokenPartsList;
    }

    public ArrayList<Part> getWorkingPartsList() {
        ArrayList<Part> workingPartsList = new ArrayList<>();
        for (Part part : partList
        ) {
            if (!part.isBroke)
                workingPartsList.add(part);
        }
        return workingPartsList;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + color + " " + value + "zł " + mileage + "km" + partList;
    }

    public ArrayList<Repair> getRepairHistory() {
        return repairHistory;
    }
}
