package rps;

import java.security.SecureRandom;

public class SecureRandomWrapper {
    private SecureRandom secureRandom;

    SecureRandomWrapper() {
    }

    public SecureRandomWrapper(SecureRandom secureRandom) {
        this.secureRandom = secureRandom;
    }

    public int generateValue(int upperBoundary) {
        return secureRandom.nextInt(upperBoundary);
    }
}
