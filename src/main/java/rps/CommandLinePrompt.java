package rps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import static rps.Gesture.gestures;
import static rps.Gesture.withId;

public class CommandLinePrompt implements Prompt {
    private final BufferedReader reader;
    private final Writer writer;

    public CommandLinePrompt(Reader reader, Writer writer) {
        this.reader = new BufferedReader(reader);
        this.writer = writer;
    }

    @Override
    public void promptForGestureFrom(String playerId) {
        write(playerId + " - please enter:\n" + formatGesturesForPrompt());
    }

    @Override
    public void display(String status) {
        write(status + newLine());
    }

    @Override
    public Gesture readValidGestureFrom(String playerId) {
        String userInput = readInput();

        while (!valid(userInput)) {
            promptForGestureFrom(playerId);
            userInput = readInput();
        }

        return transformToGesture(userInput);
    }

    @Override
    public void promptForReplay() {
        write("Enter " + ReplayOption.Y + " to replay");
    }

    @Override
    public ReplayOption readValidReplayOption() {
        return ReplayOption.of(readInput());
    }

    @Override
    public void displayChosenMove(Gesture gesture, String name) {
        write(name + " chose " + gesture.getId() + " - " + gesture.name());
    }

    @Override
    public void displayWinner(String winnerName) {
        write(winnerName + " won");
    }

    @Override
    public void displayDraw() {
        write("Draw");
    }

    private String formatGesturesForPrompt() {
            List<Gesture> gestures = gestures();
        String optionsForDisplay = "";
        for (Gesture gesture : gestures) {
            optionsForDisplay += gesture.getId() + " for " + gesture.name();
            optionsForDisplay = optionallyAddNewLineCharacter(optionsForDisplay, gesture.getId());
        }
        return optionsForDisplay;
    }

    private String optionallyAddNewLineCharacter(String optionsForDisplay, int gestureNumber) {
        if (lastLine(gestureNumber)) {
            optionsForDisplay += newLine();
        }
        return optionsForDisplay;
    }

    private boolean lastLine(int gestureNumber) {
        return gestureNumber < Gesture.numberOfGestures();
    }

    private void write(String message) {
        try {
            writer.write(message + newLine());
            writer.flush();
        } catch (IOException e) {
            throw new WriteException(e);
        }
    }

    private String newLine() {
        return "\n";
    }

    private String readInput() {
        String input;
        try {
            input = reader.readLine();
        } catch (IOException e) {
            throw new ReadException(e);
        }
        return input;
    }

    private boolean valid(String input) {
        return isInteger(input) && isValidGestureId(Integer.valueOf(input));
    }

    private Gesture transformToGesture(String userInput) {
        return withId(Integer.valueOf(userInput));
    }

    private boolean isValidGestureId(int numericInput) {
        for (Gesture gesture : gestures()) {
            if (gesture.getId() == numericInput) {
                return true;
            }
        }
        return false;
    }

    private boolean isInteger(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
