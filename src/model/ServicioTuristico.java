package model;

public class ServicioTuristico {

    private String nombre;
    private int duracionHoras;

    public ServicioTuristico() {
    }

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre Actividad   : " + nombre + ".");
        System.out.println("Duracion           : " + duracionHoras + " Hr(s).");
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
