package model;

/**
 * Representa la superclase para los servicios turísticos ofrecidos. Esta clase
 * contiene los atributos básicos de un servicio y hereda sus atributos a las
 * clases Excursion, PaseoLacustre y TourGastronomico.
 */
public class ServicioTuristico implements Registrable {

    private String codigo;
    private String nombre;
    private int cantidad;

    public ServicioTuristico() {
    }

    /**
     * Constructor parametrizado para inicializar un nuevo servicio turístico.
     *
     * @param codigo El código identificador del servicio.
     * @param nombre El nombre del servicio.
     * @param cantidad La cantidad de personas contempladas en el tour.
     */
    public ServicioTuristico(String codigo, String nombre, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Retorna el mensaje de confirmación para el registro de un servicio.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Servicio '" + getNombre() + "' registrado correctamente.";
    }

    /**
     * Genera un resumen detallado del servicio turístico.
     *
     * @return String con la ficha técnica del servicio.
     */
    @Override
    public String resumen() {
        return "\n--- SERVICIO TURISTICO ---\n"
                + "Nombre        : " + getNombre() + "\n"
                + "Codigo        : " + getCodigo() + "\n"
                + "Cantidad      : Tour para " + getCantidad() + " personas\n";
    }

    /**
     * Retorna la representación del servicio en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato: SERVICIO;CODIGO;NOMBRE;CANTIDAD.
     */
    @Override
    public String lineaTexto() {
        return "SERVICIO;" + getCodigo() + ";" + getNombre() + ";" + getCantidad();
    }

}
