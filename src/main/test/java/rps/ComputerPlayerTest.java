package rps;

import org.junit.Test;

import java.io.StringWriter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.PAPER;
import static rps.Gesture.ROCK;
import static rps.Gesture.SCISSORS;

public class ComputerPlayerTest {

    private PromptSpy prompt = new PromptSpy(new StringWriter());

    @Test
    public void generatesRock() {
        Player player = new ComputerPlayer(prompt, "", new GestureIdGeneratorStub(ROCK.getId()));

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(ROCK));
    }

    @Test
    public void generatesPaper() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(PAPER.getId());
        Player player = new ComputerPlayer(prompt, "", gestureIdGenerator);

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(PAPER));
    }

    @Test
    public void generateScissors() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(SCISSORS.getId());
        Player player = new ComputerPlayer(prompt, "", gestureIdGenerator);

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(SCISSORS));
    }

    @Test
    public void getsId() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(SCISSORS.getId());
        Player player = new ComputerPlayer(prompt, "Robot", gestureIdGenerator);

        String name = player.getName();

        assertThat(name, is("Robot"));
    }

    @Test
    public void displaysComputerChoice() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(SCISSORS.getId());
        Player player = new ComputerPlayer(prompt, "Robot", gestureIdGenerator);

        player.getGesture();

        assertThat(prompt.getMessageDisplayed(), is("Robot chose 3 - SCISSORS"));
    }
}
