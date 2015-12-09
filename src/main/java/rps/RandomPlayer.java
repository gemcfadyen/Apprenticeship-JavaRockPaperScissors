package rps;

import java.util.Random;

public class RandomPlayer implements Player {
    private Random randomNumberGenerator;

    public RandomPlayer(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Gesture getGesture() {
        return Gesture.withId(randomNumberGenerator.nextInt());
    }

    @Override
    public String getName() {
        return null;
    }
}
