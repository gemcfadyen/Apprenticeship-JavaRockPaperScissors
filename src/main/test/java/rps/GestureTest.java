package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
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

    @Test
    public void getIdOfRock() {
        assertThat(ROCK.getId(), is(1));
    }

    @Test
    public void getIdOfPaper() {
        assertThat(PAPER.getId(), is(2));
    }

    @Test
    public void getIdOfScissors() {
        assertThat(SCISSORS.getId(), is(3));
    }

    @Test
    public void twoRocksMatch() {
        assertThat(ROCK.isSameAs(ROCK), is(true));
    }

    @Test
    public void twoPapersMatch() {
        assertThat(PAPER.isSameAs(PAPER), is(true));
    }

    @Test
    public void twoScissorsMatch() {
        assertThat(SCISSORS.isSameAs(SCISSORS), is(true));
    }

    @Test
    public void rockDoesNotMatchPaper() {
        assertThat(ROCK.isSameAs(PAPER), is(false));
    }

    @Test
    public void rockDoesNotMatchScissors() {
        assertThat(ROCK.isSameAs(SCISSORS), is(false));
    }

    @Test
    public void paperDoesNotMatchRock() {
        assertThat(PAPER.isSameAs(ROCK), is(false));
    }

    @Test
    public void paperDoesNotMatchScissors() {
        assertThat(PAPER.isSameAs(SCISSORS), is(false));
    }

    @Test
    public void scissorsDoesNotMatchRock() {
        assertThat(SCISSORS.isSameAs(ROCK), is(false));
    }

    @Test
    public void scissorsDoesNotMatchPaper() {
        assertThat(SCISSORS.isSameAs(PAPER), is(false));
    }

    @Test
    public void getGestures() {
        assertThat(Gesture.gestures(), contains(ROCK, PAPER, SCISSORS));
    }

    @Test
    public void getNumberOfGestures() {
        assertThat(Gesture.numberOfGestures(), is(3));
    }

    @Test(expected = InvalidGestureException.class)
    public void throwsExceptionIfInvalidGestureId() {
        Gesture.withId(4);
    }
}
