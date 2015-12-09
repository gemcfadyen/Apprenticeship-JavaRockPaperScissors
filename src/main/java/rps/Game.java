package rps;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.SecureRandom;

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
        CommandLinePrompt prompt = buildPrompt();
        Game game = new Game(
                prompt,
                createPlayers(prompt)
        );

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
                getGestureFromHuman(),
                getGestureFromRandom()
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

    private Gesture getGestureFromRandom() {
        Player currentPlayer = getCurrentPlayer(PLAYER_TWO_INDEX);
        Gesture gesture = getGestureFromPlayer(currentPlayer);

        return gesture;
    }

    private Gesture getGestureFromPlayer(Player currentPlayer) {
        Gesture gesture = getGestureFrom(currentPlayer);
        printGesture(gesture, currentPlayer.getName());
        return gesture;
    }

    private Gesture getGestureFromHuman() {
        Player currentPlayer = getCurrentPlayer(PLAYER_ONE_INDEX);
        prompt.promptForGestureFrom(currentPlayer.getName());
        Gesture gesture = getGestureFromPlayer(currentPlayer);

        return gesture;
    }

    private Player getCurrentPlayer(int playerIndex) {
        return players[playerIndex];
    }

    private Gesture getGestureFrom(Player currentPlayer) {
        return currentPlayer.getGesture();
    }

    private void printGesture(Gesture gesture, String playerName) {
        prompt.displayChosenMove(gesture, playerName);
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

    private static Player[] createPlayers(CommandLinePrompt prompt) {
        return new Player[]{new HumanPlayer(PLAYER_ONE, prompt), new RandomPlayer(PLAYER_TWO, new SecureRandom())};
    }
}
