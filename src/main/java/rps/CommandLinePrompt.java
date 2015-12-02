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
    public Gesture readInput() {
        String input = "";

        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Gesture.withId(Integer.valueOf(input));
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
