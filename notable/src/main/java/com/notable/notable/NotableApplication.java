package com.notable.notable;



import com.notable.notable.Commands.NoteCommands.AddNoteCommand;


public class NotableApplication {


	AddNoteCommand noteCommand() {
		return new AddNoteCommand();
	}

	public static void main(String[] args) {
		
	}

}
