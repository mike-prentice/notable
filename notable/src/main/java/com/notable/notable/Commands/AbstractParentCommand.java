package com.notable.notable.Commands;

import java.io.PrintWriter;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "", description = {
    "Welcome to Notable" }, footer = { "", "Press Ctl-D to exit." })

public class AbstractParentCommand implements Runnable {
  //print help if no commands entered

  private PrintWriter out;

  public AbstractParentCommand() {
  }

  @Override
  public void run() {
    out.println(new CommandLine(this).getUsageMessage());
  }

 

  
}
