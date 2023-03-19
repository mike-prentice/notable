package com.notable.notable.Service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

import com.notable.notable.Model.Note;

@ApplicationScoped
@Provider
public class NoteService {
    private static final Logger LOG = Logger.getLogger(NoteService.class);

    @Inject
    EntityManager em;

   
    public NoteService(EntityManager em) {
        this.em = em;
    }

    @Transactional
    public void save(Note note) {
        em.persist(note);
        LOG.info("Note successfully saved");
    }
}