/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author pierredebuisson
 */
public class DAOImpl<T> implements DAO<T> {

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findById(Integer id, T o) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();
	Object object = session.get(o.getClass(), id);
	session.close();
	return (T)object;
    }

    @Override
    public T create(T object) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
		return object;    }

    @Override
    public T update(T object) {
SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(object);
		session.getTransaction().commit();
		session.close();
		return object;    }

    @Override
    public T delete(T object) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		session.close();
		return object;
    }
    
}
