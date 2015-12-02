package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.*;

public class RockPaperScissorsBusinessRulesTest {

    @Test
    public void playingRockAsFirstGestureAgainstScissorsWins() {
        Gesture winningGesture = RockPaperScissorsRulesEngine.play(ROCK, SCISSORS);
        assertThat(winningGesture, is(ROCK));
    }

    @Test
    public void playingRockAsSecondGestureAgainstScissorsWins() {
        Gesture winningGesture = RockPaperScissorsRulesEngine.play(SCISSORS, ROCK);
        assertThat(winningGesture, is(ROCK));
    }

    @Test
    public void playingScissorsAsFirstGestureAgainstPaperWins() {
        Gesture winningGesture = RockPaperScissorsRulesEngine.play(SCISSORS, PAPER);
        assertThat(winningGesture, is(SCISSORS));
    }

    @Test
    public void playingScissorsAsSecondGestureAgainstPaperWins() {
        Gesture winningGesture = RockPaperScissorsRulesEngine.play(PAPER, SCISSORS);
        assertThat(winningGesture, is(SCISSORS));
    }

    @Test
    public void playingPaperAsFirstGestureAgainstRockWins() {
        Gesture winningGesture = RockPaperScissorsRulesEngine.play(PAPER, ROCK);
        assertThat(winningGesture, is(PAPER));
    }

    @Test
    public void playingPaperAsSecondGestureAgainstRockWins() {
        Gesture winningGesture = RockPaperScissorsRulesEngine.play(PAPER, ROCK);
        assertThat(winningGesture, is(PAPER));
    }
}
