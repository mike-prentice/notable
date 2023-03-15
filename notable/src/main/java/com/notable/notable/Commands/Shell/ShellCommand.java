package com.notable.notable.Commands.Shell;

import java.io.Console;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.LineReaderImpl;
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

    @Spec
    CommandLine.Model.CommandSpec spec;

    @Override
    public void run() {
        // Prompt the user for input
        CommandLine commandLine = new CommandLine(new ShellCommand());
        Scanner scanner = new Scanner(System.in);
        String input = null;
        //String input = null;
        while (true) {
            
            System.out.print("notable> ");
            try{
            input = scanner.nextLine().trim();
        } catch (InputMismatchException e) {
            scanner.next();
            }
            String[] args = input.split(" ");
            System.out.println(args[0].toString());
            //System.out.println(args[1].toString());
            //System.out.println(args[2].toString());
            // Execute the Picocli command based on the input
            
            commandLine.execute(args);
            //commandLine.clearExecutionResults();
            //input = null;
        }
    }

}
