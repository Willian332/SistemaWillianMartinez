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
public class ControllerConsultaVendas extends AbstractTableModel{
    
    
     private List lista;

    public void setList(List lista) {
        this.lista = lista;
         this.fireTableDataChanged();
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
        
        return "";
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        }
        if (columnIndex == 1) {
            return "Nome";
        }
        if (columnIndex == 2) {
            return "Valor";
        }
        
        return "";
    }
}
