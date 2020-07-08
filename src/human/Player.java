package human;

import dataGenerator.CarGenerator;
import vechicle.Car;
import vechicle.Part;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    public String name;
    private double cash;
    private ArrayList<Car> ownedCars;


    private final double defaultPlayerCash = 150000.0;

    public Player(String name) {
        this.name = name;
        this.cash = defaultPlayerCash;

        this.ownedCars = new ArrayList<>();
    }

    public void buyCar(Car car) {
        ownedCars.add(car);
    }

    public ArrayList<Car> getOwnedCars() {
        return this.ownedCars;
    }

    public ArrayList<Car> getCarWithBrokenParts() {
        ArrayList<Car> carWithBrokenParts = new ArrayList<>();
        for (Car car : this.getOwnedCars()
        ) {
            if (!car.getBrokenPartsList().isEmpty())
                carWithBrokenParts.add(car);
        }
        return carWithBrokenParts;
    }

    public void repairCar(Car car, Part part, Mechanic mechanic) {
        double repairCost;
        if (mechanic.name.equals("Janusz")) {
            repairCost = part.materialsCost * mechanic.repairPriceRate;
            part.isBroke = false;
            System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
            this.cash -= repairCost;
        }

        int chance = ThreadLocalRandom.current().nextInt(100);
        if (mechanic.name.equals("Marian"))
            if (chance <= mechanic.chanceForFailedRepair)
                System.out.println("Marian didn't repair the car. You must use Janusz's services in the next round!");
            else {
                repairCost = part.materialsCost * mechanic.repairPriceRate;
                part.isBroke = false;
                System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
                this.cash -= repairCost;
            }

        if (mechanic.name.equals("Adrian")){
            if (chance < mechanic.chanceToDestroyAnotherPart && !car.getWorkingPartsList().isEmpty()){
                int partIndexToBeBroken = ThreadLocalRandom.current().nextInt(car.getWorkingPartsList().size());
                car.getWorkingPartsList().get(partIndexToBeBroken).isBroke = true;
            }
            else if(chance < mechanic.chanceForFailedRepair){
                System.out.println("Adrian didn't repair the car. You must use Janusz's services in the next round!");
            }
            else {
                repairCost = part.materialsCost * mechanic.repairPriceRate;
                part.isBroke = false;
                this.cash -= repairCost;
                System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
            }
        }


    }


}
