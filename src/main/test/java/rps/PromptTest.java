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

        assertThat(writer.toString(), is("Player one - please enter:\n1 for Rock\n2 for Paper\n3 for Scissors\n"));
    }
}