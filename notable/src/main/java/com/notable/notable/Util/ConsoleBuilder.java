package com.notable.notable.Util;

import java.io.IOException;

import org.jline.reader.LineReader;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class ConsoleBuilder {

    public LineReader getReader() throws IOException {
        LineReader reader = new LineReaderImpl(getTerminal());
        return reader;
    }

    public Terminal getTerminal() throws IOException {
        Terminal terminal = TerminalBuilder.builder().system(true).build();
        return terminal;
    }
}
