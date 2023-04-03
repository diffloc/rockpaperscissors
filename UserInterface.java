package rockpaperscissors;

import java.io.*;
import java.util.Scanner;

public class UserInterface {

    private final Player human;
    private final Player computer;

    public UserInterface () {
        this.human = new Player();
        this.computer = new Player();
    }

    public void run(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        human.setName(name);
        inputPlayerGesture(scanner);
    }

    public void inputPlayerGesture(Scanner scanner) {
        System.out.printf("Hello, %s\n", human.getName());

        // printFile();
        loadScore();
        while (true) {
            String playerGesture = scanner.nextLine();
            if (playerGesture.equals(("!exit"))) {
                System.out.println("Bye!");
                break;
            } else if (playerGesture.equals(("!rating"))) {
                System.out.printf("Your rating: %s\n", human.getScore());
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


    public void loadScore() {
        String pathToFile = ("rating.txt");
        // String pathToFile = ("./Rock-Paper-Scissors (Java)/task/src/rockpaperscissors/rating.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[0].equals(human.getName())) {
                    human.setScore(Integer.parseInt(parts[1]));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void validateWinner() {
        if (human.getGesture().equals(computer.getGesture())) {
            System.out.printf("There is a draw (%s)\n", computer.getGesture().toString().toLowerCase());
            human.addScore(50);
        } else if (computer.getGesture().equals(human.getGesture().getOpposite())) {
            System.out.printf("Sorry, but the computer chose %s\n", computer.getGesture().toString().toLowerCase());
        } else {
            System.out.printf("Well done. The computer chose %s and failed\n", computer.getGesture().toString().toLowerCase());
            human.addScore(100);
        }
    }
}
