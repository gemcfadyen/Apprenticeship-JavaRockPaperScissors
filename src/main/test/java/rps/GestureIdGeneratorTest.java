package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GestureIdGeneratorTest {
    @Test
    public void generatesOne() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGenerator(new TestRandomNumber(1));

        assertThat(gestureIdGenerator.id(), is(1));
    }

    @Test
    public void generatesTwo() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGenerator(new TestRandomNumber(2));

        assertThat(gestureIdGenerator.id(), is(2));
    }

    @Test
    public void generatesThree() {
        GestureIdGenerator gestureIdGenerator = new GestureIdGenerator(new TestRandomNumber(3));

        assertThat(gestureIdGenerator.id(), is(3));
    }
}
