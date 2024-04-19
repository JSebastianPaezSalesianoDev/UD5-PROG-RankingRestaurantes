package net.ripadbaisor.auxiliar;

import javax.swing.JOptionPane;

import net.ripadbaisor.excepciones.InputInvalidoException;

public class ValidadorString {

    public ValidadorString() {

    }

    public void validarString(String validado) {

        try {
            
            if (validado == null || validado.isEmpty()) {
                throw new InputInvalidoException("El campo "+ validado + " no puede estar vacío");
                
            }

        } catch (InputInvalidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, 0);
            

        }

    }
}
