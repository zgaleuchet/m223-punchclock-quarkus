package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        //return entityManager.findAll();

        var query = entityManager.createQuery("FROM Category");
        return query.getResultList();
    }
}
