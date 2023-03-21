package com.notable.notable;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.notable.notable.Commands.Shell.ShellCommand;

import io.quarkus.arc.ArcContainer;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@QuarkusMain
@Singleton
@Command(name = "", description = "A command line application for note taking.", subcommands = {
	ShellCommand.class
})
public class NotableApplication {

	@Inject
	ArcContainer arcContainer;

	@PostConstruct
	void onStart() {
		if (arcContainer == null) {
			throw new RuntimeException("Arc container is null");
		}
	}

	public static void main(String[] args) {
		System.exit(new CommandLine(new NotableApplication()).execute(args));
		//Quarkus.waitForExit();
	}

} 
