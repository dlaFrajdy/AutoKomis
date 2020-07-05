package dataGenerator;

import initialGameResources.CarResources;
import vechicle.Car;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public final class CarGenerator {


    public static Car getRandomCar() {
        int randomIndex = ThreadLocalRandom.current().nextInt(CarResources.carDatabase.size());
        return CarResources.carDatabase.get(randomIndex);
    }

    public static ArrayList<Car> getCarStartList() {
        ArrayList<Car> startList = new ArrayList<>();
        int i = 1;
        while (i <= 15) {
            startList.add(getRandomCar());
            i++;
        }
        return startList;
    }
}
