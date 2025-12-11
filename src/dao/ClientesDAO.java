/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.WamCliente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author user
 */
public class ClientesDAO extends DaoAbstract{
    
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
        Criteria criteria = session.createCriteria(WamCliente.class);
        criteria.add(Restrictions.eq("idCliente", id) );
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
         session.beginTransaction();
        Criteria criteria = session.createCriteria(WamCliente.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public Object WAM_list_tAtivos(String ativo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamCliente.class);
        criteria.add(Restrictions.eq("wamAtivo", ativo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // 2. Buscar por NOME (qualquer status)
    public Object WAM_list_PorNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamCliente.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // 3. Buscar ATIVOS por NOME
    public Object WAM_list_AtivosPorNome(String ativo, String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamCliente.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        criteria.add(Restrictions.eq("wamAtivo", ativo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // 4. Buscar por SEXO (qualquer status)
    public Object WAM_list_PorSexo(String sexo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamCliente.class);
        criteria.add(Restrictions.eq("wamSexo", sexo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // 5. Buscar ATIVOS por SEXO
    public Object WAM_list_AtivosPorSexo(String ativo, String sexo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamCliente.class);
        criteria.add(Restrictions.eq("wamSexo", sexo));
        criteria.add(Restrictions.eq("wamAtivo", ativo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // 6. Buscar por NOME + SEXO (qualquer status)
    public Object WAM_list_PorNomeSexo(String nome, String sexo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamCliente.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        criteria.add(Restrictions.eq("wamSexo", sexo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    // 7. Buscar ATIVOS por NOME + SEXO
    public Object WAM_list_AtivosPorNomeSexo(String ativo, String nome, String sexo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(WamCliente.class);
        criteria.add(Restrictions.like("wamNome", "%" + nome + "%"));
        criteria.add(Restrictions.eq("wamSexo", sexo));
        criteria.add(Restrictions.eq("wamAtivo", ativo));
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
