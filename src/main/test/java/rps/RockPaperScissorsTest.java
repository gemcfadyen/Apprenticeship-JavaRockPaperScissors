package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorsTest {

    @Test
    public void playingRockAsFirstGestureAgainstScissorsWins() {
        String rock = "Rock";
        String scissors = "Scissors";

        String winner = play(rock, scissors);

        assertThat(winner, is(rock));
    }


    @Test
    public void playingRockAsSecondGestureAgainstScissorsWins() {
        String scissors = "Scissors";
        String rock = "Rock";

        String winner = play(scissors, rock);

        assertThat(winner, is(rock));
    }

    @Test
    public void playingScissorsAsFirstGestureAgainstPaperWins() {
        String scissors = "Scissors";
        String paper = "Paper";

        String winner = play(scissors, paper);

        assertThat(winner, is(scissors));

    }

    private String play(String gesture1, String gesture2) {
        if (gesture1.equals("Rock") || gesture2.equals("Rock")) {
            return "Rock";
        } else {
            return "Scissors";
        }
    }

}
