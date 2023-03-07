package com.notable.notable.Commands;

import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import picocli.CommandLine.Command;

@Command(name = "hello", description = "Says hello")

@Component
@EnableAutoConfiguration
public class AbstractParentCommand implements Runnable, ExitCodeGenerator {
        // auto-configured to inject PicocliSpringFactory
        private int exitCode;

        @Override
        public int getExitCode() {
                return exitCode;
        }

        @Override
        public void run() {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'run'");
        }

}
