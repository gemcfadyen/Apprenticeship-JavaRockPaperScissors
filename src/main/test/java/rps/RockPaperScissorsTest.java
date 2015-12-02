package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RockPaperScissorsTest {

    @Test
    public void rockBeatsScissors() {
        String rock = "Rock";
        String scissors = "Scissors";

        String winner = play(rock, scissors);

        assertThat(winner, is(rock));
    }

    private String play(String gesture1, String gesture2) {
        return "Rock";
    }

}
