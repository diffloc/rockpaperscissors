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
    }

    public void inputPlayerGesture(Scanner scanner) {
        // System.out.println("Available gestures: " + Gesture.getAvailableGestures());
        // System.out.print("Enter your gesture: ");
        while (true) {
            String playerGesture = scanner.nextLine();
            if (playerGesture.equals(("!exit"))) {
                System.out.println("Bye!");
                break;
            } else {
                try {
                    human.setGesture(Gesture.valueOf(playerGesture.toUpperCase()));
                } catch (IllegalArgumentException e) {
                    System.out.print("Invalid input");
                }
                computer.generateComputerGesture();
                validateWinner();
            }
        }
    }

    public void validateWinner() {
        if (human.getGesture().equals(computer.getGesture())) {
            System.out.printf("There is a draw (%s)\n", computer.getGesture().toString().toLowerCase());
        } else if (computer.getGesture().equals(human.getGesture().getOpposite())) {
            System.out.printf("Sorry, but the computer chose %s\n", computer.getGesture().toString().toLowerCase());
        } else {
            System.out.printf("Well done. The computer chose %s and failed\n", computer.getGesture().toString().toLowerCase());
        }
    }
}
