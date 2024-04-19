package net.ripadbaisor.auxiliar;

import javax.swing.JOptionPane;

public class ValidarDouble {

    public ValidarDouble(){}

    public static void validarDouble(String valor) {
        try {
        
            double validado = Double.parseDouble(valor);
            
            if (validado == 0) {
                JOptionPane.showMessageDialog(null, "El campo " + validado + " no es correcto");
            }
        } catch (NumberFormatException e) {
      
            JOptionPane.showMessageDialog(null, "El número ingresado no es válido: " + valor);
        }
    }
}
