package model;

import java.util.ArrayList;

public class ReservaTuristica {

    private String codigoReserva;
    private int mes;
    private String rutGuia;
    private String codigoRecurso;
    private String codigoServicios;
    private ArrayList<String> listaRutClientes;

    public ReservaTuristica() {
        this.listaRutClientes = new ArrayList<>();
    }

    public ReservaTuristica(String codigoReserva, int mes, String rutGuia, String codigoRecurso, String codigosServicios, ArrayList<String> listaRutClientes) {
        this.codigoReserva = codigoReserva;
        this.mes = mes;
        this.rutGuia = rutGuia;
        this.codigoRecurso = codigoRecurso;
        this.codigoServicios = codigosServicios;
        this.listaRutClientes = (listaRutClientes != null) ? listaRutClientes : new ArrayList<>();
    }

    @Override
    public String toString() {
        return "\n--- INFORMACION DE RESERVA ---\n"
                + "\n | Reserva  : " + codigoReserva
                + "\n | Mes      : " + mes
                + "\n | Guía     : " + rutGuia
                + "\n | Vehículo : " + codigoRecurso
                + "\n | Servicios: " + codigoServicios
                + "\n | Clientes : " + listaRutClientes.size();
    }

    public void agregarCliente(String rutCliente) {
        if (this.listaRutClientes == null) {
            this.listaRutClientes = new ArrayList<>();
        }
        this.listaRutClientes.add(rutCliente);
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public String getRutGuia() {
        return rutGuia;
    }

    public void setRutGuia(String rutGuia) {
        this.rutGuia = rutGuia;
    }

    public String getCodigoRecurso() {
        return codigoRecurso;
    }

    public void setCodigoRecurso(String codigoRecurso) {
        this.codigoRecurso = codigoRecurso;
    }

    public String getCodigosServicios() {
        return codigoServicios;
    }

    public void setCodigosServicios(String codigosServicios) {
        this.codigoServicios = codigosServicios;
    }

    public ArrayList<String> getListaRutClientes() {
        return listaRutClientes;
    }

    public void setListaRutClientes(ArrayList<String> listaRutClientes) {
        this.listaRutClientes = listaRutClientes;
    }

}
