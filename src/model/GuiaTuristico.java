package model;

public class GuiaTuristico extends Persona implements Registrable {

    private String certificado;

    public GuiaTuristico() {
    }

    public GuiaTuristico(String nombre, String rut, int telefono, String certificado) {
        super(nombre, rut, telefono);
        this.certificado = certificado;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    @Override
    public String registrar() {
        return ("Guia turistico " + getNombre() + " registrado exitosamente.");
    }

    @Override
    public String resumen() {
        return ("\n-- GUIA TURISTICO --\n"
                + "\nNombre     : " + getNombre()
                + "\nRut        : " + getRut()
                + "\nTelefono   : " + getTelefono()
                + "\nCertificado: " + certificado);
    }

}
