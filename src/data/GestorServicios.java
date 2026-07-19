package data;

import java.util.ArrayList;
import model.ServicioTuristico;

/**
 * Clase encargada de gestionar las operaciones relacionadas con los servicios
 * turísticos de la agencia. Coordina la lectura, almacenamiento, búsqueda y
 * reporte de objetos de tipo {@link ServicioTuristico}.
 */
public class GestorServicios {

    private ArrayList<ServicioTuristico> listaServicios;
    private GestorArchivos gestor;

    /**
     * Inicializa el gestor cargando la lista de servicios desde el archivo
     * persistente.
     *
     * @param gestor Instancia de {@link GestorArchivos} para la lectura y
     * escritura.
     */
    public GestorServicios(GestorArchivos gestor) {
        this.gestor = gestor;
        this.listaServicios = this.gestor.leerServicios();
    }

    /**
     * Agrega un nuevo servicio al sistema y actualiza el archivo de
     * almacenamiento.
     *
     * @param s El objeto {@link ServicioTuristico} (o subclase) a registrar.
     */
    public void agregarServicio(ServicioTuristico s) {
        listaServicios.add(s);
        gestor.guardarServicios(listaServicios);
    }

    /**
     * Retorna la lista completa de servicios turísticos registrados.
     *
     * @return ArrayList de objetos {@link ServicioTuristico}.
     */
    public ArrayList<ServicioTuristico> obtenerListaServicios() {
        return listaServicios;
    }

    /**
     * Busca un servicio específico en la lista mediante su código.
     *
     * @param codigo El identificador único del servicio.
     * @return El objeto {@link ServicioTuristico} encontrado, o null si no
     * existe.
     */
    public ServicioTuristico buscarServicioPorCodigo(String codigo) {
        for (ServicioTuristico s : listaServicios) {
            if (s.getCodigo().equalsIgnoreCase(codigo)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Elimina un servicio del sistema mediante su código.
     *
     * @param codigo El identificador único del servicio.
     * @return true si el servicio fue encontrado y eliminado, false en caso
     * contrario.
     */
    public boolean eliminarServicio(String codigo) {
        ServicioTuristico s = buscarServicioPorCodigo(codigo);
        if (s != null) {
            listaServicios.remove(s);
            gestor.guardarServicios(listaServicios);
            return true;
        }
        return false;
    }

    /**
     * Genera un reporte consolidado con los resúmenes de todos los servicios
     * registrados.
     *
     * @return String con el reporte completo.
     */
    public String generarReporteServicios() {
        StringBuilder sb = new StringBuilder();
        for (ServicioTuristico s : listaServicios) {
            sb.append(s.resumen()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Filtra la lista para obtener solo los servicios que no tienen reservas en
     * un mes dado.
     *
     * @param mes El mes a verificar.
     * @param gres Instancia de {@link GestorReservas} para consultar la
     * disponibilidad.
     * @return ArrayList de {@link ServicioTuristico} disponibles.
     */
    public ArrayList<ServicioTuristico> obtenerServiciosDisponibles(int mes, GestorReservas gres) {
        ArrayList<ServicioTuristico> disponibles = new ArrayList<>();
        ArrayList<String> ocupados = gres.obtenerCodigosServiciosReservadosEnMes(mes);

        for (ServicioTuristico s : listaServicios) {
            if (!ocupados.contains(s.getCodigo())) {
                disponibles.add(s);
            }
        }
        return disponibles;
    }

    /**
     * Busca un servicio turístico a partir de su nombre.
     *
     * @param nombre El nombre del servicio a buscar.
     * @return El objeto {@link ServicioTuristico} encontrado, o null si no
     * existe.
     */
    public ServicioTuristico buscarServicioPorNombre(String nombre) {
        for (ServicioTuristico s : listaServicios) {
            if (s.getNombre().equalsIgnoreCase(nombre)) {
                return s;
            }
        }
        return null;
    }
}
