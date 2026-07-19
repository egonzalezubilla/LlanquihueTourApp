package model;

/**
 * Representa un vehículo dentro del sistema. Esta clase hereda los atributos de
 * RecursoAgencia y añade información sobre el kilometraje acumulado.
 */
public class Vehiculo extends RecursoAgencia implements Registrable {

    private int kilometraje;

    public Vehiculo() {
    }

    /**
     * Constructor parametrizado para inicializar un nuevo vehículo.
     *
     * @param codigo La patente del vehículo.
     * @param nombre El nombre o marca del vehículo.
     * @param disponible El estado de disponibilidad del recurso.
     * @param kilometraje El kilometraje total recorrido por el vehículo.
     */
    public Vehiculo(String codigo, String nombre, boolean disponible, int kilometraje) {
        super(codigo, nombre, disponible);
        this.kilometraje = kilometraje;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    /**
     * Retorna el mensaje de confirmación específico para el registro de un
     * vehículo.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Vehiculo patente " + getCodigo() + " registrado correctamente.";
    }

    /**
     * Genera un resumen detallado incluyendo el kilometraje del vehículo.
     *
     * @return String con la ficha completa del vehículo.
     */
    @Override
    public String resumen() {
        return "\n--- FICHA DE VEHICULO ---\n"
                + "Nombre        : " + getNombre() + "\n"
                + "Patente       : " + getCodigo() + "\n"
                + "Disponibilidad: " + getEstadoTexto() + "\n"
                + "Capacidad     : " + this.kilometraje + " kilometros recorridos\n";
    }

    /**
     * Retorna la representación del vehículo en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato:
     * VEHICULO;PATENTE;NOMBRE;DISPONIBILIDAD;KILOMETRAJE.
     */
    @Override
    public String lineaTexto() {
        return "VEHICULO;" + getCodigo() + ";" + getNombre() + ";" + booleanString() + ";" + this.kilometraje;
    }

}
