/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Game;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ursul
 */
public class GameDAOTest {
    
    public GameDAOTest() {
    }
    
    private static GameDAOImpl gameDAO;
    private static UserDAOImpl userDAO;
    private Game gameRes;
    
    
    @BeforeClass
    public static void init()
    {
        gameDAO = new GameDAOImpl();
        userDAO = new UserDAOImpl();
        List<Game> games = gameDAO.findAll();
        for (Game game : games) {
            gameDAO.delete(game);
            
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        //GIVEN
        Game game = new Game();
        game.setId(null);
        game.setDate("04/06/2018");
        game.setNbRound(3);
        List<User> users = userDAO.findAll();
        User user = users.get(0); 
        game.setIdUser(user);
        //WHEN
        gameRes = gameDAO.create(game);
        //THEN
        assertNotNull(gameRes.getId());
    }
    
    @After
    public void update()
    {
        //GIVEN
        List<Game> games = gameDAO.findAll();
        Integer id = games.get(0).getId();
        gameRes = gameDAO.findById(id, gameRes);
        gameRes.setNbRound(4);
        //WHEN
        Game gameUpdated = gameDAO.update(gameRes);
        //THEN
        assertNotNull(gameUpdated.getId());
        assertEquals(gameUpdated.getNbRound(),4);
    }
}
