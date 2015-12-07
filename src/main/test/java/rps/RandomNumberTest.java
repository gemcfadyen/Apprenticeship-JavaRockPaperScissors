package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RandomNumberTest {
    private RandomNumber randomNumber = new RandomNumber(1);

    @Test
    public void lowerBoundaryGenerated() {
        assertThat(randomNumber.generate(), is(1));
    }

 
}
