package model;

/**
 * Representa a un cliente dentro del sistema, hereda los atributos de Persona
 * con atributos específicos.
 */
public class Cliente extends Persona implements Registrable {

    private int edad;

    public Cliente() {
    }

    /**
     * Constructor parametrizado para inicializar un nuevo Cliente.
     *
     * @param rut El RUT del cliente.
     * @param nombre El nombre completo del cliente.
     * @param telefono El número de teléfono de contacto.
     * @param edad La edad actual del cliente.
     */
    public Cliente(String rut, String nombre, int telefono, int edad) {
        super(rut, nombre, telefono);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Retorna el mensaje de confirmación específico para el registro de un
     * cliente.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Cliente " + getNombre() + " registrado correctamente.";
    }

    /**
     * Genera un resumen detallado incluyendo la edad del cliente.
     *
     * @return String con la ficha completa del cliente.
     */
    @Override
    public String resumen() {
        return "\n--- FICHA DEL CLIENTE ---\n"
                + "Nombre  : " + getNombre() + "\n"
                + "RUT     : " + getRut() + "\n"
                + "Teléfono: " + getTelefono() + "\n"
                + "Edad    : " + this.edad + " años\n";
    }

    /**
     * Retorna la representación del cliente en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato: CLIENTE;RUT;NOMBRE;TELEFONO;EDAD.
     */
    @Override
    public String lineaTexto() {
        return "CLIENTE;" + getRut() + ";" + getNombre() + ";" + getTelefono() + ";" + this.edad;
    }

}
