package net.ripadbaisor.gestion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import net.ripadbaisor.restaurante.Restaurante;

public class Gestor {

    ArrayList<Restaurante> restaurantes = new ArrayList<>();

    private Restaurante crearNuevoRestaurante() {
        String nombre = JOptionPane.showInputDialog("Introduce el nombre del restaurante");
        String localizacion = JOptionPane.showInputDialog("Introduce la localizacion del restaurante");
        String horario = JOptionPane.showInputDialog("Introduce el horario del restaurante");
        double puntuacion = Double.parseDouble(JOptionPane.showInputDialog("Introduce la puntuación del restaurante"));
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

}
