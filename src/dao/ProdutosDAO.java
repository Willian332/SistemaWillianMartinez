/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.WamProduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user
 */
public class ProdutosDAO extends DaoAbstract{

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
        Criteria criteria = session.createCriteria(WamProduto.class);
        criteria.add(Restrictions.eq("idProduto", id) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamProduto.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        
    public Object listValor(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamProduto.class);
        criteria.add(Restrictions.ge("wamValor", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object listNomeValor(String nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamProduto.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("wamValor", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
         session.beginTransaction();
        Criteria criteria = session.createCriteria(WamProduto.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
     public static void main(String[] args) {
        ProdutosDAO produtosDAO = new ProdutosDAO();
        produtosDAO.listAll();
        System.out.println("teste ok");
    }
    
}
