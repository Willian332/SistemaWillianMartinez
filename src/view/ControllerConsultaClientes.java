/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.WamCliente;
/**
 *
 * @author user
 */
public class ControllerConsultaClientes extends AbstractTableModel{
    
    
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
        WamCliente wam_cliente = (WamCliente) lista.get(rowIndex);
        if (columnIndex == 0) {
            return wam_cliente.getIdCliente();
        }
        if (columnIndex == 1) {
            return wam_cliente.getWamAtivo();
        }
        if (columnIndex == 2) {
            return wam_cliente.getWamNome();
        }
        if (columnIndex == 3) {
            return wam_cliente.getWamSexo();
        }
        return "";
    }

    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        }
        if (columnIndex == 1) {
            return "Ativo";
        }
        if (columnIndex == 2) {
            return "Nome";
        }
         if (columnIndex == 3) {
            return "Sexo";
        }
        
        return "";
    }
}
