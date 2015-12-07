package rps;

public class TestRandomNumber implements RandomNumberWithinRange {
    private int number;

    public TestRandomNumber(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
