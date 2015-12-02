package rps;

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PromptTest {

    @Test
    public void promptPlayerOneForInput() {
        StringWriter writer = new StringWriter();
        Prompt prompt = new CommandLinePrompt(new StringReader(""), writer);
        prompt.promptPlayerOneForGesture();

        assertThat(writer.toString(), is("Player one - please enter:\n1 for ROCK\n2 for PAPER\n3 for SCISSORS\n"));
    }

    @Test(expected = WriteException.class)
    public void exceptionThrownWhenErrorWritingToPrompt() {
        Prompt prompt = new CommandLinePrompt(new StringReader(""), new StringWriterStub());
        prompt.promptPlayerOneForGesture();
    }
}
