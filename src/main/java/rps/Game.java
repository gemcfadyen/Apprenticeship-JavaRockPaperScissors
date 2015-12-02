package rps;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static rps.ReplayOption.*;

public class Game {
    public static final String PLAYER_ONE = "Player one ";
    public static final String PLAYER_TWO = "Player two ";
    private final Prompt prompt;

    public Game(Prompt prompt) {
        this.prompt = prompt;
    }

    public static void main(String... args) {
        Prompt commandLinePrompt = new CommandLinePrompt(new InputStreamReader(System.in), new OutputStreamWriter(System.out));
        Game game = new Game(commandLinePrompt);
        game.play();
    }

    public void play() {
        ReplayOption replayOption = Y;

        while (replayOption.equals(Y)) {
            singleRound();
            prompt.promptForReplay();
            replayOption = prompt.readValidReplayOption();
        }
    }

    void singleRound() {
        prompt.promptForGestureFrom(PLAYER_ONE);
        Gesture playerOneGesture = prompt.readValidGestureFrom(PLAYER_ONE);

        prompt.promptForGestureFrom(PLAYER_TWO);
        Gesture playerTwoGesture = prompt.readValidGestureFrom(PLAYER_TWO);

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
