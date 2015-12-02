package rps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

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
        write(status);
    }

    @Override
    public Gesture readValidGestureFrom(String playerId) {
        String userInput = readInput();

        while (!valid(userInput)) {
            promptForGestureFrom(playerId);
            userInput = readInput();
        }

        return Gesture.withId(Integer.valueOf(userInput));
    }

    private boolean valid(String input) {

        return isInteger(input) && isValidGestureId(Integer.valueOf(input));
    }

    private boolean isValidGestureId(int numericInput) {
        for (Gesture gesture : Gesture.values()) {
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

    private String readInput() {
        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    private String formatGesturesForPrompt() {
        Gesture[] gestures = Gesture.values();
        String optionsForDisplay = "";
        for (Gesture gesture : gestures) {
            optionsForDisplay += gesture.getId() + " for " + gesture.name() + "\n";
        }
        return optionsForDisplay;
    }

    private void write(String message) {
        try {
            writer.write(message);
        } catch (IOException e) {
            throw new WriteException(e);
        }
    }
}
