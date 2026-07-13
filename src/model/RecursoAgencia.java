package model;

public class RecursoAgencia {

    private String nombre;
    private String codigo;
    private String disponible;

    public RecursoAgencia() {
    }

    public RecursoAgencia(String nombre, String codigo, String disponible) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }


}
