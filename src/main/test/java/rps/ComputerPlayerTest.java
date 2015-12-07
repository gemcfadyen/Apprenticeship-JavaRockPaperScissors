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
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(ROCK.getId());
        Player player = new ComputerPlayer(gestureIdGenerator);

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(ROCK));
    }

    @Test
    public void generatesPaper() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(PAPER.getId());
        Player player = new ComputerPlayer(gestureIdGenerator);

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(PAPER));
    }

    @Test
    public void generateScissors() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGeneratorStub(SCISSORS.getId());
        Player player = new ComputerPlayer(gestureIdGenerator);

        Gesture gesture = player.getGesture();

        assertThat(gesture, is(SCISSORS));
    }
}
