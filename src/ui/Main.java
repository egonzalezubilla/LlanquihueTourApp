package ui;

import data.GestorServicios;
import java.util.ArrayList;
import model.ServicioTuristico;

public class Main {

    public static void main(String[] args) {

        GestorServicios gestor = new GestorServicios();

        ArrayList<ServicioTuristico> lista = gestor.obtenerServicios();

        for (ServicioTuristico servicio : lista) {
            System.out.println("---- INFORMACION DEL SERVICIO TURISTICO ----");
            servicio.mostrarInformacion();
            System.out.println("");
        }

    }

}
