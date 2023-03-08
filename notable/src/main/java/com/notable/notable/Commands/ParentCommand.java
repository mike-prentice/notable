package com.notable.notable.Commands;

import com.notable.notable.Commands.NoteCommands.AddNoteCommand;
import com.notable.notable.Commands.Shell.ShellCommand;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.ExitCodeGenerator;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Option;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;


@Command(name = "notable", showAtFileInUsageHelp = true, mixinStandardHelpOptions = true, version = "1.0", description = "Take notes via the command line.", subcommands = {
        AddNoteCommand.class,
        HelpCommand.class
})
@Component @RequiredArgsConstructor
public class ParentCommand implements Runnable, ExitCodeGenerator {
    private final IFactory factory;
    private final ShellCommand shell;

    // TODO Add shell
    // TODO Add commands for delete/list/edit to sub command list
    // TODO Add better help text
    // TODO Add picocli options in parent command for username and password
    // TODO convert to quarkus/graalVM

    @Option(names = { "-n", "--name" }, description = "A simple command line note taking application")
    private String name;

    private int exitCode;
    
    @Override
    public void run() {
        exitCode = new CommandLine(shell, factory).execute(new String[] {});
    }

    @Override
  public int getExitCode() {
    return exitCode;
  }
}
