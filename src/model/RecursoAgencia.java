package model;

/**
 * Representa la superclase para los recursos de la agencia. Esta clase define
 * los atributos básicos de un recurso y hereda métodos de la interfaz
 * {@link Registrable}.
 */
public class RecursoAgencia implements Registrable {

    private String codigo;
    private String nombre;
    private boolean disponible;

    public RecursoAgencia() {
    }

    /**
     * Constructor parametrizado para inicializar un nuevo recurso.
     *
     * @param codigo El identificador único del recurso.
     * @param nombre El nombre o marca del recurso.
     * @param disponible El estado de disponibilidad del recurso.
     */
    public RecursoAgencia(String codigo, String nombre, boolean disponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Convierte el valor booleano de disponibilidad a String.
     *
     * @return "true" o "false" según el estado.
     */
    public String booleanString() {
        return String.valueOf(this.disponible);
    }

    /**
     * Actualiza el estado de disponibilidad a partir de un valor String.
     *
     * @param texto "true" o "false".
     */
    public void stringBoolean(String texto) {
        this.disponible = Boolean.parseBoolean(texto);
    }

    /**
     * Retorna una descripción legible del estado del recurso.
     *
     * @return String con "Disponible para uso" o "No disponible".
     */
    public String getEstadoTexto() {
        if (this.disponible) {
            return "Disponible para uso";
        } else {
            return "No disponible";
        }
    }

    /**
     * Retorna el mensaje de confirmación para el registro de un recurso.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Recurso " + getNombre() + " registrado correctamente.";
    }

    /**
     * Genera un resumen detallado del recurso, incluyendo su estado.
     *
     * @return String con la ficha del recurso.
     */
    @Override
    public String resumen() {
        return "\n--- FICHA DE RECURSO ---\n"
                + "Nombre        : " + getNombre() + "\n"
                + "Codigo        : " + getCodigo() + "\n"
                + "Disponibilidad: " + getEstadoTexto() + "\n";
    }

    /**
     * Retorna la representación del recurso en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato: RECURSO;CODIGO;NOMBRE;DISPONIBILIDAD.
     */
    @Override
    public String lineaTexto() {
        return "RECURSO;" + getCodigo() + ";" + getNombre() + ";" + booleanString();
    }
}
