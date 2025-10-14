/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.WamVenda;

/**
 *
 * @author user
 */
public class ControllerVendas extends AbstractTableModel{

   List lista;
    
    public void setList(List lista) {
        this.lista = lista;
    }
    
    public Object getBean(int rowIndex) {
        return lista.get(rowIndex);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           WamVenda venda = (WamVenda) lista.get(rowIndex);

        if (columnIndex == 0) {
            return venda.getIdVenda();
        } 
        
        if (columnIndex == 1) {
            return venda.getWamDesconto();
        } 
        
        if (columnIndex == 2) {
            return venda.getWamValor();
        }
        
        if (columnIndex == 3) {
            return venda.getDataVenda();
        }
        
        
        return "";
    }
    
    @Override
    public String getColumnName (int column) {
        if (column == 0) return "Nº venda";
        if (column == 1) return "Desconto";
        if (column == 2) return "Valor";
        if (column == 3) return "Data da venda";
        
        return "";
    }

    
    
    
}
