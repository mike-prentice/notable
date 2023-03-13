package com.notable.notable.Commands.NoteCommands;

import picocli.CommandLine.Command;

@Command(name = "notes", subcommands = {
    AddNoteCommand.class
})
public class Note implements Runnable {

    @Override
    public void run() {
        
    }
    
}
