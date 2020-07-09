package console;

import com.company.Game;
import dataGenerator.CarGenerator;
import human.Player;
import initialGameResources.MechanicsResources;
import vechicle.Car;

import java.util.ArrayList;

public class PlayGameWindow {
    public static void playRound(Game game) {


        while (game.winner == null) {
            for (Player player : game.playerList
            ) {
                int selectedMenuAction;
                int internalActionChoice;
                printSeparator();
                printMainMenu(player);

                while (true) {
                    selectedMenuAction = ValidationMethods.getValidatedIntAnswer();

                    if (selectedMenuAction == 1 || selectedMenuAction == 2 || selectedMenuAction == 3 || selectedMenuAction == 4 || selectedMenuAction == 5 || selectedMenuAction == 6 ||
                            selectedMenuAction == 7 || selectedMenuAction == 8 || selectedMenuAction == 9 || selectedMenuAction == 10 || selectedMenuAction == 11)
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

                        if (internalActionChoice == 0)
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
                                player.buyCar(playerNewCar);
                                game.carsAvailableForPurchase.remove(playerNewCar);
                                game.carsAvailableForPurchase.add(CarGenerator.getRandomCar());
                                game.currentRound++;
                                break;
                            }
                        }
                    }

                    case 3 -> {
                        printSeparator();
                        System.out.println("List of owned vehicles: [type 0 to go back]\n");
                        System.out.println(player.getOwnedCars());

                        internalActionChoice = ValidationMethods.getValidatedIntAnswer();

                        if (internalActionChoice == 0)
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
                        //
                        //
                        //  DOKONCZYC
                        //
                        //
                        ////player.sellCar(carToSell, );
                        playRound(game);
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
                            if (internalActionChoice == 1){
                                player.buyNewspaperAd(game);
                                break;
                            }
                            if (internalActionChoice == 2){
                                player.buyInternetAd(game);
                                break;
                            }
                            else
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

                    case 10 -> printSeparator();
                    default -> System.out.println("Wrong choice! Choose a number from the list again!");
                }

            }
            game.currentRound++;
        }

    }


    private void printClientsInterestedInCar(Car car) {

    }

    private static void printMainMenu(Player player) {
        System.out.println("\t\t----- Player: " + player.firstName.toUpperCase() + " || cash: " + player.getCash() + " || No. of cars: " + player.getOwnedCars().size() + " -----\n");
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
