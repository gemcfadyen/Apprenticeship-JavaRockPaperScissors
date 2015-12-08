package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class RandomNumberTest {

    @Test
    public void lowerBoundaryGenerated() {
        RandomNumber randomNumber = new RandomNumber(1, new RandomStub(0));
        assertThat(randomNumber.generateToMaxOf(3), is(1));
    }

    @Test
     public void onePlusLowerBoundaryGenerated() {
        RandomNumber randomNumber = new RandomNumber(1, new RandomStub(1));
        assertThat(randomNumber.generateToMaxOf(3), is(2));
    }

    @Test
    public void twoPlusLowerBoundaryGenerated() {
        RandomNumber randomNumber = new RandomNumber(1, new RandomStub(2));
        assertThat(randomNumber.generateToMaxOf(3), is(3));
    }

    private static final class RandomStub extends SecureRandomWrapper {
        private int generatedNumber;

        public RandomStub(int generatedNumber) {
            this.generatedNumber = generatedNumber;
        }

        public int generateValue(int upperBoundary) {
            return generatedNumber;
        }
    }
}
