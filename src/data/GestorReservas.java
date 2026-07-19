package data;

import java.util.ArrayList;
import model.Persona;
import model.RecursoAgencia;
import model.ReservaTuristica;
import model.ServicioTuristico;

/**
 * Clase encargada de gestionar el registro, almacenamiento y consulta de las
 * reservas turísticas. Coordina la relación entre guías, servicios, recursos y
 * clientes.
 */
public class GestorReservas {

    private ArrayList<ReservaTuristica> listaReservas;
    private GestorArchivos gestor;

    /**
     * Inicializa el gestor cargando las reservas desde el archivo persistente.
     *
     * @param gestor Instancia de {@link GestorArchivos} para la persistencia.
     */
    public GestorReservas(GestorArchivos gestor) {
        this.gestor = gestor;
        this.listaReservas = this.gestor.leerReservas();
    }

    /**
     * Registra una nueva reserva en el sistema y, opcionalmente, la guarda en
     * disco.
     *
     * @param nuevaReserva Objeto {@link ReservaTuristica} a añadir.
     * @param guardar Indicador para guardar los cambios en el archivo.
     */
    public void registrarReserva(ReservaTuristica nuevaReserva, boolean guardar) {
        listaReservas.add(nuevaReserva);
        if (guardar && gestor != null) {
            gestor.guardarReservas(listaReservas);
        }
    }

    /**
     * Elimina una reserva del sistema mediante su código identificador.
     *
     * @param codigoReserva Código único de la reserva.
     * @return true si fue eliminada correctamente, false en caso contrario.
     */
    public boolean eliminarReserva(String codigoReserva) {
        ReservaTuristica r = buscarReservaPorCodigo(codigoReserva);
        if (r != null) {
            listaReservas.remove(r);
            gestor.guardarReservas(listaReservas);
            return true;
        }
        return false;
    }

    /**
     * Obtiene una lista de reservas realizadas en un mes específico.
     *
     * @param mes El número del mes (1-12).
     * @return ArrayList de reservas encontradas.
     */
    public ArrayList<ReservaTuristica> obtenerReservasPorMes(int mes) {
        ArrayList<ReservaTuristica> filtradas = new ArrayList<>();
        for (ReservaTuristica r : listaReservas) {
            if (r.getMes() == mes) {
                filtradas.add(r);
            }
        }
        return filtradas;
    }

    public ArrayList<ReservaTuristica> getListaReservas() {
        return listaReservas;
    }

    /**
     * Busca una reserva específica según su código.
     *
     * @param codigoReserva El código de la reserva.
     * @return La reserva encontrada o null.
     */
    public ReservaTuristica buscarReservaPorCodigo(String codigoReserva) {
        for (ReservaTuristica r : listaReservas) {
            if (r.getCodigoReserva().equalsIgnoreCase(codigoReserva)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Retorna una lista con los códigos de servicios que ya están ocupados en
     * un mes.
     *
     * @param mes El mes a consultar.
     * @return Lista de códigos de servicios reservados.
     */
    public ArrayList<String> obtenerCodigosServiciosReservadosEnMes(int mes) {
        ArrayList<String> ocupados = new ArrayList<>();
        for (ReservaTuristica r : listaReservas) {
            if (r.getMes() == mes) {
                ocupados.add(r.getCodigosServicios());
            }
        }
        return ocupados;
    }

    /**
     * Retorna una lista con los RUTs de los guías ocupados en un mes.
     *
     * @param mes El mes a consultar.
     * @return Lista de RUTs de guías reservados.
     */
    public ArrayList<String> obtenerRutsGuiasReservadosEnMes(int mes) {
        ArrayList<String> ocupados = new ArrayList<>();
        for (ReservaTuristica r : listaReservas) {
            if (r.getMes() == mes) {
                ocupados.add(r.getRutGuia());
            }
        }
        return ocupados;
    }

    /**
     * Retorna una lista con los códigos de recursos ocupados en un mes.
     *
     * @param mes El mes a consultar.
     * @return Lista de códigos de recursos reservados.
     */
    public ArrayList<String> obtenerCodigosRecursosReservadosEnMes(int mes) {
        ArrayList<String> ocupados = new ArrayList<>();
        for (ReservaTuristica r : listaReservas) {
            if (r.getMes() == mes) {
                ocupados.add(r.getCodigoRecurso());
            }
        }
        return ocupados;
    }

    private String obtenerNombreMes(int mes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        if (mes >= 1 && mes <= 12) {
            return meses[mes - 1];
        } else {
            return "Mes Desconocido";
        }
    }

    /**
     * Genera un informe detallado de todas las reservas y sus componentes
     * asociados.
     *
     * @param gp Instancia del gestor de personas.
     * @param gr Instancia del gestor de recursos.
     * @param gs Instancia del gestor de servicios.
     * @return Un String con el informe completo.
     */
    public String generarInforme(GestorPersonas gp, GestorRecursos gr, GestorServicios gs) {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Informe de Reservas ---\n");

        if (listaReservas.isEmpty()) {
            return "No hay reservas registradas.";
        }

        for (ReservaTuristica r : listaReservas) {
            Persona p = gp.buscarPersonaPorRut(r.getRutGuia());
            ServicioTuristico s = gs.buscarServicioPorCodigo(r.getCodigosServicios());
            RecursoAgencia rec = gr.buscarRecursoPorCodigo(r.getCodigoRecurso());

            sb.append("----------------------------\n");
            sb.append("Código reserva: ").append(r.getCodigoReserva()).append("\n");
            sb.append("Mes: ").append(obtenerNombreMes(r.getMes())).append("\n");
            sb.append("Guía: ").append(p != null ? p.getNombre() : "No encontrado").append("\n");
            sb.append("Servicio: ").append(s != null ? s.getNombre() : "No encontrado").append("\n");
            sb.append("Recurso: ").append(rec != null ? rec.getNombre() : "No encontrado").append("\n");
            sb.append("Clientes: \n");
            for (String rut : r.getListaRutClientes()) {
                Persona cliente = gp.buscarPersonaPorRut(rut);
                String nombre = (cliente != null) ? cliente.getNombre() : "Desconocido";
                sb.append(" - ").append(nombre).append(" (").append(rut).append(")\n");
            }
        }

        return sb.toString();
    }

    /**
     * Elimina una reserva del sistema mediante su código.
     *
     * @param codigo Código de la reserva.
     * @return true si se eliminó con éxito.
     */
    public boolean eliminarReservaPorCodigo(String codigo) {
        for (int i = 0; i < listaReservas.size(); i++) {
            if (listaReservas.get(i).getCodigoReserva().equals(codigo)) {
                listaReservas.remove(i);
                return true;
            }
        }
        return false;
    }
}
