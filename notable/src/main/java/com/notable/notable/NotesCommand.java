package com.notable.notable;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import picocli.CommandLine.Option;
import picocli.CommandLine;

@Component
@CommandLine.Command(name = "hello", mixinStandardHelpOptions = true, version = "1.0",
        description = "Prints a greeting to the console.")
public class NotesCommand implements Callable<String> {
    
    @Option(names = {"-n", "--name"}, description = "The name to greet.")
    private String name;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String call() throws Exception {
        System.out.println("Executing option -n: " + this.name + " you did it! You are ready to take notes!") ;
    return "Hello " + name;
    }
}
