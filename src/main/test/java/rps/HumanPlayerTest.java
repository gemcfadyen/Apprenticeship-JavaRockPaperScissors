package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.PAPER;
import static rps.Gesture.ROCK;
import static rps.Gesture.SCISSORS;

public class HumanPlayerTest {

    @Test
    public void userChoosesRock() {
        Player player = new HumanPlayer("", new PromptStub(1));

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(ROCK));
    }

    @Test
    public void userChoosesPaper() {
        Player player = new HumanPlayer("", new PromptStub(2));

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(PAPER));
    }

    @Test
    public void userChoosesScissors() {
        Player player = new HumanPlayer("", new PromptStub(3));

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(SCISSORS));
    }

    @Test
    public void getsName() {

        Player player = new HumanPlayer("Julie", new PromptStub(3));

        assertThat(player.getName(), is("Julie"));
    }
}
