package rps;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.SecureRandom;

import static rps.ReplayOption.*;

public class Game {
    private static final int PLAYER_ONE_INDEX = 0;
    private static final int PLAYER_TWO_INDEX = 1;
    private static final String PLAYER_ONE = "Human Player";
    private static final String PLAYER_TWO = "Random Player";
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
        evaluate(
                getGestureFromHumanPlayer(),
                getGestureFromRandomPlayer()
        );
    }

    void evaluate(Gesture gesture1, Gesture gesture2) {
        if (gesture1.matches(gesture2)) {
            prompt.displayDraw();
        } else if (gesture1.strongerThan(gesture2)) {
            prompt.displayWinner(PLAYER_ONE);
        } else {
            prompt.displayWinner(PLAYER_TWO);
        }
    }

    private Gesture getGestureFromHumanPlayer() {
        Player currentPlayer = getCurrentPlayer(PLAYER_ONE_INDEX);
        prompt.promptForGestureFrom(currentPlayer.getName());
        return getGestureFromPlayer(currentPlayer);
    }

    private Gesture getGestureFromRandomPlayer() {
        Player currentPlayer = getCurrentPlayer(PLAYER_TWO_INDEX);
        return getGestureFromPlayer(currentPlayer);
    }

    private Player getCurrentPlayer(int playerIndex) {
        return players[playerIndex];
    }

    private Gesture getGestureFromPlayer(Player currentPlayer) {
        Gesture gesture = currentPlayer.getGesture();
        printGesture(gesture, currentPlayer.getName());
        return gesture;
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
