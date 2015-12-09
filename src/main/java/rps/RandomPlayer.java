package rps;

import java.util.Random;

import static rps.Gesture.getGestures;
import static rps.Gesture.withId;

public class RandomPlayer implements Player {
    private static final int UPPER_BOUND = getGestures().size();
    private String name;
    private Random randomNumberGenerator;

    public RandomPlayer(String name, Random randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Gesture getGesture() {
        return Gesture.withId(1 + randomNumberGenerator.nextInt(UPPER_BOUND));
    }

    @Override
    public String getName() {
        return name;
    }
}
