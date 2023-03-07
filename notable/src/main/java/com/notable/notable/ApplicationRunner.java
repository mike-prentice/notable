package com.notable.notable;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.notable.notable.Commands.ParentCommand;

import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
@EnableAutoConfiguration
public class ApplicationRunner implements CommandLineRunner, ExitCodeGenerator {
     // auto-configured to inject PicocliSpringFactory
  private final IFactory factory;

  private final ParentCommand parentCommand;

  private int exitCode;

  public ApplicationRunner(IFactory factory, ParentCommand parentCommand) {
    this.factory = factory;
    this.parentCommand = parentCommand;
  }

  @Override
  public void run(String... args) throws Exception {
    exitCode = new CommandLine(parentCommand, factory).execute(args);
  }

  @Override
  public int getExitCode() {
    return exitCode;
  }
}
