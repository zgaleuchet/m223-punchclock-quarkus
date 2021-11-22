package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Entry;

@ApplicationScoped
//@RolesAllowed("User")
public class EntryService {
    @Inject
    private EntityManager entityManager;

    @Transactional 
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    @SuppressWarnings("unchecked")
    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry");
        return query.getResultList();
    }

    public Entry getEntryById(Long Id){
        return entityManager.find(Entry.class, Id);
    }

    @Transactional
    public void delete(Long id){
        Entry entity = getEntryById(id);
        entityManager.remove(entity);
    }

    @Transactional
    public Entry updateEntity(Entry entry){
        entityManager.merge(entry);
        return entry;
    }
}
