package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class UserService {

    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        var query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }

    public List<User> getUserByUsername(String username){
        System.out.println("getUserByUsername");
        System.out.println(username);
        var query = entityManager.createQuery("FROM User WHERE username LIKE :username").setParameter("username", username);
        return query.getResultList();
    }

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    public void delete(Long id){
        User entity = getUserById(id);
        entityManager.remove(entity);
    }

    @Transactional
    public User updateUser(User user){
        entityManager.merge(user);
        return user;
    }

    public User getUserById(Long Id){
        return entityManager.find(User.class, Id);
    }
}
