package net.ripadbaisor.excepciones;

public class InputInvalidoException extends RuntimeException {

    public InputInvalidoException(String mensaje) {
        super(mensaje);

        if (mensaje == null || mensaje.isEmpty()) {
            throw new InputInvalidoException("Debe ingresar un valor que sea diferente de nada y null");
        }
    }
}
