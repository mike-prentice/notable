package com.notable.notable.Commands.Shell;

import java.util.Scanner;

import com.notable.notable.Commands.NoteCommands.Note;

import io.quarkus.picocli.runtime.annotations.TopCommand;

import picocli.CommandLine.HelpCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@TopCommand
@Command(name = "shell", subcommands = {
        HelpCommand.class,
})
public class ShellCommand implements Runnable {

    @Override
    public void run() {
        // Prompt the user for input
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            

            // Execute the Picocli command based on the input
            CommandLine commandLine = new CommandLine(new Note());
            commandLine.execute(input.split(" "));
            commandLine.clearExecutionResults();
            input = null;
            //close scanner

        }
    }

}
