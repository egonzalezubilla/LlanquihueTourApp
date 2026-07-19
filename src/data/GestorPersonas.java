package data;

import java.util.ArrayList;
import model.GuiaTuristico;
import model.Persona;

/**
 * Clase encargada de gestionar las operaciones relacionadas con las personas
 * del sistema. Coordina la lectura, almacenamiento, búsqueda y reporte de
 * objetos de tipo {@link Persona}.
 */
public class GestorPersonas {

    private ArrayList<Persona> listaPersonas;
    private GestorArchivos gestorArchivos;

    /**
     * Inicializa el gestor cargando la lista de personas desde el archivo
     * persistente.
     *
     * @param gestor Instancia de {@link GestorArchivos} para la lectura y
     * escritura.
     */
    public GestorPersonas(GestorArchivos gestor) {
        this.gestorArchivos = gestor;
        this.listaPersonas = this.gestorArchivos.leerPersonas();
    }

    /**
     * Agrega una nueva persona al sistema y actualiza el archivo de
     * almacenamiento.
     *
     * @param persona El objeto {@link Persona} (o subclase) a registrar.
     */
    public void agregarPersona(Persona persona) {
        listaPersonas.add(persona);
        gestorArchivos.guardarPersonas(listaPersonas);
    }

    /**
     * Elimina a una persona del sistema mediante su RUT.
     *
     * @param rut El identificador único de la persona.
     * @return true si la persona fue encontrada y eliminada, false en caso
     * contrario.
     */
    public boolean eliminarPersona(String rut) {
        Persona persona = buscarPersonaPorRut(rut);
        if (persona != null) {
            listaPersonas.remove(persona);
            gestorArchivos.guardarPersonas(listaPersonas);
            return true;
        }
        return false;
    }

    /**
     * Retorna la lista completa de personas registradas.
     *
     * @return ArrayList de objetos {@link Persona}.
     */
    public ArrayList<Persona> obtenerListaPersonas() {
        return listaPersonas;
    }

    /**
     * Busca una persona específica en la lista mediante su RUT.
     *
     * @param rut El RUT a buscar.
     * @return El objeto {@link Persona} encontrado, o null si no existe.
     */
    public Persona buscarPersonaPorRut(String rut) {
        for (Persona p : listaPersonas) {
            if (p.getRut().equalsIgnoreCase(rut)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Genera un reporte consolidado con los resúmenes de todas las personas
     * registradas.
     *
     * @return String con el reporte completo.
     */
    public String generarReportePersonas() {
        StringBuilder sb = new StringBuilder();
        for (Persona p : listaPersonas) {
            sb.append(p.resumen()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Filtra la lista para obtener solo los guías turísticos que no tienen
     * reservas en un mes dado.
     *
     * @param mes El mes a verificar.
     * @param gres Instancia de {@link GestorReservas} para consultar la
     * disponibilidad.
     * @return ArrayList de {@link GuiaTuristico} disponibles.
     */
    public ArrayList<GuiaTuristico> obtenerGuiasDisponibles(int mes, GestorReservas gres) {
        ArrayList<GuiaTuristico> disponibles = new ArrayList<>();
        ArrayList<String> ocupados = gres.obtenerRutsGuiasReservadosEnMes(mes);

        for (Persona p : listaPersonas) {
            if (p instanceof GuiaTuristico) {
                GuiaTuristico g = (GuiaTuristico) p;
                if (!ocupados.contains(g.getRut())) {
                    disponibles.add(g);
                }
            }
        }
        return disponibles;
    }

    /**
     * Busca el RUT de un guía turístico a partir de su nombre.
     *
     * @param nombre El nombre del guía a buscar.
     * @return El RUT del guía encontrado, o null si no se encuentra.
     */
    public String obtenerRutGuiaPorNombre(String nombre) {
        for (Persona p : listaPersonas) {
            if (p instanceof GuiaTuristico && p.getNombre().equalsIgnoreCase(nombre)) {
                return p.getRut();
            }
        }
        return null;
    }

}
