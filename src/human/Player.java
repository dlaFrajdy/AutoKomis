package human;

import dataGenerator.CarGenerator;
import vechicle.Car;

import java.util.ArrayList;

public class Player {
    public String name;
    private double cash;
    private ArrayList<Car> ownedCars;


    private final double defaultPlayerCash = 150000.0;

    public Player(String name){
        this.name = name;
        this.cash = defaultPlayerCash;

        this.ownedCars = new ArrayList<>();
    }

    public void buyCar(Car car){
        ownedCars.add(car);
    }

    public ArrayList<Car> getOwnedCars(){
        return this.ownedCars;
    }

    public ArrayList<Car> getCarWithBrokenParts(){
        ArrayList<Car> carWithBrokenParts = new ArrayList<>();
        for (Car car : this.getOwnedCars()
        ) {
            if (!car.getBrokenPartsList().isEmpty())
                carWithBrokenParts.add(car);
        }
        return carWithBrokenParts;
    }
}
