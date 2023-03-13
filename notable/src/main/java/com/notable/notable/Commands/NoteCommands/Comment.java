package com.notable.notable.Commands.NoteCommands;

import picocli.CommandLine.Command;

@Command(name = "comment", subcommands = {
    AddNoteCommand.class
})
public class Comment implements Runnable {

    @Override
    public void run() {
        
    }
    
}
