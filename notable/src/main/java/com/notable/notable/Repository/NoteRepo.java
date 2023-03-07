package com.notable.notable.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notable.notable.Model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {
}