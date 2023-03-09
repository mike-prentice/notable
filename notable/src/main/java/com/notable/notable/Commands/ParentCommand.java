package com.notable.notable.Commands;

import com.notable.notable.Commands.NoteCommands.AddNoteCommand;



import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Option;



@Command(name = "notable", showAtFileInUsageHelp = true, mixinStandardHelpOptions = true, version = "1.0", description = "Take notes via the command line.", subcommands = {
        AddNoteCommand.class,
        HelpCommand.class
})
 
public class ParentCommand implements Runnable {
 

    // TODO Add shell
    // TODO Add commands for delete/list/edit to sub command list
    // TODO Add better help text
    // TODO Add picocli options in parent command for username and password
    // TODO convert to quarkus/graalVM
  
    @Option(
      names        = {"-u", "--username"},
      description  = "username...")
    private String username;

    @Option(
      names        = {"-p", "--password"},
      description  = "password...")
    private String password;
    
    private int exitCode;
    

    @Override
    public void run() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
