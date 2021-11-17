package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@ApplicationScoped
public class UserService {

    @Inject
    private EntityManager entityManager;



    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;

    }
}
