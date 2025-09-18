/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

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
    public static void habilitar(boolean valor, JComponent ... componentes) {
        for (int i = 0; i < componentes.length; i++) {
             componentes[i].setEnabled(valor);
            
        }
    }
    public static void limpar(JComponent ... components){
        for (int i = 0; i < components.length; i++) {
            //instanceof função limpar
            if(components[i] instanceof JTextField){
                 ((JTextField)components[i]).setText("");
            }
            if(components[i] instanceof JComboBox){
                 ((JComboBox)components[i]).setSelectedIndex(-1);
            }
            
        }
    }
    public static boolean mensagem(String cad){
        return JOptionPane.showConfirmDialog(null, cad, "teste", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_CANCEL_OPTION) == 0;
        
    }
    public static String perguntar(String cad){
        return JOptionPane.showInputDialog(null, cad);
    }
}
