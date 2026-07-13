package model;

public class Persona {

    private String nombre;
    private String rut;
    private int telefono;

    public Persona() {
    }

    public Persona(String nombre, String rut, int telefono) {
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
