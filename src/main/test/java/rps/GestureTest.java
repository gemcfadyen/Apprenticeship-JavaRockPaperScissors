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

    @Test
    public void rockBeatsScissors() {
        assertThat(ROCK.strongerThan(SCISSORS), is(true));
    }

    @Test
    public void paperBeatsRock() {
        assertThat(PAPER.strongerThan(ROCK), is(true));
    }

    @Test
    public void scissorsBeatsPaper() {
        assertThat(SCISSORS.strongerThan(PAPER), is(true));
    }

    @Test
    public void rockLoosesOverPaper() {
        assertThat(ROCK.strongerThan(PAPER), is(false));
    }

    @Test
    public void paperLoosesOverScissors() {
        assertThat(PAPER.strongerThan(SCISSORS), is(false));
    }

    @Test
    public void scissorsLoosesOverRock() {
       assertThat(SCISSORS.strongerThan(ROCK), is(false));
    }
}
