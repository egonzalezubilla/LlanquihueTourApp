package model;

/**
 * Representa a un guía turístico dentro del sistema. Esta clase hereda los
 * atributos de Persona y añade información específica sobre su formación.
 */
public class GuiaTuristico extends Persona implements Registrable {

    private String capacitacion;

    public GuiaTuristico() {
    }

    /**
     * Constructor parametrizado para inicializar un nuevo Guía Turístico.
     *
     * @param rut El RUT del guía.
     * @param nombre El nombre completo del guía.
     * @param telefono El número de teléfono de contacto.
     * @param capacitacion La capacitación o formación técnica del guía.
     */
    public GuiaTuristico(String rut, String nombre, int telefono, String capacitacion) {
        super(rut, nombre, telefono);
        this.capacitacion = capacitacion;
    }

    public String getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(String capacitacion) {
        this.capacitacion = capacitacion;
    }

    /**
     * Retorna el mensaje de confirmación específico para el registro de un
     * guía.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Guia turistico " + getNombre() + " registrado correctamente.";
    }

    /**
     * Genera un resumen detallado incluyendo la capacitación del guía.
     *
     * @return String con la ficha completa del guía.
     */
    @Override
    public String resumen() {
        return "\n--- FICHA DEL GUIA TURISTICO ---\n"
                + "Nombre      : " + getNombre() + "\n"
                + "RUT         : " + getRut() + "\n"
                + "Teléfono    : " + getTelefono() + "\n"
                + "Capacitacion: " + this.capacitacion + "\n";
    }

    /**
     * Retorna la representación del guía en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato: GUIA;RUT;NOMBRE;TELEFONO;CAPACITACION.
     */
    @Override
    public String lineaTexto() {
        return "GUIA;" + getRut() + ";" + getNombre() + ";" + getTelefono() + ";" + this.capacitacion;
    }

}
