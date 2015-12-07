package rps;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static rps.ReplayOption.*;

public class Game {
    private static final String PLAYER_ONE = "Player one ";
    private static final String PLAYER_TWO = "Player two ";
    private static final String DRAW = "Draw";
    private static final String WON = "won";
    private final Prompt prompt;

    public Game(Prompt prompt) {
        this.prompt = prompt;
    }

    public static void main(String... args) {
        Game game = new Game(buildPrompt());
        game.play();
    }

    public void play() {
        ReplayOption replayOption = Y;

        while (replayOption.equals(Y)) {
            playSingleRound();
            replayOption = getReplayOption();
        }
    }

    void playSingleRound() {
        String status = evaluate(
                getGestureFrom(PLAYER_ONE),
                getGestureFrom(PLAYER_TWO)
        );

        prompt.display(status);
    }

    String evaluate(Gesture gesture1, Gesture gesture2) {
        if (gesture1.matches(gesture2)) {
            return DRAW;
        }

        if (gesture1.strongerThan(gesture2)) {
            return PLAYER_ONE + WON;
        }

        return PLAYER_TWO + WON;
    }

    private Gesture getGestureFrom(String playerId) {
        prompt.promptForGestureFrom(playerId);
        return prompt.readValidGestureFrom(playerId);
    }

    private ReplayOption getReplayOption() {
        prompt.promptForReplay();
        return prompt.readValidReplayOption();
    }

    private static CommandLinePrompt buildPrompt() {
        return new CommandLinePrompt(
                new InputStreamReader(System.in),
                new OutputStreamWriter(System.out)
        );
    }
}
