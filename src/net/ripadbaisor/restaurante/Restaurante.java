package net.ripadbaisor.restaurante;
public class Restaurante {
    
    private String nombre;
    private String localizacion;
    private String horario;
    private double puntuacion;

    public Restaurante(String nombre, String localizacion, String horario, double puntuacion){

        this.nombre = nombre;
        this.localizacion = localizacion;
        this.horario = horario;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return this.localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getHorario() {
        return this.horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Restaurante " + nombre + "\nlocalizacion: " + localizacion + "\nhorario:" + horario
                + "\npuntuacion:" + puntuacion + "\n\n";
    }

    
}
