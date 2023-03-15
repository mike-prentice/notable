package com.notable.notable.Commands;

import java.io.PrintWriter;

import com.notable.notable.Commands.Shell.ShellCommand;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Spec;

@Command(name = "", description = {
    "Welcome to Notable" }, mixinStandardHelpOptions = true, footer = { "", "Press Ctl-D to exit." })

public class AbstractParentCommand implements Runnable {
  //print help if no commands entered

  private PrintWriter out;

  @ParentCommand
  ShellCommand shell;

  @Spec
  CommandLine.Model.CommandSpec spec;

  public AbstractParentCommand() {
  }

  @Override
  public void run() {
    out.println(new CommandLine(this).getUsageMessage());
  }

 

  
}
