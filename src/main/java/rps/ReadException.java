package rps;

public class ReadException extends RuntimeException {
    public ReadException(Throwable throwable) {
        super(throwable);
    }
}
