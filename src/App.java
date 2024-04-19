import javax.swing.JOptionPane;

import net.ripadbaisor.auxiliar.Menu;
import net.ripadbaisor.gestion.Gestor;

public class App {
    public static void main(String[] args) throws Exception {
       
        boolean seguir = true;

        Gestor gestor = new Gestor();

        while (seguir) {
            
            String opcionMenu = "q";

            try {
                opcionMenu = JOptionPane.showInputDialog(Menu.menu());
            } catch (Exception e) {
                
                System.out.println("debe ingresar un valor valido");
            }

        switch (opcionMenu) {
            case "1":
                gestor.añadiRestaurante();
                break;
            case "2":
                gestor.editarRestaurante();
                break;
            case "3": 
                gestor.mostrarRestaurantes();
                break;
            case "4":
                gestor.eliminarRestaurante();
                break;
            case "Q":
                seguir = false;
                break;
            case "q":
                seguir = false;
            default:
                System.out.println("No ingreso ningun valor valido");
                break;
        }
        }

    }
}
