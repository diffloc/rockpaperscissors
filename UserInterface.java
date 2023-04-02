package rockpaperscissors;

import java.util.Scanner;

public class UserInterface {

    private final Player human;
    private final Player computer;

    public UserInterface () {
        this.human = new Player("Human");
        this.computer = new Player("Computer");
    }

    public void run(Scanner scanner) {
        inputPlayerGesture(scanner);
        computer.generateComputerOption(human);
        validateWinner();
    }

    public void inputPlayerGesture(Scanner scanner) {
        // System.out.println("Available options: " + Gesture.getAvailableOptions());
        // System.out.print("Enter your option: ");
        String playerGesture = scanner.nextLine();
        try {
            human.setGesture(Gesture.valueOf(playerGesture.toUpperCase()));
        } catch (IllegalArgumentException e) {
            System.out.printf("Invalid option: %s\n", playerGesture.equals("") ? "NULL" : playerGesture);
        }
    }

    public void validateWinner() {
        if (human.getGesture().equals(computer.getGesture())) {
            System.out.println("draw");
        } else if (computer.getGesture().equals(human.getGesture().getOpposite())) {
            System.out.printf("Sorry, but the computer chose %s", computer.getGesture().toString().toLowerCase());
        } else {
            System.out.println("YOU WIN!");
        }
    }
}
