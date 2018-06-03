/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author pierredebuisson
 */
public class UserDAOImpl extends DAOImpl<User> implements DAO<User>{

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
    
}
