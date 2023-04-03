package rockpaperscissors;

import java.util.Random;

public class Player {

    private String name;
    private Gesture gesture;
    private int score;

    public Player() {

        // this.name = name;
    }

    public Gesture getGesture() {
        return this.gesture;
    }

    public void setGesture(Gesture gesture) {
        this.gesture = gesture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return this.name; }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public void generateComputerGesture() {
        Random random = new Random();
        this.gesture = Gesture.values()[random.nextInt(3)];
    }
}
