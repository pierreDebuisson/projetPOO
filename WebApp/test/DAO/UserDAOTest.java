package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author pierredebuisson
 */
public class UserDAOTest {
    
    private static UserDAOImpl userDAO;
    private User userRes;
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void init()
    {
        userDAO = new UserDAOImpl();
        List<User> users = userDAO.findAll();
        for (User user : users) {
            userDAO.delete(user);
            
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        //GIVEN
        User user = new User();
        user.setId(null);
        user.setPassword("test");
        user.setPseudo("Pierre");
        user.setScore(0);
        //WHEN
        userRes = userDAO.create(user);
        //THEN
        assertNotNull(userRes.getId());
    }
    
    @After
    public void update()
    {
        //GIVEN
        List<User> users = userDAO.findAll();
        Integer id = users.get(0).getId();
        userRes = userDAO.findById(id, userRes);
        userRes.setPassword("Test2");
        //WHEN
        User userUpdated = userDAO.update(userRes);
        //THEN
        assertNotNull(userUpdated.getId());
    }
}
