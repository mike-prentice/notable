package com.notable.notable.Persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import com.notable.notable.Model.Note;

@ApplicationScoped
public class NoteDao {
    private static final Logger LOG = Logger.getLogger(NoteDao.class);

    @Inject
    EntityManager em;

    @Transactional
    public void save(Note note) {
        em.persist(note);
        LOG.info("Note successfully saved");
    }
}