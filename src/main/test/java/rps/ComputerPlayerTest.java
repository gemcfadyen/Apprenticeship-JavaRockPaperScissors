package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.*;

public class ComputerPlayerTest {

    @Test
    public void generatesRock() {
        Player player = new ComputerPlayer("", new GestureIdGeneratorStub(ROCK.getId()));

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(ROCK));
    }

    @Test
    public void generatesPaper() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(PAPER.getId());
        Player player = new ComputerPlayer("", gestureIdGenerator);

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(PAPER));
    }

    @Test
    public void generateScissors() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(SCISSORS.getId());
        Player player = new ComputerPlayer("", gestureIdGenerator);

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(SCISSORS));
    }

    @Test
    public void getsId() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(SCISSORS.getId());
        Player player = new ComputerPlayer("Robot", gestureIdGenerator);

        String name = player.getName();

        assertThat(name, is("Robot"));
    }
}
