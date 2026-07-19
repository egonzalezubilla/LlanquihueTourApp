package data;

import java.util.ArrayList;
import model.RecursoAgencia;

/**
 * Clase encargada de gestionar las operaciones relacionadas con los recursos de
 * la agencia. Coordina la lectura, almacenamiento, búsqueda y reporte de
 * objetos de tipo {@link RecursoAgencia}.
 */
public class GestorRecursos {

    private ArrayList<RecursoAgencia> listaRecursos;
    private GestorArchivos gestor;

    /**
     * Inicializa el gestor cargando la lista de recursos desde el archivo
     * persistente.
     *
     * @param gestor Instancia de {@link GestorArchivos} para la lectura y
     * escritura.
     */
    public GestorRecursos(GestorArchivos gestor) {
        this.gestor = gestor;
        this.listaRecursos = this.gestor.leerRecursos();
    }

    /**
     * Agrega un nuevo recurso al sistema y actualiza el archivo de
     * almacenamiento.
     *
     * @param recurso El objeto {@link RecursoAgencia} (o subclase) a registrar.
     */
    public void agregarRecurso(RecursoAgencia recurso) {
        listaRecursos.add(recurso);
        gestor.guardarRecursos(listaRecursos);
    }

    /**
     * Retorna la lista completa de recursos registrados.
     *
     * @return ArrayList de objetos {@link RecursoAgencia}.
     */
    public ArrayList<RecursoAgencia> obtenerListaRecursos() {
        return listaRecursos;
    }

    /**
     * Busca un recurso específico en la lista mediante su código.
     *
     * @param codigo El identificador único del recurso.
     * @return El objeto {@link RecursoAgencia} encontrado, o null si no existe.
     */
    public RecursoAgencia buscarRecursoPorCodigo(String codigo) {
        for (RecursoAgencia r : listaRecursos) {
            if (r.getCodigo().equalsIgnoreCase(codigo)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Elimina un recurso del sistema mediante su código.
     *
     * @param codigo El identificador único del recurso.
     * @return true si el recurso fue encontrado y eliminado, false en caso
     * contrario.
     */
    public boolean eliminarRecurso(String codigo) {
        RecursoAgencia r = buscarRecursoPorCodigo(codigo);
        if (r != null) {
            listaRecursos.remove(r);
            gestor.guardarRecursos(listaRecursos);
            return true;
        }
        return false;
    }

    /**
     * Genera un reporte consolidado con los resúmenes de todos los recursos
     * registrados.
     *
     * @return String con el reporte completo.
     */
    public String generarReporteRecursos() {
        StringBuilder sb = new StringBuilder();
        for (RecursoAgencia r : listaRecursos) {
            sb.append(r.resumen()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Filtra la lista para obtener solo los recursos que no están reservados en
     * un mes dado.
     *
     * @param mes El mes a verificar.
     * @param gres Instancia de {@link GestorReservas} para consultar la
     * disponibilidad.
     * @return ArrayList de {@link RecursoAgencia} disponibles.
     */
    public ArrayList<RecursoAgencia> obtenerRecursosDisponibles(int mes, GestorReservas gres) {
        ArrayList<RecursoAgencia> disponibles = new ArrayList<>();
        ArrayList<String> ocupados = gres.obtenerCodigosRecursosReservadosEnMes(mes);

        for (RecursoAgencia r : listaRecursos) {
            if (!ocupados.contains(r.getCodigo())) {
                disponibles.add(r);
            }
        }
        return disponibles;
    }

    /**
     * Busca el código de un recurso a partir de su nombre.
     *
     * @param nombre El nombre del recurso a buscar.
     * @return El código del recurso encontrado, o null si no se encuentra.
     */
    public String obtenerCodigoRecursoPorNombre(String nombre) {
        for (RecursoAgencia r : listaRecursos) {
            if (r.getNombre().equalsIgnoreCase(nombre)) {
                return r.getCodigo();
            }
        }
        return null;
    }
}
