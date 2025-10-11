/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author user
 */
public abstract class DaoAbstract {
    
    
     Session session;

    public DaoAbstract() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();        
    }
     public abstract void insert(Object object);
     public abstract void update(Object object);    
     public abstract void delete(Object object);
     public abstract Object list(int id);
     public abstract Object listAll();
    
}
