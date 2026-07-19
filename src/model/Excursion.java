package model;

/**
 * Representa una excursión cultural dentro del sistema. Esta clase hereda los
 * atributos de ServicioTuristico y añade información sobre la distancia del
 * recorrido.
 */
public class Excursion extends ServicioTuristico implements Registrable {

    private int kilometros;

    public Excursion() {
    }

    /**
     * Constructor parametrizado para inicializar una nueva excursión.
     *
     * @param codigo El código identificador del servicio.
     * @param nombre El nombre de la excursión.
     * @param cantidad La cantidad de personas contempladas en la excursión.
     * @param kilometros Los kilómetros totales del recorrido.
     */
    public Excursion(String codigo, String nombre, int cantidad, int kilometros) {
        super(codigo, nombre, cantidad);
        this.kilometros = kilometros;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    /**
     * Retorna el mensaje de confirmación para el registro de una excursión.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Servicio turistico '" + getNombre() + "' registrado correctamente.";
    }

    /**
     * Genera un resumen detallado incluyendo los kilómetros de la excursión.
     *
     * @return String con la ficha completa de la excursión.
     */
    @Override
    public String resumen() {
        return "\n--- EXCURSION CULTURAL ---\n"
                + "Nombre           : " + getNombre() + "\n"
                + "Codigo           : " + getCodigo() + "\n"
                + "Cantidad         : Tour para " + getCantidad() + " personas\n"
                + "Kms. de recorrido: " + getKilometros() + " kms.\n";
    }

    /**
     * Retorna la representación de la excursión en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato:
     * EXCURSION;CODIGO;NOMBRE;CANTIDAD;KILOMETROS.
     */
    @Override
    public String lineaTexto() {
        return "EXCURSION;" + getCodigo() + ";" + getNombre() + ";" + getCantidad() + ";" + this.getKilometros();
    }

}
