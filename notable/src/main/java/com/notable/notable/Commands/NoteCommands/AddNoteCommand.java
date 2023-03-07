package com.notable.notable.Commands.NoteCommands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notable.notable.Model.Note;
import com.notable.notable.Repository.NoteRepo;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Component
@Command(name = "add", description = "Add a new note")
public class AddNoteCommand implements Runnable {

    @Autowired
    private NoteRepo noteRepo;

    @Parameters(description = "The text of the note")
    private String text;

    @Option(names = { "--title", "-t" }, description = "The title of the note")
    private String title;

    @Override
    public void run() {
        Note note = new Note();
        note.setText(text);
        note.setTitle(title);
        noteRepo.save(note);
        System.out.println("Note added successfully");
    }
}
