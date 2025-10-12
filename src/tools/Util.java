/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



/**
 *
 * @author user
 */
public class Util {
    
    // Classe utilitária com métodos estáticos (você não precisa criar um objeto para usar).
  public static void habilitar(boolean valor, JComponent ... componentes ){
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
        }
    }
    
    public static void limpar(JComponent ... componentes){
        for (int i = 0; i < componentes.length; i++) {
            if(componentes[i] instanceof JTextField){
                ((JTextField) componentes[i]).setText("");
            }
            if(componentes[i] instanceof JComboBox){
                ((JComboBox) componentes[i]).setSelectedIndex(-1);
            }
            if(componentes[i] instanceof JCheckBox){
                ((JCheckBox) componentes[i]).setSelected(false);
            }
        }
    }
    
    public static void mensagem(String cad) {
        JOptionPane.showMessageDialog(null, cad);
    }
    
    public static boolean perguntar(String cad){
        int perguntar = JOptionPane.showConfirmDialog(null, cad, cad, JOptionPane.YES_NO_OPTION);
            if(perguntar == JOptionPane.YES_OPTION){
                return true;
            }else{
                return false;
            }
    }
    
    public static int strParaInt(String cad){
        return Integer.parseInt(cad);
    }
    public static String intParaString(int num){
        return String.valueOf(num);
    }
    public static double strParaDouble(String cad){
        return Double.parseDouble(cad);
    }
    public static String DoubleParaStr(double num){
        return String.valueOf(num);
    }
    public static Date strParaDate (String cad){
      
     if (cad == null) {
            System.out.println("⚠️ Campo de data nulo");
            return null;
        }

        cad = cad.trim();

        if (cad.isEmpty() || cad.equals("__/__/____")) {
            System.out.println("⚠️ Campo de data vazio");
            return null;
        }

        Date data = null;
        String[] formatos = { "dd/MM/yyyy", "yyyy-MM-dd" };

        for (String formato : formatos) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(formato);
                sdf.setLenient(false); // impede datas inválidas
                data = sdf.parse(cad);
                System.out.println("✅ Data convertida com sucesso: " + data);
                return data;
            } catch (ParseException e) {
                // tenta o próximo formato
            }
        }

        System.out.println("❌ Erro ao converter data: " + cad);
        return null;
    }
    
    public static String dataParaString(Date cad) {//cad =data
        if(cad == null) return "";
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData.format(formatoData);
        
    }
}