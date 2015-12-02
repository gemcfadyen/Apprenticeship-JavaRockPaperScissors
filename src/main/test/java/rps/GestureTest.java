package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.PAPER;
import static rps.Gesture.ROCK;
import static rps.Gesture.SCISSORS;

public class GestureTest {
    @Test
    public void getRockGestureFromId() {
        Gesture gesture = Gesture.withId(1);
        assertThat(gesture, is(ROCK));
    }

    @Test
    public void getPaperGestureFromId() {
        Gesture gesture = Gesture.withId(2);
        assertThat(gesture, is(PAPER));
    }

    @Test
    public void getScissorsGestureFromId() {
        Gesture gesture = Gesture.withId(3);
        assertThat(gesture, is(SCISSORS));
    }


}
