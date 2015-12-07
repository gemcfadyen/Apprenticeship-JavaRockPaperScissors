package rps;

public enum ReplayOption {
    Y, N;

    static ReplayOption of(String option) {
        if (Y.name().equalsIgnoreCase(option)) {
            return Y;
        }
        return N;
    }
}
