package net.ripadbaisor.auxiliar;

public class InputInvalidoException extends Exception{

    public InputInvalidoException(String mensaje){
        super(mensaje);
    }
    
    public static void InputInvalidoException( String mensaje) throws InputInvalidoException{

        if (mensaje == null || mensaje.isEmpty()) {

            throw new InputInvalidoException("");
        }
        
    }
}
