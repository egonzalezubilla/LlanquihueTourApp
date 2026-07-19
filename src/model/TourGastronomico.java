package model;

/**
 * Representa un tour gastronómico dentro del sistema. Esta clase hereda los
 * atributos de ServicioTuristico y añade información sobre el número de
 * paradas.
 */
public class TourGastronomico extends ServicioTuristico implements Registrable {

    private int paradas;

    public TourGastronomico() {
    }

    /**
     * Constructor parametrizado para inicializar un nuevo tour gastronómico.
     *
     * @param codigo El código identificador del servicio.
     * @param nombre El nombre del tour gastronómico.
     * @param cantidad La cantidad de personas contempladas en el tour.
     * @param paradas El número de paradas gastronómicas incluidas.
     */
    public TourGastronomico(String codigo, String nombre, int cantidad, int paradas) {
        super(codigo, nombre, cantidad);
        this.paradas = paradas;
    }

    public int getParadas() {
        return paradas;
    }

    public void setParadas(int paradas) {
        this.paradas = paradas;
    }

    /**
     * Retorna el mensaje de confirmación para el registro de un tour
     * gastronómico.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Servicio turistico '" + getNombre() + "' registrado correctamente.";
    }

    /**
     * Genera un resumen detallado incluyendo el número de paradas.
     *
     * @return String con la ficha completa del tour gastronómico.
     */
    @Override
    public String resumen() {
        return "\n--- TOUR GASTRONOMICO ---\n"
                + "Nombre        : " + getNombre() + "\n"
                + "Codigo        : " + getCodigo() + "\n"
                + "Cantidad      : Tour para " + getCantidad() + " personas\n"
                + "No. de paradas: " + this.getParadas() + "\n";
    }

    /**
     * Retorna la representación del tour gastronómico en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato:
     * GASTRONOMICO;CODIGO;NOMBRE;CANTIDAD;PARADAS.
     */
    @Override
    public String lineaTexto() {
        return "GASTRONOMICO;" + getCodigo() + ";" + getNombre() + ";" + getCantidad() + ";" + this.getParadas();
    }

}
