package net.ripadbaisor.gestion;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import net.ripadbaisor.auxiliar.ValidadorString;
import net.ripadbaisor.auxiliar.ValidarDouble;
import net.ripadbaisor.excepciones.InputInvalidoException;
import net.ripadbaisor.restaurante.Restaurante;

public class Gestor {

    private ArrayList<Restaurante> restaurantes = new ArrayList<>();

    public Restaurante añadiRestaurante() throws InputInvalidoException {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del restaurante");
        ValidadorString.validarString(nombre);

        String localizacion = JOptionPane.showInputDialog("Introduce la localizacion del restaurante");
        ValidadorString.validarString(localizacion);

        String horario = JOptionPane.showInputDialog("Introduce el horario del restaurante");
        ValidadorString.validarString(horario);

        String puntuacion = JOptionPane.showInputDialog("Introduce la puntuación del restaurante");
        ValidadorString.validarString(puntuacion);

        if (puntuacion == null || puntuacion.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una puntuación");
            return añadiRestaurante();
        }
        double puntuacionDouble = Double.parseDouble(puntuacion);
        ValidarDouble.validarDouble(puntuacion);

        Restaurante restaurante = new Restaurante(nombre, localizacion, horario, puntuacionDouble);
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
                        ValidadorString.validarString(nuevoNombre);

                        restaurante.setNombre(nuevoNombre);
                        break;
                    case 2:
                        String nuevaLocalizacion = JOptionPane.showInputDialog("Ingrese la nueva localizacion");
                        ValidadorString.validarString(nuevaLocalizacion);
                        restaurante.setLocalizacion(nuevaLocalizacion);
                        break;
                    case 3:
                        String nuevoHorario = JOptionPane.showInputDialog("Ingrese el nuevo horario");
                        ValidadorString.validarString(nuevoHorario);
                        restaurante.setHorario(nuevoHorario);
                        break;
                    case 4:
                        String nuevaPuntuacion = JOptionPane.showInputDialog("Introduce la nueva puntuacion");
                        ValidadorString.validarString(nuevaPuntuacion);

                        if (nuevaPuntuacion == null || nuevaPuntuacion.trim().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Debe ingresar una puntuación");
                            return;
                        }
                        double puntuacionDouble = Double.parseDouble(nuevaPuntuacion);
                        ValidarDouble.validarDouble(nuevaPuntuacion);
                        restaurante.setPuntuacion(puntuacionDouble);
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
