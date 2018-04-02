/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Anar Salami
 */
public class TextFieldHelper {
    
    public static boolean istextFieldNotEmpty(JTextField txt){
      
        boolean b = false;
        if(txt.getText().length() != 0 || !txt.getText().isEmpty()){
            b = true;
        }
        return b;
    }
    
    public static boolean istextFieldNotEmpty(JTextField txt, JLabel lbl, String message){
        boolean b = true;
        String error="";
        if( !istextFieldNotEmpty(txt)){
            b=false;
            error = message;
        }
        lbl.setText(error);
        return b;
    }
    
}
