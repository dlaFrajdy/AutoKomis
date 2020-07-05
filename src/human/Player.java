package human;

import dataGenerator.CarGenerator;
import vechicle.Car;

import java.util.ArrayList;

public class Player {
    public String name;
    private double cash;
    private ArrayList<Car> ownedCars;
    private ArrayList<Car> carsAvailableForPurchase;

    private final double defaultPlayerCash = 150000.0;

    public Player(String name){
        this.name = name;
        this.cash = defaultPlayerCash;
        carsAvailableForPurchase = CarGenerator.GetCarStartList();
        this.ownedCars = new ArrayList<>();
    }




}
