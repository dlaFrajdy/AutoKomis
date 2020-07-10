package human;

import com.company.Game;
import com.company.Settings;
import dataGenerator.ClientGenerator;
import initialGameResources.CarResources;
import transaction.PurchaseTransaction;
import transaction.SaleTransaction;
import transaction.Transaction;
import vechicle.Car;
import vechicle.Part;
import vechicle.Repair;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Person {
    private double cash;
    private ArrayList<Car> ownedCars;
    private ArrayList<Transaction> transactionsHistory;
    private double sumOfRepairAndWashingCosts;


    public Player(String firstName) {
        this.firstName = firstName;
        this.cash = Settings.defaultPlayerCashAmount;
        this.sumOfRepairAndWashingCosts = 0;

        this.ownedCars = new ArrayList<>();
        this.transactionsHistory = new ArrayList<>();
    }


    public double getCash() {
        return cash;
    }

    public ArrayList<Car> getOwnedCars() {
        return this.ownedCars;
    }

    public double getSumOfRepairAndWashingCosts() {
        return sumOfRepairAndWashingCosts;
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

    public ArrayList<Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }

    public void addTransactionToHistory(Transaction transaction) {
        this.transactionsHistory.add(transaction);
    }


    public void buyCar(Car car) {
        washCar();
        payTax(car);

        ownedCars.add(car);
        this.cash -= car.value;

        addTransactionToHistory(new PurchaseTransaction(car.value, car));

        Game.potenctalClients.add(ClientGenerator.generateClient());
        Game.potenctalClients.add(ClientGenerator.generateClient());
    }

    public void sellCar(Car car, Client client) {
        washCar();
        payTax(car);

        this.ownedCars.remove(car);
        this.cash += car.value;

        addTransactionToHistory(new SaleTransaction(client, car.value, car));

        Game.potenctalClients.add(ClientGenerator.generateClient());
        Game.potenctalClients.add(ClientGenerator.generateClient());
    }

    public void repairCar(Car car, Part part, Mechanic mechanic) {
        double repairCost = 0;
        Part destroyedPart = null;
        boolean isRepairFailed = false;

        if (mechanic.firstName.equals("Janusz")) {
            repairCost = part.materialsCost * mechanic.repairPriceRate / 100.0;

            if (repairCost > this.cash)
                System.out.println("You have no money for it!");
            else{
                part.isBroke = false;
                this.cash -= repairCost;
                car.value *= 1 + part.increaseCarValueRate;

                System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
            }

        }

        int chance = ThreadLocalRandom.current().nextInt(100);
        if (mechanic.firstName.equals("Marian"))
            if (chance <= mechanic.chanceForFailedRepair) {
                System.out.println("Marian didn't repair the car. You must use Janusz's services in the next round!");
                isRepairFailed = true;
            } else {
                if (repairCost > this.cash)
                    System.out.println("You have no money for it!");
                else {
                    repairCost = part.materialsCost * mechanic.repairPriceRate / 100.0;
                    part.isBroke = false;
                    System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
                    this.cash -= repairCost;
                    car.value *= 1 + part.increaseCarValueRate;
                }
            }

        if (mechanic.firstName.equals("Adrian")) {
            if (chance < mechanic.chanceToDestroyAnotherPart && !car.getWorkingPartsList().isEmpty()) {
                int partIndexToBeBroken = ThreadLocalRandom.current().nextInt(car.getWorkingPartsList().size());
                destroyedPart = car.getWorkingPartsList().get(partIndexToBeBroken);
                car.getWorkingPartsList().get(partIndexToBeBroken).isBroke = true;
                System.out.println("Marian didn't repair the car. You must use Janusz's services in the next round!");
                isRepairFailed = true;
            } else if (chance < mechanic.chanceForFailedRepair) {
                System.out.println("Marian didn't repair the car. You must use Janusz's services in the next round!");
                isRepairFailed = true;
            } else {
                if (repairCost > this.cash)
                    System.out.println("You have no money for it!");
                else {
                    repairCost = part.materialsCost * mechanic.repairPriceRate / 100.0;
                    part.isBroke = false;
                    this.cash -= repairCost;
                    car.value *= 1 + part.increaseCarValueRate;
                    System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
                }

            }
        }
        sumOfRepairAndWashingCosts += repairCost;
        car.addRepairToHistory(new Repair(repairCost, part, destroyedPart, mechanic, isRepairFailed));
    }


    public void buyNewspaperAd(Game game) {
        this.cash -= Settings.newspaperAdPrice;
        game.increaseNumberOfPotencialClients(ThreadLocalRandom.current().nextInt(1, 9));
    }

    public void buyInternetAd(Game game) {
        this.cash -= Settings.internetAdPrice;
        game.increaseNumberOfPotencialClients(1);
    }


    private void payTax(Car car) {
        this.cash -= car.value * Settings.tax / 100.0;
    }

    private void washCar() {
        this.sumOfRepairAndWashingCosts += Settings.washingCost;
    }

    public boolean checkIfCanAffordCar(Car car) {
        return !(car.value > this.getCash());
    }


}
