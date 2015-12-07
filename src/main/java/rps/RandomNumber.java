package rps;

public class RandomNumber implements RandomNumberWithinRange {
    private final int lowerBoundary;
    private SecureRandomWrapper random;

    public RandomNumber(int lowerBoundary, SecureRandomWrapper random) {
        this.lowerBoundary = lowerBoundary;
        this.random = random;
    }

    @Override
    public int generateToMaxOf(int upperBoundary) {
        return random.generateValue(upperBoundary) + lowerBoundary;
    }
}
