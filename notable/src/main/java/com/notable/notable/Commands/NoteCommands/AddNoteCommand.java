package com.notable.notable.Commands.NoteCommands;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import com.notable.notable.Model.Note;
import com.notable.notable.Repository.NoteRepository;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@ApplicationScoped
@Command(name = "add", description = "Add a new note")
public class AddNoteCommand implements Runnable {

    @Inject
    NoteRepository noteRepo;
    
    @Parameters(description = "The text of the note")
    private String text;

    @Option(names = { "--title", "-t" }, description = "The title of the note")
    private String title;

    

    @Override
    public void run() {
        AnsiConsole.systemInstall();
        Note note = new Note();
        note.setText(text);
        note.setTitle(title);
        noteRepo.persist(note);

        System.out.println(Ansi.ansi().render("@|green The note text was: |@" + text));
        if (note.getTitle() != null) {
            System.out.println("The title was" + title);
            AnsiConsole.systemUninstall();
        }
    }
}
