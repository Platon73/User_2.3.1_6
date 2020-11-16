package usergroup.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOperations;
import org.springframework.stereotype.Repository;
import usergroup.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    //private SessionFactory sessionFactory;

//    @Autowired
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }
    //метод для добавления:
    @Override
    public void add(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(user);
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(user);
        //entityManager.getTransaction().begin();
        entityManager.remove(user);
    }

    @Override
    public void edit(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.update(user);
        entityManager.merge(user);

    }

    @Override
    public User getById(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(User.class, id);
        return entityManager.find(User.class, id);
    }
}

