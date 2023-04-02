package rockpaperscissors;

import java.util.HashMap;
import java.util.Map;

public enum Options {

    ROCK, PAPER, SCISSORS;

    private static final Map<Options, Options> OPPOSITES = new HashMap<>();
    static {
        OPPOSITES.put(ROCK, PAPER);
        OPPOSITES.put(PAPER, SCISSORS);
        OPPOSITES.put(SCISSORS, ROCK);
    }

    public Options getOpposite() {
        return OPPOSITES.get(this);
    }
}
