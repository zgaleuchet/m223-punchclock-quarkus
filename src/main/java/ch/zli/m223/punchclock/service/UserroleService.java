package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Userrole;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class UserroleService {

    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Userrole> findAll() {
        var query = entityManager.createQuery("FROM Userrole");
        System.out.println(query.getResultList());
        return query.getResultList();
    }

}
