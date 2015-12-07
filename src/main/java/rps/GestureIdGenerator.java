package rps;

public class GestureIdGenerator {

    private RandomNumberWithinRange randomNumber;
    private int lowerBound;

    GestureIdGenerator() {

    }

    public GestureIdGenerator(RandomNumberWithinRange randomNumber, int lowerBound) {
        this.randomNumber = randomNumber;
        this.lowerBound = lowerBound;
    }

    public int id() {
        return randomNumber.generate() + lowerBound;
    }
}
