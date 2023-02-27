package com.notable.notable;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
@EnableAutoConfiguration
public class Runner implements CommandLineRunner, ExitCodeGenerator {
     // auto-configured to inject PicocliSpringFactory
  private final IFactory factory;

  private final NotesCommand notesCommand;

  private int exitCode;

  public Runner(IFactory factory, NotesCommand notesCommand) {
    this.factory = factory;
    this.notesCommand = notesCommand;
  }

  @Override
  public void run(String... args) throws Exception {
    exitCode = new CommandLine(notesCommand, factory).execute(args);
  }

  @Override
  public int getExitCode() {
    return exitCode;
  }
}
