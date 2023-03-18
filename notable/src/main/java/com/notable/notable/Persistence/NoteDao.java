package com.notable.notable.Persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import com.notable.notable.Model.Note;

@ApplicationScoped
@Provider
public class NoteDao {
    private static final Logger LOG = Logger.getLogger(NoteDao.class);

    @Inject
    EntityManager em;

   
    public NoteDao(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void save(Note note) {
        em.persist(note);
        LOG.info("Note successfully saved");
    }
}