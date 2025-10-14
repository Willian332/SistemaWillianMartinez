/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.WamProduto;
/**
 *
 * @author user
 */
public class ControllerProdutos extends AbstractTableModel{
    
    
      List lista;

    public void setList(List lista) {
        this.lista = lista;
    }

    public Object getBean(int rowIndex) {
       return lista.get(rowIndex);    
    }
    
    public int getRowCount() {
        return lista.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        WamProduto wam_produto = (WamProduto) lista.get(rowIndex);
        if (columnIndex == 0) {
            return wam_produto.getIdProduto();
        }
        if (columnIndex == 1) {
            return wam_produto.getWamNome();
        }
        if (columnIndex == 2) {
            return wam_produto.getWamValor();
        }
        if (columnIndex == 3) {
            return wam_produto.getWamAutor();
        }
        return "";
    }

    public String getColumnName(int column) {
        if (column == 0) {
            return "Código";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Valor";
        }
        if (column == 3) {
            return "Autor";
        }
        return "";
    }
}
