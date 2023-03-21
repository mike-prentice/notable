package com.notable.notable;

import com.notable.notable.Commands.Shell.ShellCommand;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "", subcommands = {
		ShellCommand.class
})
@QuarkusMain
public class NotableApplication implements QuarkusApplication {

	@Override
	public int run(String... args) throws Exception {
		int exitCode = new CommandLine(new NotableApplication()).execute(args);
		return exitCode;
	}

}
