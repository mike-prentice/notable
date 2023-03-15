package com.notable.notable.Commands.NoteCommands;

import picocli.CommandLine.Command;
import picocli.CommandLine.HelpCommand;

@Command(name = "notes", subcommands = {
        AddNoteCommand.class,
        HelpCommand.class
})
public class Note implements Runnable {

    @Override
    public void run() {

    }

}


// @Spec
// CommandLine.Model.CommandSpec spec;

// @Override
// public void run() {
    
//     // Display a prompt and accept user input
    
//     Scanner scanner = new Scanner(System.in);
    
//     while (true) {
//         System.out.print("notable> ");
       
//            String input = scanner.nextLine().trim();
//             System.out.println(input);
//             input = Arrays.toString(input.split("//s+"));
        
//         System.out.println(input);
//         CommandLine commandLine = new CommandLine(new ShellCommand());
//         commandLine.execute(input.split("([^\"]\\S*|\".+?\")\\s*"));
//     }
//}
