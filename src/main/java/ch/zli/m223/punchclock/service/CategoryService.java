package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        var query = entityManager.createQuery("FROM Category");
        return query.getResultList();
    }

    @Transactional
    public Category createCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    public Category getCategoryById(Long Id){
        return entityManager.find(Category.class, Id);
    }

    @Transactional
    public void deleteCategory(Long id){
        Category entity = getCategoryById(id);
        entityManager.remove(entity);
    }

    @Transactional
    public Category updateCategory(Category category){
        entityManager.merge(category);
        return category;
    }
}
