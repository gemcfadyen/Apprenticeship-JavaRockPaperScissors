package rps;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CommandLinePrompt implements Prompt {
    private final Reader reader;
    private final Writer writer;

    public CommandLinePrompt(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void promptPlayerOneForGesture() {
        String message = "Player one - please enter:\n" + formatGesturesForPrompt();
        write(message);
    }

    @Override
    public Gesture readInput() {
        return null;
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
