/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import bean.WamUsuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author marcos
 */
public class UsuariosDAO extends DaoAbstract{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
         session.flush();
         session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
         session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamUsuario.class);
        criteria.add(Restrictions.eq("wam_idUsuario", id) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
         session.beginTransaction();
        Criteria criteria = session.createCriteria(WamUsuario.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
     public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.listAll();
        System.out.println("teste ok");
    }

    
}
