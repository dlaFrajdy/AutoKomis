package human;

import com.company.Game;
import initialGameResources.CarResources;
import transaction.PurchaseTransaction;
import transaction.SaleTransaction;
import transaction.Transaction;
import vechicle.Car;
import vechicle.Part;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Player extends Person {
    private double cash;
    private ArrayList<Car> ownedCars;
    private ArrayList<Transaction> transactionsHistory;


    private final double defaultPlayerCash = 120000.0;

    public Player(String firstName) {
        this.firstName = firstName;
        this.cash = defaultPlayerCash;

        this.ownedCars = new ArrayList<>();
        this.transactionsHistory = new ArrayList<>();
    }

    public void addTransactionToHistory(Transaction transaction) {
        this.transactionsHistory.add(transaction);
    }

    public ArrayList<Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }

    public double getCash() {
        return cash;
    }

    public void buyCar(Car car) {
        ownedCars.add(car);
        addTransactionToHistory(new PurchaseTransaction(car.value, car));
        this.cash -= car.value;
    }

    public void sellCar(Car car, Client client) {
        if (client.getCash() < car.value)

            this.ownedCars.remove(car);
        this.cash += car.value;
        addTransactionToHistory(new SaleTransaction(client, car.value, car));
    }

    public void buyNewspaperAd(Game game) {
        this.cash -= 500;
        game.increaseNumberOfPotencialClients(ThreadLocalRandom.current().nextInt(1, 9));
    }

    public void buyInternetAd(Game game) {
        this.cash -= 200;
        game.increaseNumberOfPotencialClients(1);
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
        double currentIncreaseCarValueRate;

        if (mechanic.firstName.equals("Janusz")) {
            repairCost = part.materialsCost * mechanic.repairPriceRate;
            part.isBroke = false;
            System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
            this.cash -= repairCost;
            car.value *= 1 + part.increaseCarValueRate;
        }

        int chance = ThreadLocalRandom.current().nextInt(100);
        if (mechanic.firstName.equals("Marian"))
            if (chance <= mechanic.chanceForFailedRepair)
                System.out.println("Marian didn't repair the car. You must use Janusz's services in the next round!");
            else {
                repairCost = part.materialsCost * mechanic.repairPriceRate;
                part.isBroke = false;
                System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
                this.cash -= repairCost;
                car.value *= 1 + part.increaseCarValueRate;
            }

        if (mechanic.firstName.equals("Adrian")) {
            if (chance < mechanic.chanceToDestroyAnotherPart && !car.getWorkingPartsList().isEmpty()) {
                int partIndexToBeBroken = ThreadLocalRandom.current().nextInt(car.getWorkingPartsList().size());
                car.getWorkingPartsList().get(partIndexToBeBroken).isBroke = true;
            } else if (chance < mechanic.chanceForFailedRepair) {
                System.out.println("Adrian didn't repair the car. You must use Janusz's services in the next round!");
            } else {
                repairCost = part.materialsCost * mechanic.repairPriceRate;
                part.isBroke = false;
                this.cash -= repairCost;
                car.value *= 1 + part.increaseCarValueRate;
                System.out.println("Part repaired. The cost of the service is " + repairCost + ".");
            }
        }


    }


}
