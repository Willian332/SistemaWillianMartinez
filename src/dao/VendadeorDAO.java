/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.WamVendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u05594757139
 */
public class VendadeorDAO extends DaoAbstract{

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
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        criteria.add(Restrictions.eq("wam_idVededor", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object WAM_list_PorNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    
    public Object WAM_list_PorValor(Double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        criteria.add(Restrictions.ge("wamValorMeta", valor)); 
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    
    public Object WAM_list_PorDesconto(Double desconto) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        criteria.add(Restrictions.ge("wamDescontoPermitido", desconto));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    
    public Object WAM_list_PorNomeValor(String nome, Double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("wamValorMeta", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    
    public Object WAM_list_PorNomeDesconto(String nome, Double desconto) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("wamDescontoPermitido", desconto));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
   
    public Object WAM_list_PorValorDesconto(Double valor, Double desconto) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        criteria.add(Restrictions.ge("wamValorMeta", valor));
        criteria.add(Restrictions.ge("wamDescontoPermitido", desconto));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    
    public Object WAM_list_PorNomeValorDesconto(String nome, Double valor, Double desconto) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("wamValorMeta", valor));
        criteria.add(Restrictions.ge("wamDescontoPermitido", desconto));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamVendedor.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
}