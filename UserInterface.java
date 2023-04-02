package rockpaperscissors;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner;

    public UserInterface () {
        this.scanner = new Scanner(System.in);
    }

    public void run() {

        Options option = null;
        String userOption = scanner.nextLine();
        try {
            option = Options.valueOf(userOption.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.printf("Invalid option: %s\n", userOption);
        }

        if (option != null) {
            Options computerOption = option.getOpposite();
            System.out.printf("Sorry, but the computer chose %s", computerOption.toString().toLowerCase());
        }
    }
}
