package com.notable.notable.Commands;

import com.notable.notable.Commands.NoteCommands.AddNoteCommand;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Option;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "Notable", mixinStandardHelpOptions = true, version = "1.0", description = "Take notes via the command line.", subcommands = {
        AddNoteCommand.class,
        HelpCommand.class
})
public class ParentCommand implements Callable<String> {

    //TODO Add login functionality to add notes for user
    @Option(names = { "-n", "--name" }, description = "Greets the user when their name is entered...")
    private String name;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String call() throws Exception {
        if (name == null) {
            System.out.println("No Name specified, aborting operation");
        }
        System.out.println("Executing option -n: " + this.name + " you are logged in! You are ready to take notes!");
        return "Hello " + name + " ,you are logged in!";
    }
}
