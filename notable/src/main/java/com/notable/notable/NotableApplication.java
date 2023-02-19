package com.notable.notable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;
import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class NotableApplication implements Runnable {

	@CommandLine.Command(name = "-note", description = "Writes and stores a note")

	@CommandLine.Parameters(index = "0", description = "The note to be stored")
	private String note;

	@Override
	public void run() {
		try {
			FileWriter writer = new FileWriter("notes.txt", true);
			writer.write(note + "\n");
			writer.close();
			System.out.println("Note successfully stored!");
		} catch (IOException e) {
			System.out.println("Failed to store note: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		 //SpringApplication.run(NotableApplication.class, args);
		new CommandLine(new NotableApplication()).execute(args);
	}

}
