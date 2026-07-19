package model;

/**
 * Representa un paseo lacustre dentro del sistema. Esta clase hereda los
 * atributos de ServicioTuristico y añade información sobre el puerto de
 * embarque.
 */
public class PaseoLacustre extends ServicioTuristico implements Registrable {

    private String puertoEmbarque;

    /**
     * Constructor parametrizado para inicializar un nuevo paseo lacustre.
     *
     * @param codigo El código identificador del servicio.
     * @param nombre El nombre del paseo lacustre.
     * @param cantidad La cantidad de personas contempladas en el tour.
     * @param puertoEmbarque El nombre del puerto de donde parte el paseo.
     */
    public PaseoLacustre(String codigo, String nombre, int cantidad, String puertoEmabrque) {
        super(codigo, nombre, cantidad);
        this.puertoEmbarque = puertoEmabrque;
    }

    public String getPuertoEmabrque() {
        return puertoEmbarque;
    }

    public void setPuertoEmabrque(String puertoEmabrque) {
        this.puertoEmbarque = puertoEmabrque;
    }

    /**
     * Retorna el mensaje de confirmación para el registro de un paseo lacustre.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Servicio turistico '" + getNombre() + "' registrado correctamente.";
    }

    /**
     * Genera un resumen detallado incluyendo el puerto de embarque.
     *
     * @return String con la ficha completa del paseo lacustre.
     */
    @Override
    public String resumen() {
        return "\n--- PASEO LACUSTRE ---\n"
                + "Nombre        : " + getNombre() + "\n"
                + "Codigo        : " + getCodigo() + "\n"
                + "Cantidad      : Tour para " + getCantidad() + " personas\n"
                + "Pto. Embarque : " + this.puertoEmbarque + "\n";
    }

    /**
     * Retorna la representación del paseo lacustre en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato:
     * LACUSTRE;CODIGO;NOMBRE;CANTIDAD;PTO_EMBARQUE.
     */
    @Override
    public String lineaTexto() {
        return "LACUSTRE;" + getCodigo() + ";" + getNombre() + ";" + getCantidad() + ";" + this.puertoEmbarque;
    }

}
