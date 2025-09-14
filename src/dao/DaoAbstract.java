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

/**
 *
 * @author user
 */
public abstract class DaoAbstract {
    
     protected Connection cnt;
    
    public DaoAbstract(){
   try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url, user, pass;
            url = "jdbc:mysql://localhost:3306/db_willian_martinez";
            user = "root";
            pass = "12345";
            cnt = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

//            try {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/db_willian_martinez";
//        cnt = DriverManager.getConnection(url, "root", "");
//    } catch (ClassNotFoundException | SQLException e) {
//        throw new RuntimeException("Falha ao abrir conexão", e);
//    }
    
    }
    
     public abstract void insert(Object object);
     public abstract void update(Object object);    
     public abstract void delete(Object object);
     public abstract Object list(int id);
     public abstract Object listAll();
    
}
