package rps;

import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.PAPER;
import static rps.Gesture.ROCK;
import static rps.ReplayOption.Y;

public class PromptTest {
    private StringWriter writer;
    private Prompt prompt;
    private StringReader defaultReader;

    @Before
    public void setup() {
        defaultReader = new StringReader("");
        writer = new StringWriter();
        prompt = new CommandLinePrompt(defaultReader, writer);
    }

    @Test
    public void promptPlayerForInput() {
        prompt.promptForGestureFrom("Player abc");

        assertThat(writer.toString(), is("Player abc - please enter:\n1 for ROCK\n2 for PAPER\n3 for SCISSORS\n"));
    }

    @Test
    public void displaysStatus() {
        prompt.display("Winner");

        assertThat(writer.toString(), is("Winner\n"));
    }

    @Test
    public void readsInputFromPlayer() {
        Prompt prompt = new CommandLinePrompt(readerWithInput("1\n"), writer);

        Gesture gesture = prompt.readValidGestureFrom("player one");

        assertThat(gesture, is(ROCK));
        assertThat(writer.toString(), is(""));
    }

    @Test
    public void repromptsUserWhenTheyEnterNonNumericInput() {
        Prompt prompt = new CommandLinePrompt(readerWithInput("abc\n2"), writer);

        Gesture gesture = prompt.readValidGestureFrom("Player one");

        assertThat(writer.toString(), is("Player one - please enter:\n1 for ROCK\n2 for PAPER\n3 for SCISSORS\n"));
        assertThat(gesture, is(PAPER));
    }

    @Test
    public void repromptsUserWhenTheyEnterANumberOutsideOfGestureRange() {
        Prompt prompt = new CommandLinePrompt(readerWithInput("7\n2"), writer);

        Gesture gesture = prompt.readValidGestureFrom("Player one");

        assertThat(writer.toString(), is("Player one - please enter:\n1 for ROCK\n2 for PAPER\n3 for SCISSORS\n"));
        assertThat(gesture, is(PAPER));
    }

    @Test
    public void promptsUserToReplay() {
        prompt.promptForReplay();

        assertThat(writer.toString(), is("Enter Y to replay\n"));
    }

    @Test
    public void readsReplayOption() {
        Prompt prompt = new CommandLinePrompt(readerWithInput("Y"), writer);

        ReplayOption replayOption = prompt.readValidReplayOption();

        assertThat(replayOption, is(Y));
        assertThat(writer.toString(), is(""));
    }

    @Test(expected = WriteException.class)
    public void exceptionThrownWhenErrorWritingToPrompt() {
        Prompt prompt = new CommandLinePrompt(defaultReader, new StringWriterStub());
        prompt.promptForGestureFrom("Player one");
    }

    @Test(expected = ReadException.class)
    public void exceptionThrownWhenErrorReading() {
        Prompt prompt = new CommandLinePrompt(new StringReaderStub(), writer);
        prompt.readValidGestureFrom("Player one");
    }

    private Reader readerWithInput(String userInput) {
        return new StringReader(userInput);
    }
}
