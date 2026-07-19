package model;

/**
 * Representa a un colaborador externo dentro del sistema. Esta clase hereda los
 * atributos de Persona y añade información sobre la empresa a la que pertenece.
 */
public class ColaboradorExterno extends Persona implements Registrable {

    private String empresa;

    public ColaboradorExterno() {
    }

    /**
     * Constructor parametrizado para inicializar un nuevo Colaborador Externo.
     *
     * @param rut El RUT del colaborador.
     * @param nombre El nombre completo del colaborador.
     * @param telefono El número de teléfono de contacto.
     * @param empresa El nombre de la empresa externa asociada.
     */
    public ColaboradorExterno(String rut, String nombre, int telefono, String empresa) {
        super(rut, nombre, telefono);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Retorna el mensaje de confirmación específico para el registro de un
     * colaborador.
     *
     * @return String con el mensaje de éxito.
     */
    @Override
    public String registrar() {
        return "Colaborador " + getNombre() + " registrado correctamente.";
    }

    /**
     * Genera un resumen detallado incluyendo la empresa del colaborador.
     *
     * @return String con la ficha completa del colaborador.
     */
    @Override
    public String resumen() {
        return "\n--- FICHA DEL COLABORADOR ---\n"
                + "Nombre  : " + getNombre() + "\n"
                + "RUT     : " + getRut() + "\n"
                + "Teléfono: " + getTelefono() + "\n"
                + "Empresa : " + this.empresa + "\n";
    }

    /**
     * Retorna la representación del colaborador en formato de texto para
     * almacenamiento.
     *
     * @return String con el formato: COLABORADOR;RUT;NOMBRE;TELEFONO;EMPRESA.
     */
    @Override
    public String lineaTexto() {
        return "COLABORADOR;" + getRut() + ";" + getNombre() + ";" + getTelefono() + ";" + this.empresa;
    }
}
