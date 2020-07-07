package dataGenerator;

import human.Client;
import initialGameResources.CarResources;
import initialGameResources.ClientDataResources;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ClientGenerator {

    private final static double minCash = 15000.0;
    private final static double maxCash = 150000.0;
    private final static double startingClientsNumber = 20;
    private final static int percentageClientsPreferringPassengerCars = 70;
    private final static int percentageClientsAcceptingDamagedCars = 20;
    private final static int percentageClientsAcceptingDamagedSuspension = 40;

    public static ArrayList<Client> getClientsStartList() {
        ArrayList<Client> startList = new ArrayList<>();
        int i = 1;
        while (i <= startingClientsNumber) {
            startList.add(generateClient());
            i++;
        }
        return startList;
    }

    public static Client generateClient() {
        return new Client(getRandomFirstName(), getRandomLastName(), getRandomCash(), getPreferredCarProducers(), getPreferredCarType(), getRandomAgreementToDamagedCar(), getRandomAgreementToDamagedSuspension());
    }

    private static String getRandomFirstName() {
        return ClientDataResources.firstNames[ThreadLocalRandom.current().nextInt(ClientDataResources.firstNames.length)];
    }

    private static String getRandomLastName() {
        return ClientDataResources.lastNames[ThreadLocalRandom.current().nextInt(ClientDataResources.lastNames.length)];
    }

    private static double getRandomCash() {

        return Math.round(ThreadLocalRandom.current().nextDouble(minCash, maxCash)) / 1000 * 1000;
    }

    private static List<String> getPreferredCarProducers() {
        ArrayList<String> tempList = new ArrayList<>();
        do {
            tempList.add(CarResources.allCarProducers.get(ThreadLocalRandom.current().nextInt(CarResources.allCarProducers.size())));
        } while (tempList.size() < 2);
        return tempList;
    }


    private static String getPreferredCarType() {
        int rnd = ThreadLocalRandom.current().nextInt(10);
        if (rnd < percentageClientsPreferringPassengerCars / 10)
            return "PassengerCar";
        else
            return "TruckCar";
    }

    private static boolean getRandomAgreementToDamagedCar() {
        return ThreadLocalRandom.current().nextInt(10) < percentageClientsAcceptingDamagedCars / 10;
    }

    private static boolean getRandomAgreementToDamagedSuspension() {
        return ThreadLocalRandom.current().nextInt(10) < percentageClientsAcceptingDamagedSuspension / 10;
    }

}
