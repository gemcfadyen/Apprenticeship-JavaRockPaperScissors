package rps;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.ROCK;

public class PromptTest {

    @Test
    public void promptPlayerForInput() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader(""), writer);
        prompt.promptForGestureFrom("Player abc");

        assertThat(writer.toString(), is("Player abc - please enter:\n1 for ROCK\n2 for PAPER\n3 for SCISSORS\n"));
    }

    @Test(expected = WriteException.class)
    public void exceptionThrownWhenErrorWritingToPrompt() {
        Prompt prompt = new CommandLinePrompt(new StringReader(""), new StringWriterStub());
        prompt.promptForGestureFrom("Player one");
    }

    @Test
    public void displaysStatus() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader(""), writer);
        prompt.display("Winner");
        assertThat(writer.toString(), is("Winner"));
    }

    @Test
    public void readsInputFromPlayer() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader("1"), writer);
        Gesture gesture = prompt.readInput();
        assertThat(gesture, is(Gesture.ROCK));
    }
}
