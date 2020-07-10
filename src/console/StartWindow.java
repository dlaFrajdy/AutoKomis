package console;

import com.company.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StartWindow {
    public static Game printMainMenu() {
        System.out.println(
                "   #    #     # ####### #######             #    # ####### #     # ###  #####  \n" +
                "  # #   #     #    #    #     #             #   #  #     # ##   ##  #  #     # \n" +
                " #   #  #     #    #    #     #             #  #   #     # # # # #  #  #       \n" +
                "#     # #     #    #    #     #    #####    ###    #     # #  #  #  #   #####  \n" +
                "####### #     #    #    #     #             #  #   #     # #     #  #        # \n" +
                "#     # #     #    #    #     #             #   #  #     # #     #  #  #     # \n" +
                "#     #  #####     #    #######             #    # ####### #     # ###  #####  ");
        System.out.println("\n\t\t\t\t\t\t\t1. Single player.");
        System.out.println("\t\t\t\t\t\t\t2. Multi player");
        // System.out.println("\t\t\t\t\t\t\t0. Settings"); w budowie :)
        System.out.println("\n\t\t\t\t\tWrite choice number and confirm..");

        int choice;
        while(true){
            choice = ValidationMethods.getValidatedIntAnswer();

            if (choice ==1 || choice == 2 || choice ==0)
                break;
            else
                System.out.println("Wrong choice! Choose a number from the list again!");
        }

        Game game = null;

        switch (choice) {
            case 1 -> game = new Game(getPlayersName(1));
            case 2 -> game = new Game(getPlayersName(getNumberOfPlayers()));
            //case 0 ->
            default -> System.out.println("Wrong choice! Choose a number from the list again!");
        }
        return game;
    }



    private static ArrayList<String> getPlayersName(int numberOfPlayers){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> currentList = new ArrayList<>();

        for(int i=0; i<numberOfPlayers; i++ ){
            System.out.println("Enter Player name:");
            currentList.add(scanner.nextLine());
        }
        return currentList;
    }

    private static int getNumberOfPlayers(){
        System.out.println("Choose the number of players:");
        return ValidationMethods.getValidatedIntAnswer();
    }
}



