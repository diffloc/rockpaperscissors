package rockpaperscissors;

import java.util.Random;

public class Player {

    private String name;
    private String gesture;
    private int score;

    public Player() {
        this.score = 0;
    }

    public String getGesture() {
        return this.gesture;
    }

    public void setGesture(String gesture) {
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

    public void generateComputerGesture(String[] gestures) {
        Random random = new Random();
        this.gesture = gestures[random.nextInt(gestures.length)];
        // this.gesture = Gesture.values()[random.nextInt(3)];
    }
}
