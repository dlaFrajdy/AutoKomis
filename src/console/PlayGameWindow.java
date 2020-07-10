package console;

import com.company.Game;
import com.company.Settings;
import dataGenerator.CarGenerator;
import human.Client;
import human.Player;
import initialGameResources.MechanicsResources;
import vechicle.Car;
import vechicle.Repair;

import javax.swing.*;
import java.util.ArrayList;

public class PlayGameWindow {
    public static void playRound(Game game) {

        while (game.winner == null) {
            for (Player player : game.playerList) {

                int selectedMenuAction;
                int internalActionChoice;


                printSeparator();
                printMainMenu(player);

                while (true) {
                    selectedMenuAction = ValidationMethods.getValidatedIntAnswer();

                    if (selectedMenuAction > 0 && selectedMenuAction <= 11)
                        break;
                    else
                        System.out.println("Wrong choice! Choose a number from the list again!");
                }


                switch (selectedMenuAction) {

                    case 1 -> {
                        printSeparator();
                        System.out.println("List of available cars: [type 0 to go back]\n");
                        printListAsNumbered(game.carsAvailableForPurchase);

                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();

                        if (internalActionChoice != 0) {
                            System.out.println("Enter 0 to return to the menu!");
                            internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        } else
                            playRound(game);

                    }

                    case 2 -> {
                        printSeparator();
                        System.out.println("Enter the car number you want to buy: [type 0 to go back]\n");
                        printListAsNumbered(game.carsAvailableForPurchase);

                        while (true) {
                            internalActionChoice = ValidationMethods.getValidatedIntAnswer();

                            if (internalActionChoice == 0)
                                playRound(game);

                            if (internalActionChoice > game.carsAvailableForPurchase.size())
                                System.out.println("Wrong choice! Choose a number from the list again!");

                            else {
                                Car playerNewCar = game.carsAvailableForPurchase.get(internalActionChoice - 1);
                                if (!player.checkIfCanAffordCar(playerNewCar)) {
                                    System.out.println("Sorry, you don't have enough money! Come back when you check how much money you have..");
                                    if (internalActionChoice != 0) {
                                        System.out.println("Enter 0 to return to the menu!");

                                    }
                                } else {
                                    player.buyCar(playerNewCar);
                                    game.carsAvailableForPurchase.remove(playerNewCar);
                                    game.carsAvailableForPurchase.add(CarGenerator.getRandomCar());
                                    break;
                                }
                            }
                        }
                    }

                    case 3 -> {
                        printSeparator();
                        System.out.println("List of owned vehicles: [type 0 to go back]\n");
                        printListAsNumbered(player.getOwnedCars());

                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();

                        if (internalActionChoice != 0) {
                            System.out.println("Enter 0 to return to the menu!");
                            internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        }
                        playRound(game);
                    }

                    case 4 -> {
                        printSeparator();
                        if (player.getCarWithBrokenParts().isEmpty()) {
                            System.out.println("You don't have damaged cars! [type 0 to go back]");

                            internalActionChoice = ValidationMethods.getValidatedIntAnswer();

                            if (internalActionChoice == 0)
                                playRound(game);
                        }

                        System.out.println("Which car do you want to repair?  [type 0 to go back]\n");
                        printListAsNumbered(player.getCarWithBrokenParts());


                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();

                        if (internalActionChoice == 0)
                            playRound(game);


                        Car carToRepair = player.getCarWithBrokenParts().get(internalActionChoice - 1);

                        System.out.println("Which parts do you want to repair?  [type 0 to go back]");
                        printListAsNumbered(carToRepair.getBrokenPartsList());

                        int partChoice = ValidationMethods.getValidatedIntAnswer();

                        if (partChoice == 0)
                            playRound(game);


                        System.out.println("Which mechanic do you choose?  [type 0 to go back]");
                        printListAsNumbered(MechanicsResources.availableMechanics);

                        int mechanicChoice = ValidationMethods.getValidatedIntAnswer();

                        if (partChoice == 0)
                            playRound(game);


                        player.repairCar(carToRepair,
                                carToRepair.getBrokenPartsList().get(partChoice - 1),
                                MechanicsResources.availableMechanics.get(mechanicChoice - 1));
                        break;

                    }

                    case 5 -> {
                        printSeparator();
                        System.out.println("List of potential clients: [type 0 to go back]\n");
                        printListAsNumbered(Game.potenctalClients);

                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        if (internalActionChoice == 0)
                            playRound(game);
                    }

                    case 6 -> {
                        printSeparator();
                        System.out.println("Which car do you want to sell? [type 0 to go back]");
                        printListAsNumbered(player.getOwnedCars());

                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        Car carToSell = player.getOwnedCars().get(internalActionChoice - 1);

                        System.out.println("Select a person from the list of people interested in buying this car:  [type 0 to go back]");
                        printListAsNumbered(Game.potenctalClients);

                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();

                        if (internalActionChoice == 0)
                            playRound(game);

                        Client potencialClient = Game.potenctalClients.get(internalActionChoice - 1);

                        if (!potencialClient.checkIfAcceptCar(carToSell))
                            System.out.println("Sorry, this customer does not accept the purchase of this car! Type 0 to back and check yours Cars and Clients details!");
                        else {
                            player.sellCar(carToSell, potencialClient);
                        }
                        if (internalActionChoice != 0) {
                            System.out.println("Enter 0 to return to main menu!");
                            internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        }
                    }

                    case 7 -> {
                        printSeparator();
                        System.out.println("Which ad do you want to buy?  [type 0 to go back]");
                        System.out.println("1. Newspaper ad");
                        System.out.println("2. Internet Ad");


                        while (true) {
                            internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                            if (internalActionChoice == 0)
                                playRound(game);
                            if (internalActionChoice == 1) {
                                player.buyNewspaperAd(game);
                                break;
                            }
                            if (internalActionChoice == 2) {
                                player.buyInternetAd(game);
                                break;
                            } else
                                System.out.println("Wrong choice! Choose a number from the list again!");
                        }

                    }

                    case 8 -> {
                        printSeparator();
                        System.out.println("Cash: " + player.getCash());
                        System.out.println("\n[type 0 to go back]");
                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        if (internalActionChoice == 0)
                            playRound(game);
                    }

                    case 9 -> {
                        printSeparator();
                        System.out.println("Transaction history: [type 0 to go back]");
                        printListAsNumbered(player.getTransactionsHistory());
                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        if (internalActionChoice == 0)
                            playRound(game);
                    }

                    case 10 -> {
                        printSeparator();
                        int index = 1;
                        if (player.getOwnedCars().isEmpty())
                            System.out.println("You don't have any cars, so you didn't fix anything. [type 0 to go back]");

                        for (Car car : player.getOwnedCars()
                        ) {
                            System.out.println(index + ". " + car + " repair history: [type 0 to go back]");
                            if (car.getRepairHistory().isEmpty())
                                System.out.println("\tThis car has not been repaired");
                            else
                                for (Repair repair : car.getRepairHistory()
                                ) {
                                    System.out.println("\t" + repair);
                                }
                        }


                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        if (internalActionChoice == 0)
                            playRound(game);
                    }
                    case 11 -> {
                        printSeparator();
                        System.out.println("Sum of repair and washing costs: [type 0 to go back]");
                        System.out.println(player.getSumOfRepairAndWashingCosts());
                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();
                        if (internalActionChoice == 0)
                            playRound(game);
                        System.out.println(player.getSumOfRepairAndWashingCosts());
                    }
                    default -> System.out.println("Wrong choice! Choose a number from the list again!");
                }
                if (player.getCash() >= Settings.defaultPlayerCashAmount) {
                    System.out.println("CONGRATULATIONS " + player.firstName.toUpperCase() + " ! YOU WIN IN " + game.currentRound + "round !!!");
                    game.winner = player;
                }
                game.currentRound++;
            }
        }
    }


    private static void printMainMenu(Player player) {
        System.out.println("\t\t----- Player: " + player.firstName.toUpperCase() + " || cash: " + player.getCash() + " || No. of cars: " + player.getOwnedCars().size() + "-----\n");
        System.out.println("1. Browse the list of cars available for purchase");
        System.out.println("2. Buy a car");
        System.out.println("3. Browse your cars");
        System.out.println("4. Repair the car.");
        System.out.println("5. Browse potential clients");
        System.out.println("6. Sell a car");
        System.out.println("7. Buy an ad");
        System.out.println("8. Check account balance");
        System.out.println("9. Check transaction history");
        System.out.println("10. Check the repair history of each vehicle");
        System.out.println("11. Check the sum of repair and washing costs");
        System.out.println("Choose the number of action:");
    }

    private static void printListAsNumbered(ArrayList arrayList) {
        int index = 0;
        while (index < arrayList.size()) {
            System.out.println(index + 1 + ". " + arrayList.get(index));
            index++;
        }
    }

    private static void printSeparator() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
/*
    private static void backIfType0(Game game){
        int internalActionChoice = ValidationMethods.getValidatedIntAnswer();

        if (internalActionChoice != 0) {
            System.out.println("Enter 0 to return to the menu!");
            internalActionChoice = ValidationMethods.getValidatedIntAnswer();
        }
    }
    
 */
}
