package rps;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static rps.Gesture.*;

public class RandomPlayerTest {
    private static final String DEFAULT_NAME = "name";
    private RandomPlayer randomPlayer;

    @Test
    public void playerChoosesRock() {
        randomPlayer = new RandomPlayer(DEFAULT_NAME, new RandomMock(0));

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(ROCK));
    }

    @Test
    public void playerChoosesPaper() {
        randomPlayer = new RandomPlayer(DEFAULT_NAME, new RandomMock(1));

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(PAPER));
    }

    @Test
    public void playerChoosesScissors() {
        randomPlayer = new RandomPlayer(DEFAULT_NAME, new RandomMock(2));

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(SCISSORS));
    }

    @Test
    public void playerChoosesInvalidOption() {
        randomPlayer = new RandomPlayer(DEFAULT_NAME, new RandomMock(8));

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(SCISSORS));
    }

    @Test
    public void getsPlayersName() {
        randomPlayer = new RandomPlayer("Frank", new RandomMock(2));

        String name = randomPlayer.getName();

        assertThat(name, is("Frank"));
    }

    private static class RandomMock extends Random {
        private int numberToReturn;

        public RandomMock(int numberToReturn) {

            this.numberToReturn = numberToReturn;
        }

        public int nextInt(int upperBound) {
            if (numberToReturn > upperBound || numberToReturn < 0) {
                return upperBound - 1;
            }
            return numberToReturn;
        }
    }
}

