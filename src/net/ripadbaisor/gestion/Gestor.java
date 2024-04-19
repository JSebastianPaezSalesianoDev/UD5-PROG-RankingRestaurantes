package net.ripadbaisor.gestion;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import net.ripadbaisor.restaurante.Restaurante;

public class Gestor {

    ArrayList<Restaurante> restaurantes = new ArrayList<>();

    private Restaurante crearNuevoRestaurante() {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del restaurante");
        String localizacion = JOptionPane.showInputDialog("Introduce la localizacion del restaurante");
        String horario = JOptionPane.showInputDialog("Introduce el horario del restaurante");
        double puntuacion = 0.0d;

        try {

            puntuacion = Double
                    .parseDouble(JOptionPane.showInputDialog("Introduce la puntuación del restaurante"));

        } catch (NumberFormatException e) {

            System.out.println("Ingrese un valor numerico");
        }

        return new Restaurante(nombre, localizacion, horario, puntuacion);
    }

    public void añadiRestaurante() {

        boolean hayEspacio = false;
        for (int i = 0; i < restaurantes.size(); i++) {
            if (restaurantes.get(i) == null) {
                hayEspacio = true;

                restaurantes.set(i, crearNuevoRestaurante());
                break;
            }
        }

        if (!hayEspacio) {
            restaurantes.add(crearNuevoRestaurante());
        }
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
