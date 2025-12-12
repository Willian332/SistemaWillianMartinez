/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.WamVenda;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user
 */
public class VendasDAO extends DaoAbstract {
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
        Criteria criteria = session.createCriteria(WamVenda.class);
        criteria.add(Restrictions.eq("idVenda", id) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listVendedor(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVenda.class).createAlias("wamVendedor", "vendedor"); 
        criteria.add(Restrictions.like("vendedor.wamNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
    public Object WAM_list_Valor(Double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVenda.class);
        criteria.add(Restrictions.ge("wamValor", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object WAM_list_NomeValor(String nome, Double valor) {
        session.beginTransaction();
       
        Criteria criteria = session.createCriteria(WamVenda.class).createAlias("wamVendedor", "vendedor"); 
         criteria.add(Restrictions.like("vendedor.wamNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("wamValor", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
         session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVenda.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
     public static void main(String[] args) {
        VendasDAO vendasDAO = new VendasDAO();
        vendasDAO.listAll();
        System.out.println("teste ok");
    }
}
