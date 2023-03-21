package com.notable.notable.Commands.NoteCommands;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.notable.notable.Repository.NoteRepository;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;

@ApplicationScoped
@Command(name = "notes", description = "Create, list, and delete your notes.", subcommands = {
        AddNoteCommand.class,
        HelpCommand.class
})
public class Notes implements Runnable {

    @Inject
    NoteRepository noteRepo;

    @Override
    public void run() {

    }

}
