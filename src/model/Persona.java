package model;

/**
 * Clase base que representa a una persona en el sistema. Implementa la interfaz
 * {@link Registrable} para gestionar operaciones de registro y visualización de
 * datos.
 * De esta superclase heredan las clases Cliente, ColaboradorExterno y GuiaTuristico.
 */
public class Persona implements Registrable {

    private String rut;
    private String nombre;
    private int telefono;

    public Persona() {
    }

    /**
     * Constructor parametrizado para inicializar una nueva Persona.
     *
     * @param rut El RUT de la persona.
     * @param nombre El nombre completo de la persona.
     * @param telefono El número de teléfono de contacto.
     */
    public Persona(String rut, String nombre, int telefono) {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    /**
     * Genera un mensaje de confirmación de registro.
     *
     * @return String con el mensaje de éxito para la interfaz de usuario.
     */
    @Override
    public String registrar() {
        return "Persona " + getNombre() + " registrada.";
    }

    /**
     * Retorna un resumen detallado con los datos de la persona.
     *
     * @return String formateado para visualización en consola o diálogos.
     */
    @Override
    public String resumen() {
        return "\n--- FICHA DE PERSONA ---\n"
                + "Nombre  : " + getNombre() + "\n"
                + "RUT     : " + getRut() + "\n"
                + "Teléfono: " + getTelefono() + "\n";
    }

    /**
     * Genera una representación en formato de texto plano para persistencia.
     *
     * @return String con formato CSV para el guardado en archivos.
     */
    @Override
    public String lineaTexto() {
        return "PERSONA;" + getRut() + ";" + getNombre() + ";" + getTelefono();
    }

}
