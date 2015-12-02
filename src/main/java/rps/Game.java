package rps;

public class Game {
    public static final String PLAYER_ONE = "Player one ";
    public static final String PLAYER_TWO = "Player two ";
    private final Prompt prompt;

    public Game(Prompt prompt) {
        this.prompt = prompt;
    }

    public void play() {
        prompt.promptForGestureFrom(PLAYER_ONE);
        Gesture playerOneGesture = prompt.readInput();

        prompt.promptForGestureFrom(PLAYER_TWO);
        Gesture playerTwoGesture = prompt.readInput();

        String status = evaluate(playerOneGesture, playerTwoGesture);

        prompt.display(status);
    }

    String evaluate(Gesture gesture1, Gesture gesture2) {
        if (gesture1.matches(gesture2)) {
            return "Draw";
        }
        if (gesture1.strongerThan(gesture2)) {
            return PLAYER_ONE + "won";
        }

        return PLAYER_TWO + "won";
    }
}
