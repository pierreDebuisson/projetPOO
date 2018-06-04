/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Game;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author ursul
 */
public class GameDAOImpl extends DAOImpl<Game> implements DAO<Game> {

    @Override
    public List<Game> findAll() {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Game> games = (List<Game>) session.createQuery("from Game").list();
                session.close();
		return games;
    }

    @Override
    public Game findById(Integer id, Game object) {
        return super.findById(id, object);
    }

    @Override
    public Game create(Game object) {
        return super.create(object);
    }

    @Override
    public Game update(Game object) {
        return super.update(object);
    }

    @Override
    public Game delete(Game object) {
        return super.delete(object);
    }
    
    
}
