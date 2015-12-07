package rps;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static rps.ReplayOption.*;

public class Game {
    private static final int PLAYER_ONE_INDEX = 0;
    private static final int PLAYER_TWO_INDEX = 1;
    private static final String PLAYER_ONE = "Player one ";
    private static final String PLAYER_TWO = "Player two ";
    private static final String DRAW = "Draw";
    private static final String WON = "won";
    private final Prompt prompt;
    private Player[] players;

    public Game(Prompt prompt, Player[] players) {
        this.prompt = prompt;
        this.players = players;
    }

    public static void main(String... args) {
        GestureIdGenerator gestureIdGenerator = null;
        Game game = new Game(buildPrompt(), new Player[]{new HumanPlayer(PLAYER_ONE, buildPrompt()), new ComputerPlayer(PLAYER_TWO, gestureIdGenerator)});
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
                getGestureFrom(PLAYER_ONE_INDEX),
                getGestureFrom(PLAYER_TWO_INDEX)
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

    private Gesture getGestureFrom(int playerIndex) {
        Player currentPlayer = players[playerIndex];
        prompt.promptForGestureFrom(currentPlayer.getName());
        return currentPlayer.getGesture();
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
