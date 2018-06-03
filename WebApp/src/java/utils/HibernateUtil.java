/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.Computer;
import model.Game;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author pierredebuisson
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory without hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.setProperty( "connection.driver_class", "" );
            configuration.setProperty( "hibernate.dialect", "org.hibernate.dialect.MySQLDialect" );
            configuration.setProperty( "hibernate.connection.driver_class", "com.mysql.jdbc.Driver" );
            configuration.setProperty( "hibernate.connection.username", "poo" );
            configuration.setProperty( "hibernate.connection.password", "oNx1anNyOyZyDdzh" );
            configuration.setProperty( "hibernate.connection.url", "jdbc:mysql://localhost:3306/projetPOO?zeroDateTimeBehavior=convertToNull" );
            configuration.setProperty( "connection_pool_size", "10" );
            configuration.setProperty( "hibernate.hbm2ddl.auto", "update" );
            configuration.setProperty( "show_sql", "false" );
            configuration.addAnnotatedClass( Game.class );
            configuration.addAnnotatedClass( Computer.class );
            configuration.addAnnotatedClass( User.class );
            
            sessionFactory = configuration.buildSessionFactory();
            return sessionFactory;
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
