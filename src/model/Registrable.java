package model;

/**
 * Interfaz que define el contrato para los objetos que deben ser registrados y
 * gestionados en el sistema de la agencia.
 */
public interface Registrable {

    /**
     * Genera un mensaje de confirmación al registrar el objeto.
     *
     * @return Un String con el mensaje de éxito correspondiente a la
     * implementación.
     */
    public String registrar();

    /**
     * Genera un resumen detallado con los datos del objeto.
     *
     * @return Un String con la ficha completa formateada.
     */
    public String resumen();

    /**
     * Genera una representación en formato de texto para el almacenamiento
     * persistente.
     *
     * @return Un String con los datos del objeto separados por puntos y coma
     * (formato CSV).
     */
    public String lineaTexto();

}
