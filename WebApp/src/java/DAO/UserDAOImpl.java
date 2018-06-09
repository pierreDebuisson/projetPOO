/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Iterator;
import java.util.List;
import model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author pierredebuisson
 */
public class UserDAOImpl extends DAOImpl<User> implements DAO<User>, UserDAO {

    @Override
    public List<User> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        @SuppressWarnings("unchecked")
        List<User> users = (List<User>) session.createQuery("from User").list();
        session.close();
        return users;

    }

    @Override
    public User findById(Integer id, User object) {
        return super.findById(id, object);
    }

    @Override
    public User create(User object) {
        return super.create(object);
    }

    @Override
    public User update(User object) {
        return super.update(object);
    }

    @Override
    public User delete(User object) {
        return super.delete(object);
    }

    @Override
    public User getByUsername(String username) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "FROM User u WHERE u.pseudo=:pseudo";
        Query query = session.createQuery(hql);
        query.setParameter("pseudo", username);
        List list = query.list();
        transaction.commit();
        Iterator iterator = list.iterator();
        User user = (User) iterator.next();
        session.close();
        return user;
    }

}
