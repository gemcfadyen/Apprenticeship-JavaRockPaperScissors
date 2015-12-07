package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.ROCK;

public class HumanPlayerTest {

    @Test
    public void readsInputFromPrompt() {
        Prompt prompt = new PromptStub(1);
        Player player = new HumanPlayer(prompt);

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(ROCK));
    }

}
