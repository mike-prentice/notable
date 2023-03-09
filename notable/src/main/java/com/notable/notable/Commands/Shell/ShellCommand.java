package com.notable.notable.Commands.Shell;





import com.notable.notable.Commands.NoteCommands.AddNoteCommand;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;


@Command(name = "shell", description = {
        "Take notes via the command line." +
                "Type @|magenta <TAB>|@ to see available commands.",
        "Type @|magenta ALT-S|@ to toggle tailtips.",
        "" }, footer = { "", "Press Ctl-D to exit." }, subcommands = {
                AddNoteCommand.class,
                HelpCommand.class,
        })

public class ShellCommand implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    

}
