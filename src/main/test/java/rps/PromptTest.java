package rps;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.PAPER;
import static rps.Gesture.ROCK;
import static rps.ReplayOption.Y;

public class PromptTest {

    @Test
    public void promptPlayerForInput() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader(""), writer);
        prompt.promptForGestureFrom("Player abc");

        assertThat(writer.toString(), is("Player abc - please enter:\n1 for ROCK\n2 for PAPER\n3 for SCISSORS\n"));
    }

    @Test
    public void displaysStatus() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader(""), writer);
        prompt.display("Winner");
        assertThat(writer.toString(), is("Winner\n"));
    }

    @Test
    public void readsInputFromPlayer() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader("1"), writer);
        Gesture gesture = prompt.readValidGestureFrom("player one");
        assertThat(gesture, is(ROCK));
        assertThat(writer.toString(), is(""));
    }

    @Test
    public void repromptsUserWhenTheyEnterNonNumericInput() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader("abc\n2"), writer);
        Gesture gesture = prompt.readValidGestureFrom("Player one");
        assertThat(writer.toString(), is("Player one - please enter:\n1 for ROCK\n2 for PAPER\n3 for SCISSORS\n"));
        assertThat(gesture, is(PAPER));
    }

    @Test
    public void repromptsUserWhenTheyEnterANumberOutsideOfGestureRange() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader("7\n2"), writer);
        Gesture gesture = prompt.readValidGestureFrom("Player one");
        assertThat(writer.toString(), is("Player one - please enter:\n1 for ROCK\n2 for PAPER\n3 for SCISSORS\n"));
        assertThat(gesture, is(PAPER));
    }

    @Test
    public void promptsUserToReplay() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader(""), writer);
        prompt.promptForReplay();

        assertThat(writer.toString(), is("Enter Y to replay\n"));

    }

    @Test
    public void readsReplayOption() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader("Y"), writer);
        ReplayOption replayOption = prompt.readValidReplayOption();
        assertThat(replayOption, is(Y));
        assertThat(writer.toString(), is(""));
    }

    @Test(expected = WriteException.class)
    public void exceptionThrownWhenErrorWritingToPrompt() {
        Prompt prompt = new CommandLinePrompt(new StringReader(""), new StringWriterStub());
        prompt.promptForGestureFrom("Player one");
    }

    @Test(expected = ReadException.class)
    public void exceptionThrownWhenErrorReading() {
        Prompt prompt = new CommandLinePrompt(new StringReaderStub(), new StringWriter());
        prompt.readValidGestureFrom("Player one");
    }
}
