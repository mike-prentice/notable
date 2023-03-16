package com.notable.notable.Commands.QuitCommand;

import picocli.CommandLine.Command;

@Command(name = "quit", description = "Quit the application.")
public class QuitCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
    
}
