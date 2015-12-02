package rps;

import java.io.IOException;
import java.io.Reader;

public class StringReaderStub extends Reader {
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        throw new IOException();
    }

    @Override
    public void close() throws IOException {

    }
}
