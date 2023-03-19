package com.notable.notable.Commands.Shell;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.fusesource.jansi.AnsiConsole;
import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import com.notable.notable.Commands.NoteCommands.Note;
import com.notable.notable.Commands.QuitCommand.QuitCommand;
import com.notable.notable.Util.ConsoleBuilder;

import io.quarkus.picocli.runtime.annotations.TopCommand;

import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Spec;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@TopCommand
@Command(name = "shell", description = "Interactive shell to manage notes.", subcommands = {
        Note.class,
        QuitCommand.class,
        HelpCommand.class,
})
public class ShellCommand implements Runnable {
    protected Terminal terminal;
    protected LineReader reader;
    protected String input = null;
    protected ConsoleBuilder console = new ConsoleBuilder();

    @Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        AnsiConsole.systemInstall();
        boolean run = true;
        CommandLine commandLine = new CommandLine(new ShellCommand());

        try {
            terminal = console.getTerminal();
            reader = console.getReader();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Prompt the user for input
        while (run) {

            try {
                input = reader.readLine("notable> ");
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }

            // parse the input
            String[] args = parseArgs(input);

            run = checkForQuitCommand(args);

            // Execute the Picocli command based on the input
            commandLine.execute(args);
        }
        AnsiConsole.systemUninstall();

    }

    private boolean checkForQuitCommand(String[] args) {

        if (args.length != 0 && args[0].equals("quit")) {
            return false;
        } else {
            return true;
        }

    }

    public String[] parseArgs(String input) {
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

        }
        String[] args = new String[argArray.size()];

        for (int i = 0; i < argArray.size(); i++) {
            args[i] = argArray.get(i);
        }
        return args;

    }

}
