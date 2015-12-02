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
        }
        return SCISSORS;
    }

    public boolean strongerThan(Gesture gesture) {
        if (gesture == PAPER && id == 1) {
            return false;
        }
        if (gesture == SCISSORS && id == 2) {
            return false;
        }

        if (gesture == ROCK && id == 3) {
            return false;
        }

        return true;
    }

    public boolean matches(Gesture gesture) {
        return id == gesture.getId();
    }

    public int getId() {
        return id;
    }
}

