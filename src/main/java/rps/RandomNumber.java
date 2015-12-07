package rps;

import java.security.SecureRandom;

public class RandomNumber implements RandomNumberWithinRange {
    private final int lowerBoundary;

    public RandomNumber(int lowerBoundary) { //SecureRandom secureRandom) {
//        this.upperBoundary = upperBoundary;
        this.lowerBoundary = lowerBoundary;
//        this.secureRandom = secureRandom;
    }

    @Override
    public int generate() {
        return lowerBoundary;
//        return secureRandom.nextInt(upperBoundary) + lowerBoundary;
    }
}
