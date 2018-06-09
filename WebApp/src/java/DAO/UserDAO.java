/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import model.User;

/**
 *
 * @author pierredebuisson
 */
public interface UserDAO extends DAO<User>{
    
    /**
     * Get a user by its username
     * @param username : usename in input
     * @return User from the database.
     */
    User getByUsername(String username);
    
}
