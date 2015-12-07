package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.PAPER;
import static rps.Gesture.ROCK;
import static rps.Gesture.SCISSORS;

public class ComputerPlayerTest {

    @Test
    public void generatesRock() {
        Player player = new ComputerPlayer("", new GestureIdGeneratorStub(ROCK.getId()));

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(ROCK));
    }

    @Test
    public void generatesPaper() {
        Player player = new ComputerPlayer("", new GestureIdGeneratorStub(PAPER.getId()));

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(PAPER));
    }

    @Test
    public void generateScissors() {
        Player player = new ComputerPlayer("", new GestureIdGeneratorStub(SCISSORS.getId()));

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(SCISSORS));
    }

    @Test
    public void getsId() {
        Player player = new ComputerPlayer("Robot", new GestureIdGeneratorStub(SCISSORS.getId()));

        String name = player.getName();

        assertThat(name, is("Robot"));
    }
}
