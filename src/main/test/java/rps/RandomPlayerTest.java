package rps;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandomPlayerTest {

    private RandomPlayer randomPlayer;

    @Test
    public void playerChooses1() {
        randomPlayer = new RandomPlayer(new RandomMock(0));

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(Gesture.ROCK));
    }

    @Test
    public void playerChooses2() {
        RandomPlayer randomPlayer = new RandomPlayer(new RandomMock(1));

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(Gesture.PAPER));
    }

    @Test
    public void playerChooses3() {
        RandomPlayer randomPlayer = new RandomPlayer(new RandomMock(2));

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

