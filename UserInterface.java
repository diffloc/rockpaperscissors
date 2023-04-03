package rockpaperscissors;

import java.io.*;
import java.util.Scanner;

public class UserInterface {

    private final Player human;
    private final Player computer;
    private String[] gestures;

    public UserInterface () {
        this.human = new Player();
        this.computer = new Player();
    }

    public void run(Scanner scanner) {
        initializePlayer(scanner);
        initializeGame(scanner);
        play(scanner);
    }

    public void initializePlayer(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        human.setName(name);
        System.out.printf("Hello, %s\n", human.getName());
        loadScore();
    }

    public void initializeGame(Scanner scanner) {
        System.out.println("Enter your gesture list:");
        String userGestures = scanner.nextLine();
        if (userGestures.equals("")) {
            userGestures = "rock,paper,scissors";
        }
        gestures = userGestures.split(",");
        System.out.println("Okay, let's start");
    }

    public void play(Scanner scanner) {

        while (true) {
            String playerGesture = scanner.nextLine();
            if (playerGesture.equals(("!exit"))) {
                System.out.println("Bye!");
                break;
            } else if (playerGesture.equals(("!rating"))) {
                System.out.printf("Your rating: %s\n", human.getScore());
            } else {
                boolean validGesture = false;
                for (String string: gestures) {
                        if (playerGesture.equals(string)) {
                            validGesture = true;
                            break;
                        }
                    }
                if (validGesture) {
                    human.setGesture(playerGesture);
                    computer.generateComputerGesture(gestures);
                } else {
                    System.out.println("Invalid input");
                }
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
        int humanIndex = -1;
        int computerIndex = -1;
        for (int i = 0; i < gestures.length; i++) {
            if (gestures[i].equals(human.getGesture())) {
                humanIndex = i;
                break;
            }
        }
        for (int i = 0; i < gestures.length; i++) {
            if (gestures[i].equals(computer.getGesture())) {
                computerIndex = i;
                break;
            }
        }

        int halfLength = (gestures.length - 1) / 2;
        int indexDiff = (computerIndex - humanIndex + gestures.length) % gestures.length;
        if (indexDiff == 0) {
            System.out.printf("There is a draw (%s)\n", computer.getGesture());
            human.addScore(50);
        } else if (indexDiff <= halfLength) {
            System.out.printf("Sorry, but the computer chose %s\n", computer.getGesture());
        } else {
            System.out.printf("Well done. The computer chose %s and failed\n", computer.getGesture());
            human.addScore(100);
        }
    }


}
