package rps;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RandomPlayerTest {

    @Test
    public void playerChooses1() {
        RandomPlayer randomPlayer = new RandomPlayer();

        Gesture gesture = randomPlayer.getGesture();

        assertThat(gesture, is(Gesture.ROCK));
    }
}

