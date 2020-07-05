package com.company;

import dataGenerator.CarGenerator;
import dataGenerator.ClientGenerator;
import human.Player;
import initialGameResources.CarResources;
import initialGameResources.ClientDataResources;
import vechicle.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        Car car = CarGenerator.GetDrawnCar();
        Car car2 = CarGenerator.GetDrawnCar();
        Car car3 = CarGenerator.GetDrawnCar();
        Car car4 = CarGenerator.GetDrawnCar();

        System.out.println(car);
        System.out.println(car2);
        System.out.println(car3);
        System.out.println(car4);


    }
}
