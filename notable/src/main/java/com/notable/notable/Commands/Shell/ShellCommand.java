package com.notable.notable.Commands.Shell;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.terminal.impl.DumbTerminal;

import com.notable.notable.Commands.NoteCommands.Note;

import io.quarkus.picocli.runtime.annotations.TopCommand;

import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Spec;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@TopCommand
@Command(name = "shell", subcommands = {
        Note.class,
        HelpCommand.class,
})
public class ShellCommand implements Runnable {
    Terminal terminal;
    LineReader reader;

    @Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        // Prompt the user for input
        CommandLine commandLine = new CommandLine(new ShellCommand());
        try {
            terminal = buildTerminal();
            reader = buildReader();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Scanner scanner = new Scanner(System.in);
        String input = null;
        // String input = null;
        while (true) {
            System.out.print("notable> ");
            try {
                input = reader.readLine("notable> ");
                reader.getTerminal().writer().println(input);
            } catch (InputMismatchException e) {
                
            }
            List<String> argArray = new ArrayList<String>();
            Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
            Matcher regexMatcher = regex.matcher(input);
            while (regexMatcher.find()) {
                if (regexMatcher.group(1) != null) {
                    // Add double-quoted string without the quotes
                    argArray.add(regexMatcher.group(1));
                } else if (regexMatcher.group(2) != null) {
                    // Add single-quoted string without the quotes
                    argArray.add(regexMatcher.group(2));
                } else {
                    // Add unquoted word
                    argArray.add(regexMatcher.group());
                }

                String[] args = new String[argArray.size()];

                for (int i = 0; i < argArray.size(); i++) {
                    args[i] = argArray.get(i);
                }
                System.out.println(args[0].toString());
            
            // Execute the Picocli command based on the input
            commandLine.execute(args);
            }
            
            // commandLine.clearExecutionResults();
            // input = null;
        }
    }

    private LineReader buildReader() throws IOException {
        LineReader reader = new LineReaderImpl(terminal);
        return reader;
    }

    private Terminal buildTerminal() throws IOException {
        Terminal terminal = TerminalBuilder.builder().system(true).build();
        return terminal;
    }

}
// fix ouput
// fix split
// fix scanner try/catch