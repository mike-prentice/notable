package com.notable.notable.Commands.NoteCommands;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;

@Command(name = "notes", description = "Create, list, and delete your notes.", subcommands = {
        AddNoteCommand.class,
        HelpCommand.class
})
public class Note implements Runnable {

    @Override
    public void run() {

    }

}


