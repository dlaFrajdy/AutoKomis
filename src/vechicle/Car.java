package vechicle;

import com.company.Game;
import dataGenerator.PartGenerator;
import human.Client;
import human.Mechanic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.ThreadLocalRandom.current;

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
/*
    public ArrayList<Client> getListOfClientsInterestedInThisCar(Car car) {
        ArrayList<Client> interestedClients = new ArrayList<>();
        for (Client client : Game.potenctalClients
        ) {


            if (client.preferredCarProducers.contains(car.producer) &&
                    client.preferredCarType == car.getClass().toString() &&
                    !isContainBrokenPart("brakes") &&
                    !isContainBrokenPart("engine") &&
                    !isContainBrokenPart("gearbox")) {


            }

        }
        return interestedClients;
    }
*/
    private boolean isContainBrokenPart(String nameArg) {
        return getBrokenPartsList().stream().filter(o -> o.name.equals(nameArg)).findFirst().isPresent();
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + color + " " + value + "zł " + mileage + "km" + partList;
    }

}
