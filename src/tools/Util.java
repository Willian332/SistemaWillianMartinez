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
    
    public static void adivertencia(String cad) {
        JOptionPane.showMessageDialog(null, cad, "Aviso", JOptionPane.WARNING_MESSAGE);
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
      
            try {
                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                    return formatoData.parse(cad);
                } catch (ParseException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;

    }
    
    public static String dataParaString(Date cad) {//cad =data
         if(cad == null) return "";
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        return formatoData.format(cad); 
        
    }
    
    public static boolean validEmail(String email) {
         
    if (email == null || email.trim().isEmpty()) {
        return false; 
    }
    
    String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    
    return email.matches(regex);
        
    }
    
    public static boolean validarEmailComAlerta(String email, java.awt.Component parent) {
    // 1. Verifica se está vazio
    if (email == null || email.trim().isEmpty()) {
        JOptionPane.showMessageDialog(parent, "Email não pode estar vazio!", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        return false; // Para execução e mostra alerta
    }
    
    // 2. Verifica formato usando o primeiro método
    if (!validEmail(email)) {
        JOptionPane.showMessageDialog(parent, 
            " MEEEUUU DEUS Email inválido ser Humano!\n\n" +
            "Formato para o email é: usuario@exemplo.com\n" +
            "Deve ter @ \n" +
            "També(ex: .com, .com.br)\n" +
            "Não pode ter espaços", 
            "Email é Inválido", 
            JOptionPane.ERROR_MESSAGE);
        return false; // Para execução e mostra alerta detalhado
    }
    
    // se está sero o email é valido
    return true; 
}
}