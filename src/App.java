import net.ripadbaisor.gestion.Gestor;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Gestor gestor = new Gestor();

        gestor.añadiRestaurante();
    }
}
