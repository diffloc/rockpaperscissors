package rockpaperscissors;

import java.util.Random;

public class Player {

    private final String name;
    private Gesture gesture;

    public Player(String name) {
        this.name = name;
    }

    public Gesture getGesture() {
        return this.gesture;
    }

    public void setGesture(Gesture gesture) {
        this.gesture = gesture;
    }

    public String getName() { return name; }

    public void generateComputerGesture() {
        Random random = new Random();
        this.gesture = Gesture.values()[random.nextInt(3)];
    }
}
