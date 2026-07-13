package model;

public class Vehiculo extends RecursoAgencia implements Registrable {

    private String patente;

    public Vehiculo() {
    }

    public Vehiculo(String nombre, String codigo, String disponible, String patente) {
        super(nombre, codigo, disponible);
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String registrar() {
        return ("Vehiculo patente " + patente + " registrado con exito.");
    }

    @Override
    public String resumen() {
        return ("\n-- VEHICULO --\n"
                + "\nNombre        : " + getNombre()
                + "\nCodigo        : " + getCodigo()
                + "\nDisponibilidad: " + getDisponible()
                + "\nPatente       : " + patente);
    }

}
