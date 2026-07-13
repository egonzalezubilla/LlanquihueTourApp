package data;

import java.util.ArrayList;
import model.Registrable;

public class GestorEntidades {

    private ArrayList<Registrable> listaEntidades = new ArrayList<>();

    public void agregarEntidad(Registrable entidad) {
        listaEntidades.add(entidad);
        entidad.registrar();
    }

    public String mostrarResumen() {
        String resumen = "--- Resumen de Entidades en el Sistema ---\n";

        for (Registrable e : listaEntidades) {
            resumen = resumen + e.resumen() + "\n";

            if (e instanceof model.Vehiculo) {
                resumen = resumen + "Este es un recurso de transporte de LLanquihueTour.\n";
            } else if (e instanceof model.GuiaTuristico) {
                resumen = resumen + "Este Guia turistico tiene certificación vigente.\n";
            } else if (e instanceof model.ColaboradorExterno) {
                resumen = resumen + "Colaborador con contrato de empresa externa.\n";
            }
            resumen = resumen + "-------------------------------------------\n";
        }
        return resumen;
    }
}
