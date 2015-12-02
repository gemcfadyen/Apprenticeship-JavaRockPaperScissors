package rps;

public class Game {
    public String play(Gesture gesture1, Gesture gesture2) {
        if (gesture1.strongerThan(gesture2)) {
            return "player 1 won";
        }
        return "player 2 won";
    }
}
