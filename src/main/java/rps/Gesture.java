package rps;

public enum Gesture {
    ROCK(1), PAPER(2), SCISSORS(3);

    private final int id;

    Gesture(int id) {
        this.id = id;
    }

    public static Gesture withId(int id) {
        if (id == 1) {
            return ROCK;
        } else if (id == 2) {
            return PAPER;
        } else if (id == 3) {
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

    private boolean paperWrapsRock(Gesture gesture) {
        return gesture == PAPER && id == ROCK.id;
    }

    private boolean scissorsCutPaper(Gesture gesture) {
        return gesture == SCISSORS && id == PAPER.id;
    }

    private boolean rockBluntsScissors(Gesture gesture) {
        return gesture == ROCK && id == SCISSORS.id;
    }

    public boolean matches(Gesture gesture) {
        return id == gesture.getId();
    }
}

