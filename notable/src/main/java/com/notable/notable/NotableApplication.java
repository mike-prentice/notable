package com.notable.notable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.notable.notable.Commands.NoteCommands.AddNoteCommand;
import com.notable.notable.Repository.NoteRepo;

@SpringBootApplication
public class NotableApplication {

	@Bean
	AddNoteCommand noteCommand() {
		return new AddNoteCommand();
	}

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(NotableApplication.class, args)));

	}

}
