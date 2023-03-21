package com.notable.notable.Repository;

import javax.enterprise.context.ApplicationScoped;

import com.notable.notable.Model.Note;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class NoteRepository implements PanacheRepository<Note> {

}
