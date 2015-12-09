package rps;

public class RandomPlayer implements Player {
    public Gesture getGesture() {
        return Gesture.ROCK;
    }

    @Override
    public String getName() {
        return null;
    }
}
