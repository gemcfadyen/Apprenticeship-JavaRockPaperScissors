package rps;

public class Game {
    private final Prompt prompt;

    public Game(Prompt prompt) {
        this.prompt = prompt;
    }

    public void play() {
        prompt.promptPlayerOneForGesture();
        Gesture gesture  = prompt.readInput();

    }

    String evaluate(Gesture gesture1, Gesture gesture2) {
        if (gesture1.matches(gesture2)) {
            return "Draw";
        }
        if (gesture1.strongerThan(gesture2)) {
            return "Player 1 won";
        }

        return "Player 2 won";
    }
}
