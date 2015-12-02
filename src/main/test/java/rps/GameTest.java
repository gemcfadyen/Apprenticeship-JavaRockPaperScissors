package rps;

import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;
import java.io.Writer;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.PAPER;
import static rps.Gesture.ROCK;
import static rps.Gesture.SCISSORS;

public class GameTest {

    private Game game;
    private Writer writer;

    @Before
    public void setup() {
        writer = new StringWriter();
        game = new Game(new PromptSpy(writer, ""));
    }

    @Test
    public void firstPlayerChoosesRockWhichBeatsSecondPlayerChoosingScissors() {
        String status = game.evaluate(ROCK, SCISSORS);
        assertThat(status, is("Player one won"));
    }

    @Test
    public void firstPlayerChoosesScissorsWhichLoosesAgainstSecondPlayerChoosingRock() {
        String status = game.evaluate(SCISSORS, ROCK);
        assertThat(status, is("Player two won"));
    }

    @Test
    public void firstPlayerChoosesScissorsWhichBeatsSecondPlayerChoosingPaper() {
        String status = game.evaluate(SCISSORS, PAPER);
        assertThat(status, is("Player one won"));
    }

    @Test
    public void firstPlayerChoosesPaperWhichLoosesAgainstSecondPlayerChoosingScissors() {
        String status = game.evaluate(PAPER, SCISSORS);
        assertThat(status, is("Player two won"));
    }

    @Test
    public void firstPlayerChoosesPaperWhichBeatsSecondPlayerChoosingRock() {
        String status = game.evaluate(PAPER, ROCK);
        assertThat(status, is("Player one won"));
    }

    @Test
    public void firstPlayerChoosesRockWhichLoosesAgainstSecondPlayerChoosingPaper() {
        String status = game.evaluate(ROCK, PAPER);
        assertThat(status, is("Player two won"));
    }

    @Test
    public void bothPlayersChooseRockSoGameDraws() {
        String status = game.evaluate(ROCK, ROCK);
        assertThat(status, is("Draw"));
    }

    @Test
    public void bothPlayersChoosePaperSoGameDraws() {
        String status = game.evaluate(PAPER, PAPER);
        assertThat(status, is("Draw"));
    }

    @Test
    public void bothPlayersChooseScissorsSoGameDraws() {
        String status = game.evaluate(SCISSORS, SCISSORS);
        assertThat(status, is("Draw"));
    }

    @Test
    public void playersPromptedToSelectTheirGesture() {
        PromptSpy promptSpy = new PromptSpy(writer, "1", "2");

        game = new Game(promptSpy);
        game.singleRound();

        assertThat(promptSpy.numberOfTimesPlayersHaveBeenPrompted(), is(2));
        assertThat(promptSpy.getGesturesEntered(), contains(ROCK, PAPER));
    }

    @Test
    public void playerOneEntersStrongerGestureThanPlayerTwoSoWins() {
        PromptSpy promptSpy = new PromptSpy(writer, "1", "2");

        game = new Game(promptSpy);
        game.singleRound();

        assertThat(writer.toString(), is("Player two won"));
    }

//    @Test
//    public void playersReplay() {
//        PromptSpy promptSpy = new PromptSpy();
//
//        game = new Game(promptSpy);
//
//    }
}
