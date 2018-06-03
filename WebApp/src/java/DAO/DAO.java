/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author pierredebuisson
 */
public interface DAO<T> {
    
    List<T> findAll();
    T findById(Integer id, T object);
    T create(T object);
    T update(T object);
    T delete(T object);
    
}
