package model;

public class ColaboradorExterno extends Persona implements Registrable {

    private String empresa;

    public ColaboradorExterno() {
    }

    public ColaboradorExterno(String nombre, String rut, int telefono, String empresa) {
        super(nombre, rut, telefono);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String registrar() {
        return ("Colaborador " + getNombre() + " registrado exitosamente.");
    }

    @Override
    public String resumen() {
        return ("\n-- COLABORADOR EXTERNO --\n"
                + "\nNombre  : " + getNombre()
                + "\nRut     : " + getRut()
                + "\nTelefono: " + getTelefono()
                + "\nEmpresa : " + empresa);
    }

}
