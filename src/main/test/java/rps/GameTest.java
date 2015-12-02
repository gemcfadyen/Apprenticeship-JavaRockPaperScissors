package rps;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.PAPER;
import static rps.Gesture.ROCK;
import static rps.Gesture.SCISSORS;

public class GameTest {

    private Game game;

    @Before
    public void setup() {
        game = new Game();
    }

    @Test
    public void firstPlayerChoosesRockWhichBeatsSecondPlayerChoosingScissors() {
        String status = game.play(ROCK, SCISSORS);

        assertThat(status, is("player 1 won"));
    }

    @Test
    public void firstPlayerChoosesScissorsWhichLoosesAgainstSecondPlayerChoosingRock() {
        String status = game.play(SCISSORS, ROCK);

        assertThat(status, is("player 2 won"));
    }

    @Test
    public void firstPlayerChoosesScissorsWhichBeatsSecondPlayerChoosingPaper() {
        String status = game.play(SCISSORS, PAPER);

        assertThat(status, is("player 1 won"));
    }

    @Test
    public void firstPlayerChoosesPaperWhichLoosesAgainstSecondPlayerChoosingScissors() {
        String status = game.play(PAPER, SCISSORS);

        assertThat(status, is("player 2 won"));
    }

    @Test
    public void firstPlayerChoosesPaperWhichBeatsSecondPlayerChoosingRock() {
        String status = game.play(PAPER, ROCK);

        assertThat(status, is("player 1 won"));
    }

    @Test
    public void firstPlayerChoosesRockWhichLoosesAgainstSecondPlayerChoosingPaper() {
        String status = game.play(ROCK, PAPER);

        assertThat(status, is("player 2 won"));
    }
}
