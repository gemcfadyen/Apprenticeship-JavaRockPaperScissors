package rps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import static rps.Gesture.*;

public class CommandLinePrompt implements Prompt {
    private final BufferedReader reader;
    private final Writer writer;

    public CommandLinePrompt(Reader reader, Writer writer) {
        this.reader = new BufferedReader(reader);
        this.writer = writer;
    }

    @Override
    public void promptForGestureFrom(String playerId) {
        String message = playerId + " - please enter:\n" + formatGesturesForPrompt();
        write(message);
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

    private String formatGesturesForPrompt() {
        Gesture[] gestures = values();
        String optionsForDisplay = "";
        for (int gestureNumber = 0; gestureNumber < gestures.length; gestureNumber++) {
            optionsForDisplay += gestures[gestureNumber].getId() + " for " + gestures[gestureNumber].name();
            optionsForDisplay = optionallyAddNewLineCharacter(optionsForDisplay, gestureNumber);
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
        return gestureNumber < values().length - 1;
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
        for (Gesture gesture : values()) {
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
