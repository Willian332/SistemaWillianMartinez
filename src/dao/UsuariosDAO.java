/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import bean.Usuarios;
import bean.Usuarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class UsuariosDAO extends DaoAbstract{

    
    
     public UsuariosDAO() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            String url, user, pass;
//            url = "jdbc:mysql://localhost:3306/db_willian_martinez";
//            user = "root";
//            pass = "";
//            cnt = DriverManager.getConnection(url, user, pass);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
     
    public boolean verificacao(String apelido, String senha) {
        try {
            PreparedStatement pst;
            pst = cnt.prepareStatement("select * from wam_usuario where wam_apelido=? and wam_senha=?");
            pst.setString(1, apelido);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            if(rs.next()==true) return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;}
    

    

    @Override
    public void insert(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
//            Statement stm = cnt.createStatement();
//            stm.executeUpdate("insert into usuarios values("+usuarios.getIdusuarios()+", '"+usuarios.getNome()+"')");
            PreparedStatement pst = cnt.prepareStatement("insert into wam_usuario values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, usuarios.getWam_idusuarios());
            pst.setString(2, usuarios.getWam_nome());
            pst.setString(3, usuarios.getWam_apelido());
            pst.setString(4, usuarios.getWam_cpf());
            java.sql.Date dataVenda = new java.sql.Date(usuarios.getWam_dataNascimento().getTime());
            pst.setDate(5, dataVenda);
            
            pst.setInt(6, usuarios.getWam_nivel());//nivel
            pst.setString(7, usuarios.getWam_ativo());//ativo
            pst.setString(8, usuarios.getWam_senha());//ativo
            
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("update wam_usuario set wam_nome=?, wam_apelido=?, wam_cpf=?, "
                    + "wam_datanascimento=?, wam_nivel=?, wam_ativo =?, wam_senha=? where wam_idusuario=?");
            pst.setInt(8, usuarios.getWam_idusuarios());
            pst.setString(1, usuarios.getWam_nome());
            pst.setString(2, usuarios.getWam_apelido());
            pst.setString(3, usuarios.getWam_cpf());
            //pst.setDate(4, null);//usuarios.getDataNascimento()
             java.sql.Date dataVenda = new java.sql.Date(usuarios.getWam_dataNascimento().getTime());
            pst.setDate(4, dataVenda);
            pst.setInt(5, usuarios.getWam_nivel());//nivel
            pst.setString(6, usuarios.getWam_ativo());//ativo
            pst.setString(7, usuarios.getWam_senha());//ativo
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Usuarios usuarios = (Usuarios) object;
        try {
            PreparedStatement pst = cnt.prepareStatement("delete from wam_usuario where wam_idUsuario =?");
            pst.setInt(1, usuarios.getWam_idusuarios());
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public Object list(int id) {
        PreparedStatement pst;
        try {
            pst = cnt.prepareStatement("select * from wam_usuario where wam_idUsuario=?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next() == true) {
                Usuarios usuarios = new Usuarios();
                usuarios.setWam_idusuarios( rs.getInt("wam_idUsuario") );
                usuarios.setWam_nome(rs.getString("wam_nome") );
                usuarios.setWam_apelido(rs.getString("wam_apelido") );
                usuarios.setWam_cpf(rs.getString("wam_cpf") );
                usuarios.setWam_dataNascimento(rs.getDate("wam_dataNascimento") );
                usuarios.setWam_nivel(rs.getInt("wam_nivel") );
                usuarios.setWam_ativo(rs.getString("wam_ativo") );
                usuarios.setWam_senha(rs.getString("wam_senha") );
                return usuarios;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Object listAll() {
         List lista;
        try {
                PreparedStatement pst = cnt.prepareStatement("select *  from wam_usuario");
            
            ResultSet rs = pst.executeQuery();
            lista = new ArrayList();
            while (rs.next() == true) {
                Usuarios usuarios = new Usuarios();
                usuarios.setWam_idusuarios(rs.getInt("wam_idUsuario"));
                usuarios.setWam_nome(rs.getString("wam_nome"));
                usuarios.setWam_apelido(rs.getString("wam_apelido"));
                usuarios.setWam_cpf(rs.getString("wam_cpf"));
                usuarios.setWam_dataNascimento(rs.getDate("wam_dataNascimento"));
               
                usuarios.setWam_nivel(rs.getInt("wam_nivel"));
                usuarios.setWam_ativo(rs.getString("wam_ativo"));
                 usuarios.setWam_senha(rs.getString("wam_senha"));
                lista.add( usuarios );
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        Usuarios usuarios = new Usuarios();
        usuarios.setWam_idusuarios(200);
        usuarios.setWam_nome("Willian");
        usuarios.setWam_apelido("Will");
        usuarios.setWam_cpf("123.456.779-29");
        usuarios.setWam_dataNascimento(null);
        usuarios.setWam_nivel(1);
        usuarios.setWam_ativo("S");
        usuarios.setWam_senha("123");
        
        UsuariosDAO usuariosDao = new UsuariosDAO();
        usuariosDao.insert(usuarios);
        System.out.println("perfeito");
    }

   

}
