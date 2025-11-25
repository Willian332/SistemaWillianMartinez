/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import bean.WamVendaProduto;

/**
 *
 * @author user
 */
public class ControllerVendasProdutos extends AbstractTableModel{

    private List lstWam_VendProdu;

    public void setList(List lstWam_VendProdu) {
        this.lstWam_VendProdu = lstWam_VendProdu;
        this.fireTableDataChanged();
    }
    
    public WamVendaProduto getBean(int rowIndex) {
        return (WamVendaProduto) lstWam_VendProdu.get(rowIndex);
    }
    public void addBean(WamVendaProduto pedidosProdutos) {
        this.lstWam_VendProdu.add(pedidosProdutos);
        this.fireTableDataChanged();
    }
    public void removeBean( int rowIndex) {
        this.lstWam_VendProdu.remove(rowIndex);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lstWam_VendProdu.size();
                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        WamVendaProduto pedProd = (WamVendaProduto) lstWam_VendProdu.get( rowIndex);
        if ( columnIndex == 0 ){
            return pedProd.getWamProduto().getIdProduto();
        } else if (columnIndex ==1) {
            return pedProd.getWamProduto().getWamNome();        
        } else if (columnIndex ==2) {
            return pedProd.getWamQuantidade();
        } else if (columnIndex ==3) {
            return pedProd.getWamValorUnitario();
        }else if (columnIndex ==4) {
            return pedProd.getWamValorUnitario()* pedProd.getWamQuantidade();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitario";
        }  else if(columnIndex == 4){
            return "Total";
        }
        return "";
    }
    
}
