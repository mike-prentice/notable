package com.notable.notable.Commands.NoteCommands;

import javax.inject.Inject;

import com.notable.notable.Model.Note;
import com.notable.notable.Persistence.NoteDao;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "add", description = "Add a new note")
public class AddNoteCommand implements Runnable {

    @Inject
    NoteDao noteDao;

    @Parameters(description = "The text of the note")
    private String text;

    @Option(names = { "--title", "-t" }, description = "The title of the note")
    private String title;

    @Override
    public void run() {
        Note note = new Note();
        note.setText(text);
        note.setTitle(title);
        noteDao.save(note);
        
        System.out.println("The note text was: " + text);
    }
}
