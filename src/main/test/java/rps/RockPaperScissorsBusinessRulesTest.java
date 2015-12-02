package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorsBusinessRulesTest {
    private enum Gesture {
        ROCK, PAPER, SCISSORS
    }

    @Test
    public void playingRockAsFirstGestureAgainstScissorsWins() {
        Gesture winningGesture = play(Gesture.ROCK, Gesture.SCISSORS);

        assertThat(winningGesture, is(Gesture.ROCK));
    }

    @Test
    public void playingRockAsSecondGestureAgainstScissorsWins() {
        Gesture winningGesture = play(Gesture.SCISSORS, Gesture.ROCK);

        assertThat(winningGesture, is(Gesture.ROCK));
    }

    @Test
    public void playingScissorsAsFirstGestureAgainstPaperWins() {
        Gesture winningGesture = play(Gesture.SCISSORS, Gesture.PAPER);

        assertThat(winningGesture, is(Gesture.SCISSORS));
    }

    @Test
    public void playingScissorsAsSecondGestureAgainstPaperWins() {
        Gesture winningGesture = play(Gesture.PAPER, Gesture.SCISSORS);

        assertThat(winningGesture, is(Gesture.SCISSORS));
    }

    @Test
    public void playingPaperAsFirstGestureAgainstRockWins() {
        Gesture winningGesture = play(Gesture.PAPER, Gesture.ROCK);

        assertThat(winningGesture, is(Gesture.PAPER));
    }

    @Test
    public void playingPaperAsSecondGestureAgainstRockWins() {
        Gesture winningGesture = play(Gesture.PAPER, Gesture.ROCK);

        assertThat(winningGesture, is(Gesture.PAPER));
    }

    private Gesture play(Gesture gesture1, Gesture gesture2) {
        if (gesture1.equals(Gesture.ROCK) && !gesture2.equals(Gesture.PAPER)) {
            return gesture1;
        } else if (gesture2.equals(Gesture.ROCK) && !gesture1.equals(Gesture.PAPER)) {
            return gesture2;
        } else if (gesture1.equals(Gesture.PAPER) && gesture2.equals(Gesture.ROCK)) {
            return gesture1;
        } else if(gesture1.equals(Gesture.SCISSORS) && gesture2.equals(Gesture.PAPER)) {
            return gesture1;
        }
        return gesture2;
    }
}
