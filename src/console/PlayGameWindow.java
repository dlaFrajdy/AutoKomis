package console;

import com.company.Game;
import dataGenerator.CarGenerator;
import human.Client;
import human.Mechanic;
import human.Player;
import initialGameResources.MechanicsResources;
import vechicle.Car;
import vechicle.Part;

import java.io.Console;

public class PlayGameWindow {
    public static void playRound(Game game) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        while (game.winner == null) {
            for (Player player : game.playerList
            ) {
                System.out.println("\t\t--- " + player.name.toUpperCase() + "'s turn! ---");
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

                int choice;
                while (true) {
                    choice = ValidationMethods.getValidatedIntAnswer();

                    if (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 ||
                            choice == 7 || choice == 8 || choice == 9 || choice == 10 || choice == 11)
                        break;
                    else
                        System.out.println("Wrong choice! Choose a number from the list again!");
                }
                int choiceCar;
                switch (choice) {
                    case 1 -> {
                        System.out.println("Database of available cars: [type 0 to go back]");
                        printCarsAvailableForPurchase(game);
                        choiceCar = ValidationMethods.getValidatedIntAnswer();
                        if (choiceCar == 0)
                            playRound(game);
                    }
                    case 2 -> {
                        printCarsAvailableForPurchase(game);
                        System.out.println("Enter the car number you want to buy: [type 0 to go back]");
                        while (true) {
                            choiceCar = ValidationMethods.getValidatedIntAnswer();

                            if (choiceCar > game.carsAvailableForPurchase.size() || choiceCar < 0)
                                System.out.println("Wrong choice! Choose a number from the list again!");
                            else
                                break;
                        }
                        if (choiceCar == 0)
                            playRound(game);
                        else {
                            Car playerNewCar = game.carsAvailableForPurchase.get(choiceCar - 1);
                            player.buyCar(playerNewCar);
                            game.carsAvailableForPurchase.remove(playerNewCar);
                            game.carsAvailableForPurchase.add(CarGenerator.getRandomCar());
                            game.currentRound++;


                        }
                    }
                    case 3 -> {
                        System.out.println("Database of owned vehicles: [type 0 to go back]");
                        System.out.println(player.getOwnedCars());
                        choiceCar = ValidationMethods.getValidatedIntAnswer();
                        if (choiceCar == 0)
                            playRound(game);
                    }
                    case 4 -> {
                        printCarsWithBrokenParts(player);
                        System.out.println("Which car do you want to repair?  [type 0 to go back]");
                        choiceCar = ValidationMethods.getValidatedIntAnswer();
                        if (choiceCar == 0)
                            playRound(game);
                        else {

                            Car carToRepair = player.getCarWithBrokenParts().get(choiceCar - 1);

                            System.out.println("Which parts do you want to repair?");

                            printBrokenParts(carToRepair);
                            int partChoice = ValidationMethods.getValidatedIntAnswer();
                            Part partToRepair = carToRepair.getBrokenPartsList().get(partChoice-1);

                            System.out.println("Which mechanic do you choose?");
                            printMechanicsList();
                            int mechanicChoice = ValidationMethods.getValidatedIntAnswer();
                            Mechanic mechanicToRepair = MechanicsResources.availableMechanics.get(mechanicChoice-1);
                            player.repairCar(carToRepair,partToRepair,mechanicToRepair);
                            playRound(game);
                        }
                    }
                    case 5 -> {
                        printClientsList(game);
                        choiceCar = ValidationMethods.getValidatedIntAnswer();
                        if (choiceCar == 0)
                            playRound(game);
                    }
                    default -> System.out.println("Wrong choice! Choose a number from the list again!");
                }

            }
        }

    }

    private static void kupAuto() {

    }

    private static void printCarsAvailableForPurchase(Game game) {
        int index = 0;

        System.out.println("List of cars available for purchase:");

        while (index < game.carsAvailableForPurchase.size()) {
            System.out.println(index + 1 + ". " + game.carsAvailableForPurchase.get(index));
            index++;
        }
    }

    private static void printCarsWithBrokenParts(Player player) {
        int index = 1;
        System.out.println("List of cars with broken parts:");
        for (Car car : player.getCarWithBrokenParts()
        ) {
            System.out.println(index + ". " + car);
            index++;
        }

    }

    private static void printBrokenParts(Car car) {
        int index = 0;

        System.out.println("List of broken parts:");
        for (Part part : car.getBrokenPartsList()
        ) {
            if (part.isBroke)
                System.out.println(index + 1 + ". " + part);
            index++;
        }

    }

    private static void printMechanicsList() {
        int index = 0;

        System.out.println("List of broken parts:");
        for (Mechanic mechanic : MechanicsResources.availableMechanics
        ) {

                System.out.println(index + 1 + ". " + mechanic);
            index++;
        }

    }

    private static void printClientsList(Game game) {
        int index = 0;

        System.out.println("List of potential clients: [type 0 to go back]");
        for (Client client : game.potencialClients
        ) {

            System.out.println(index + 1 + ". " + client);
            index++;
        }

    }

    public static void waitForEnter(String message, Object... args) {
        Console c = System.console();
        if (c != null) {
            // printf-like arguments
            if (message != null)
                c.format(message, args);
            c.format("\nPress ENTER to proceed.\n");
            c.readLine();
        }
    }

}
