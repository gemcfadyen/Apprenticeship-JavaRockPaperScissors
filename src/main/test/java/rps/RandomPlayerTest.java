package rps;

import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandomPlayerTest {

    @Test
    public void playerChooses1() {
        Random randomNumberGenerator = new RandomMock(1);
        RandomPlayer randomPlayer = new RandomPlayer(randomNumberGenerator);

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(Gesture.ROCK));
    }

    @Test
    public void playerChooses2() {
        Random randomNumberGenerator = new RandomMock(2);
        RandomPlayer randomPlayer = new RandomPlayer(randomNumberGenerator);

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(Gesture.PAPER));
    }

    @Test
    public void playerChooses3() {
        Random randomNumberGenerator = new RandomMock(3);
        RandomPlayer randomPlayer = new RandomPlayer(randomNumberGenerator);

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(Gesture.SCISSORS));
    }

    private static class RandomMock extends Random {
        private int numberToReturn;

        public RandomMock(int numberToReturn) {

            this.numberToReturn = numberToReturn;
        }

        public int nextInt() {
            return numberToReturn;
        }
    }

}

