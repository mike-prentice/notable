package com.notable.notable;


import com.notable.notable.Commands.Shell.ShellCommand;

import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@QuarkusMain
@Command(name = "", description = "A command line application for note taking.", subcommands = {
	ShellCommand.class
})
public class NotableApplication {

	public static void main(String[] args) {
		System.exit(new CommandLine(new NotableApplication()).execute(args));
	}

} 
