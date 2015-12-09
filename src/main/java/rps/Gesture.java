package rps;

public enum Gesture {
    ROCK(1), PAPER(2), SCISSORS(3);

    private final int id;

    Gesture(int id) {
        this.id = id;
    }

    public static Gesture withId(int gestureId) {
        if (gestureId == 1) {
            return ROCK;
        } else if (gestureId == 2) {
            return PAPER;
        } else if (gestureId == 3) {
            return SCISSORS;
        }
        throw new InvalidGestureException();
    }

    public boolean strongerThan(Gesture gesture) {
        return !paperWrapsRock(gesture)
                && !scissorsCutPaper(gesture)
                && !rockBluntsScissors(gesture);
    }

    public int getId() {
        return id;
    }

    public boolean matches(Gesture gesture) {
        return getId() == gesture.getId();
    }

    private boolean paperWrapsRock(Gesture gesture) {
        return evaluate(gesture, PAPER, ROCK);
    }

    private boolean scissorsCutPaper(Gesture gesture) {
        return evaluate(gesture, SCISSORS, PAPER);
    }

    private boolean rockBluntsScissors(Gesture gesture) {
        return evaluate(gesture, ROCK, SCISSORS);
    }

    private boolean evaluate(Gesture gesture, Gesture strongerGesture, Gesture weakerGesture) {
        return gesture == strongerGesture && getId() == weakerGesture.getId();
    }
}

