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

    @Before
    public void setup() {
        writer = new StringWriter();
        PromptSpy gamePrompt = new PromptSpy(writer, new String[]{""},new String[]{"N"});
        game = new Game(gamePrompt, new Player[]{createHumanPlayer(gamePrompt, "Human-1"), createHumanPlayer(gamePrompt, "Human-2")});
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
        PromptSpy player1PromptSpy = createPromptSpyWithUserInput("1");
        PromptSpy player2PromptSpy = createPromptSpyWithUserInput("2");
        PromptSpy gamePrompt = new PromptSpy(writer, null, new String[]{"N"});
        game = new Game(gamePrompt, new Player[]{
                createHumanPlayer(player1PromptSpy, "one"),
                createHumanPlayer(player2PromptSpy, "two")}
        );

        game.playSingleRound();

        assertThat(gamePrompt.numberOfTimesUsersHaveBeenPrompted(), is(2));
        assertThat(player1PromptSpy.getGesturesEntered(), contains(ROCK));
        assertThat(player2PromptSpy.getGesturesEntered(), contains(PAPER));
    }

    @Test
    public void playerOneEntersStrongerGestureThanPlayerTwoSoWins() {
        PromptSpy gamePrompt = new PromptSpy(writer, NO_GESTURES, new String[] {"N"});
        game = new Game(gamePrompt,
                new Player[]{
                        createHumanPlayer(createPromptSpyWithUserInput("1"), "one"),
                        createHumanPlayer(createPromptSpyWithUserInput("2"), "two")}
        );

        game.playSingleRound();

        assertThat(writer.toString().contains("one chose 1 - ROCK"), is(true));
        assertThat(writer.toString().contains("two chose 2 - PAPER"), is(true));
        assertThat(writer.toString().contains("Player two won"), is(true));
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
