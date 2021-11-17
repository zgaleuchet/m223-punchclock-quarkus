package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProjectService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public Project createProject(Project project) {
        entityManager.persist(project);
        return project;
    }

    @SuppressWarnings("unchecked")
    public List<Project> findAll() {
        var query = entityManager.createQuery("FROM Project");
        return query.getResultList();
    }

    public Project getProjectById(Long Id){
        return entityManager.find(Project.class, Id);
    }

    @Transactional
    public void delete(Long id){
        Project entity = getProjectById(id);
        entityManager.remove(entity);
    }

    @Transactional
    public Project updateEntity(Project project){
        entityManager.merge(project);
        return project;
    }
}
