package model;

public class ServicioTuristico {

    private String nombre;
    private int duracionHoras;

    public ServicioTuristico() {
    }

    @Override
    public String toString() {
        return "\n---- INFORMACION DE SERVICIO TURISTICO ----\n"
                + "Nombre Actividad   : " + nombre
                + "\nDuracion           : " + duracionHoras + " Hr(s).";

    }

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

}
