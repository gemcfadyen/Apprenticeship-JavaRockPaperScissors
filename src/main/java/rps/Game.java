package rps;

public class Game {
    public String play(Gesture gesture1, Gesture gesture2) {
        if(gesture1.matches(gesture2)) {
            return "Draw";
        }
        if (gesture1.strongerThan(gesture2)) {
            return "Player 1 won";
        }

        return "Player 2 won";
    }
}
