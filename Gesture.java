package rockpaperscissors;

import java.util.HashMap;
import java.util.Map;

public enum Gesture {

    ROCK, PAPER, SCISSORS;

    private static final Map<Gesture, Gesture> OPPOSITES = new HashMap<>();
    static {
        OPPOSITES.put(ROCK, PAPER);
        OPPOSITES.put(PAPER, SCISSORS);
        OPPOSITES.put(SCISSORS, ROCK);
    }

    public Gesture getOpposite() {
        return OPPOSITES.get(this);
    }

    public static String getAvailableOptions() {
        StringBuilder sb = new StringBuilder();
        Gesture[] gestures = Gesture.values();
        for (int i = 0; i < gestures.length; i++) {
            sb.append(gestures[i]);
            if (i < gestures.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
