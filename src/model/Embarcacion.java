package model;

/**
 * Representa una embarcación dentro del sistema. Esta clase hereda los
 * atributos de RecursoAgencia y añade información sobre su capacidad de
 * pasajeros.
 */
public class Embarcacion extends RecursoAgencia implements Registrable {

    private int capacidad;

    public Embarcacion() {
    }

    /**
     * Constructor parametrizado para inicializar una nueva embarcación.
     *
     * @param codigo El identificador único de la embarcación.
     * @param nombre El nombre o marca de la embarcación.
     * @param disponible El estado de disponibilidad del recurso.
     * @param capacidad La capacidad máxima de personas a bordo.
     */
    public Embarcacion(String codigo, String nombre, boolean disponible, int capacidad) {
        super(codigo, nombre, disponible);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Retorna el mensaje de confirmación específico para el registro de una
     * embarcación.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Embarcacion " + getNombre() + " registrada correctamente.";
    }

    /**
     * Genera un resumen detallado incluyendo la capacidad de la embarcación.
     *
     * @return String con la ficha completa de la embarcación.
     */
    @Override
    public String resumen() {
        return "\n--- FICHA DE EMBARCACION ---\n"
                + "Nombre        : " + getNombre() + "\n"
                + "Codigo        : " + getCodigo() + "\n"
                + "Disponibilidad: " + getEstadoTexto() + "\n"
                + "Capacidad     : " + this.capacidad + " personas a bordo\n";
    }

    /**
     * Retorna la representación de la embarcación en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato:
     * EMBARCACION;CODIGO;NOMBRE;DISPONIBILIDAD;CAPACIDAD.
     */
    @Override
    public String lineaTexto() {
        return "EMBARCACION;" + getCodigo() + ";" + getNombre() + ";" + booleanString() + ";" + this.capacidad;
    }

}
