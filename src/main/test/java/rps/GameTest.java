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
    private static final String[] NO_GESTURES = null;
    private Game game;
    private Writer writer;
    private PromptSpy gamePrompt;

    @Before
    public void setup() {
        writer = new StringWriter();
        gamePrompt = new PromptSpy(writer, new String[]{""}, new String[]{"N"});
        game = new Game(gamePrompt, new Player[]{createHumanPlayer(gamePrompt, "Human-1"), createHumanPlayer(gamePrompt, "Human-2")});
    }

    @Test
    public void firstPlayerChoosesRockWhichBeatsSecondPlayerChoosingScissors() {
        game.evaluate(ROCK, SCISSORS);

        assertThat(gamePrompt.numberOfTimesWinPrinted(), is(1));
        assertThat(gamePrompt.getWinnersName(), is("Human Player"));
    }

    @Test
    public void firstPlayerChoosesScissorsWhichLoosesAgainstSecondPlayerChoosingRock() {
        game.evaluate(SCISSORS, ROCK);

        assertThat(gamePrompt.numberOfTimesWinPrinted(), is(1));
        assertThat(gamePrompt.getWinnersName(), is("Random Player"));
    }

    @Test
    public void firstPlayerChoosesScissorsWhichBeatsSecondPlayerChoosingPaper() {
        game.evaluate(SCISSORS, PAPER);

        assertThat(gamePrompt.numberOfTimesWinPrinted(), is(1));
        assertThat(gamePrompt.getWinnersName(), is("Human Player"));
    }

    @Test
    public void firstPlayerChoosesPaperWhichLoosesAgainstSecondPlayerChoosingScissors() {
        game.evaluate(PAPER, SCISSORS);

        assertThat(gamePrompt.numberOfTimesWinPrinted(), is(1));
        assertThat(gamePrompt.getWinnersName(), is("Random Player"));
    }

    @Test
    public void firstPlayerChoosesPaperWhichBeatsSecondPlayerChoosingRock() {
        game.evaluate(PAPER, ROCK);

        assertThat(gamePrompt.numberOfTimesWinPrinted(), is(1));
        assertThat(gamePrompt.getWinnersName(), is("Human Player"));
    }

    @Test
    public void firstPlayerChoosesRockWhichLoosesAgainstSecondPlayerChoosingPaper() {
        game.evaluate(ROCK, PAPER);

        assertThat(gamePrompt.numberOfTimesWinPrinted(), is(1));
        assertThat(gamePrompt.getWinnersName(), is("Random Player"));
    }

    @Test
    public void bothPlayersChooseRockSoGameDraws() {
        game.evaluate(ROCK, ROCK);

        assertThat(gamePrompt.numberOfTimesDrawPrinted(), is(1));
    }

    @Test
    public void bothPlayersChoosePaperSoGameDraws() {
        game.evaluate(PAPER, PAPER);

        assertThat(gamePrompt.numberOfTimesDrawPrinted(), is(1));
    }

    @Test
    public void bothPlayersChooseScissorsSoGameDraws() {
        game.evaluate(SCISSORS, SCISSORS);
        assertThat(gamePrompt.numberOfTimesDrawPrinted(), is(1));
    }

    @Test
    public void playersPromptedToSelectTheirGesture() {
        PromptSpy player1PromptSpy = createPromptSpyWithUserInput("1");
        PromptSpy player2PromptSpy = createPromptSpyWithUserInput("2");
        PromptSpy gamePrompt = new PromptSpy(writer, NO_GESTURES, new String[]{"N"});
        game = new Game(gamePrompt, new Player[]{
                createHumanPlayer(player1PromptSpy, "one"),
                createHumanPlayer(player2PromptSpy, "two")}
        );

        game.playSingleRound();

        assertThat(gamePrompt.numberOfTimesUsersHaveBeenPrompted(), is(1));
        assertThat(player1PromptSpy.getGesturesEntered(), contains(ROCK));
        assertThat(player2PromptSpy.getGesturesEntered(), contains(PAPER));
    }

    @Test
    public void playerOneEntersStrongerGestureThanPlayerTwoSoWins() {
        PromptSpy gamePrompt = new PromptSpy(writer, NO_GESTURES, new String[]{"N"});
        game = new Game(gamePrompt,
                new Player[]{
                        createHumanPlayer(createPromptSpyWithUserInput("1"), "one"),
                        createHumanPlayer(createPromptSpyWithUserInput("2"), "two")}
        );

        game.playSingleRound();

        assertThat(gamePrompt.numberOftimesMovePrinted(), is(2));
        assertThat(gamePrompt.numberOfTimesWinPrinted(), is(1));
        assertThat(gamePrompt.getWinnersName(), is("Random Player"));
    }

    @Test
    public void playerAskedForReplay() {
        PromptSpy player1PromptSpy = createPromptSpyWithUserInput("1", "2");
        PromptSpy player2PromptSpy = createPromptSpyWithUserInput("2", "2");
        PromptSpy gamePrompt = new PromptSpy(writer, NO_GESTURES, new String[]{"Y", "N"});
        game = new Game(gamePrompt,
                new Player[]{
                        createHumanPlayer(player1PromptSpy, "one"),
                        createHumanPlayer(player2PromptSpy, "two")}
        );

        game.play();

        assertThat(gamePrompt.numberOfTimesPlayerPromptedForReplay(), is(2));
        assertThat(player1PromptSpy.getGesturesEntered(), contains(ROCK, PAPER));
        assertThat(player2PromptSpy.getGesturesEntered(), contains(PAPER, PAPER));
    }

    private PromptSpy createPromptSpyWithUserInput(String... input) {
        return new PromptSpy(writer, input, new String[]{"N"});
    }

    private HumanPlayer createHumanPlayer(PromptSpy player1PromptSpy, String name) {
        return new HumanPlayer(name, player1PromptSpy);
    }
}
