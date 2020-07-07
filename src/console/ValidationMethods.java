package console;

import java.util.Scanner;

public class ValidationMethods {
    public static int getValidatedIntAnswer() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Enter a number, not a letter or a sign!");
            }
        }
        return choice;
    }
}
