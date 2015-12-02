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
        try {
            writer.write("Player one - please enter:\n1 for Rock\n2 for Paper\n3 for Scissors\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
