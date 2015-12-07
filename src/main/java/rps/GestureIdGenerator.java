package rps;

public class GestureIdGenerator {

    private RandomNumberWithinRange randomNumber;

    GestureIdGenerator() {

    }

    public GestureIdGenerator(RandomNumberWithinRange randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int id() {
        return randomNumber.generate();
    }
}
