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


    @Test(expected = InvalidGestureException.class)
    public void getExceptionFromInvalidId() {
        Gesture gesture = Gesture.withId(4);
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
        assertThat(ROCK.matches(ROCK), is(true));
    }

    @Test
    public void twoPapersMatch() {
        assertThat(PAPER.matches(PAPER), is(true));
    }

    @Test
    public void twoScissorsMatch() {
        assertThat(SCISSORS.matches(SCISSORS), is(true));
    }

    @Test
    public void rockDoesNotMatchPaper() {
        assertThat(ROCK.matches(PAPER), is(false));
    }

    @Test
    public void rockDoesNotMatchScissors() {
        assertThat(ROCK.matches(SCISSORS), is(false));
    }

    @Test
    public void paperDoesNotMatchRock() {
        assertThat(PAPER.matches(ROCK), is(false));
    }

    @Test
    public void paperDoesNotMatchScissors() {
        assertThat(PAPER.matches(SCISSORS), is(false));
    }

    @Test
    public void scissorsDoesNotMatchRock() {
        assertThat(SCISSORS.matches(ROCK), is(false));
    }

    @Test
    public void scissorsDoesNotMatchPaper() {
        assertThat(SCISSORS.matches(PAPER), is(false));
    }
}
