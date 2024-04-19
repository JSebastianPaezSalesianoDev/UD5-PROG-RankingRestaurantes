package net.ripadbaisor.gestion;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import net.ripadbaisor.auxiliar.ValidadorString;
import net.ripadbaisor.excepciones.InputInvalidoException;
import net.ripadbaisor.restaurante.Restaurante;

public class Gestor {

    private ArrayList<Restaurante> restaurantes = new ArrayList<>();
    private ValidadorString validadorString = new ValidadorString();

    public Restaurante añadiRestaurante() throws InputInvalidoException {
        String nombre = null;
        try {
            nombre = JOptionPane.showInputDialog("Introduce el nombre del restaurante");
            if (nombre == null || nombre.isEmpty()) {
                throw new InputInvalidoException("El campo no puede estar vacío");
                
            }
            
        } catch (InputInvalidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), nombre, 0);
            
        }

        String localizacion = JOptionPane.showInputDialog("Introduce la localizacion del restaurante");
        validadorString.validarString(localizacion);
        
        String horario = JOptionPane.showInputDialog("Introduce el horario del restaurante");
        validadorString.validarString(horario);

        double puntuacion = 0.0d;
        
        try {
            puntuacion = Double.parseDouble(JOptionPane.showInputDialog("Introduce la puntuación del restaurante"));
        } catch (NumberFormatException e) {
            System.out.println("Ingrese un valor numerico");
        }
        
        Restaurante restaurante = new Restaurante(nombre, localizacion, horario, puntuacion);
        restaurantes.add(restaurante);
        return restaurante; 
    }
    

    public void editarRestaurante() {

        String restauranteEditar = JOptionPane.showInputDialog("Introduce el nombre del restaurante que quiera editar");

        for (Restaurante restaurante : restaurantes) {

            if (restauranteEditar != null && restauranteEditar.equalsIgnoreCase(restaurante.getNombre())) {

                int opcionUsuario = Integer.parseInt(JOptionPane.showInputDialog(
                        "Que apartado desea modificar, ingrese el numero\n1.nombre\n2.localizacion\n3.horario\n4.puntuacion"));

                switch (opcionUsuario) {

                    case 1:
                        String nuevoNombre = JOptionPane
                                .showInputDialog("ingrese el nuevo nombre para el restaurante" + restauranteEditar);

                        restaurante.setNombre(nuevoNombre);
                        break;
                    case 2:
                        String nuevaLocalizacion = JOptionPane.showInputDialog("Ingrese la nueva localizacion");

                        restaurante.setLocalizacion(nuevaLocalizacion);
                        break;
                    case 3:
                        String nuevoHorario = JOptionPane.showInputDialog("Ingrese el nuevo horario");

                        restaurante.setHorario(nuevoHorario);
                        break;
                    case 4:
                        double nuevaPuntuacion = Double
                                .parseDouble(JOptionPane.showInputDialog("Introduce la nueva puntuacion"));

                        restaurante.setPuntuacion(nuevaPuntuacion);
                        break;
                    default:
                        System.out.println("Ingrese un valor numerico valido");
                        break;
                }
            }
        }

    }

    public void mostrarRestaurantes() {

        Collections.sort(restaurantes, (r1, r2) -> Double.compare(r2.getPuntuacion(), r1.getPuntuacion()));
        JOptionPane.showMessageDialog(null, restaurantes.toString());
    }

    public void eliminarRestaurante() {
        String opcionEliminar = JOptionPane.showInputDialog("Ingrese el nombre del restaurante a eliminar");

        for (int i = restaurantes.size() - 1; i >= 0; i--) {
            if (restaurantes.get(i).getNombre().equals(opcionEliminar)) {
                restaurantes.remove(i);
            }
        }
    }

}
