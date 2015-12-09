package rps;

import java.util.Random;

public class RandomPlayer implements Player {
    private static final int NUMBER_OF_GESTURES = Gesture.numberOfGestures();
    private String name;
    private Random randomNumberGenerator;

    public RandomPlayer(String name, Random randomNumberGenerator) {
        this.name = name;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public Gesture getGesture() {
        return Gesture.withId(generateGestureId());
    }

    @Override
    public String getName() {
        return name;
    }

    private int generateGestureId() {
        return 1 + randomNumberGenerator.nextInt(NUMBER_OF_GESTURES);
    }
}
