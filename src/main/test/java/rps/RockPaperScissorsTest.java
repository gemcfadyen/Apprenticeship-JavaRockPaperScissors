package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorsTest {
    private enum Gesture {
        ROCK, PAPER, SCISSORS
    }

    @Test
    public void playingRockAsFirstGestureAgainstScissorsWins() {
        String rock = "Rock";

        String winner = play(Gesture.ROCK.name(), Gesture.SCISSORS.name());

        assertThat(winner, is(rock));
    }

    @Test
    public void playingRockAsSecondGestureAgainstScissorsWins() {
        String rock = "Rock";

        String winner = play(Gesture.SCISSORS.name(), Gesture.ROCK.name());

        assertThat(winner, is(rock));
    }

    @Test
    public void playingScissorsAsFirstGestureAgainstPaperWins() {
        String scissors = "Scissors";

        String winner = play(Gesture.ROCK.name(), Gesture.PAPER.name());

        assertThat(winner, is(scissors));

    }

    @Test
    public void playingScissorsAsSecondGestureAgainstPaperWins() {
        String scissors = "Scissors";

        String winner = play(Gesture.PAPER.name(), Gesture.SCISSORS.name());

        assertThat(winner, is(scissors));

    }

    @Test
    public void playingPaperAsFirstGestureAgainstRockWins() {
        String paper = "Paper";

        String winner = play(Gesture.PAPER.name(), Gesture.ROCK.name());

        assertThat(winner, is(paper));
    }

    private String play(String gesture1, String gesture2) {
        if (gesture1.equalsIgnoreCase("Rock") &&
                !gesture2.equalsIgnoreCase("Paper")) {
            return "Rock";
        } else if (gesture2.equalsIgnoreCase("Rock") && !gesture1.equalsIgnoreCase("Paper")) {
            return "Rock";
        } else if (gesture1.equalsIgnoreCase("Paper") && gesture2.equalsIgnoreCase("Rock")) {
            return "Paper";
        }
        return "Scissors";
    }


}
