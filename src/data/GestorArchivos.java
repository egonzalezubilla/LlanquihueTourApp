package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Cliente;
import model.ColaboradorExterno;
import model.Embarcacion;
import model.Excursion;
import model.GuiaTuristico;
import model.PaseoLacustre;
import model.Persona;
import model.RecursoAgencia;
import model.ReservaTuristica;
import model.ServicioTuristico;
import model.TourGastronomico;
import model.Vehiculo;

/**
 * Clase responsable de la persistencia de datos del sistema. Gestiona la
 * lectura y escritura de archivos de texto para personas, recursos, servicios y
 * reservas.
 */
public class GestorArchivos {

    private final String RUTA_PERSONAS = "src/resources/Personas.txt";

    /**
     * Guarda la lista de personas en el archivo correspondiente.
     *
     * @param lista Lista de objetos de tipo {@link Persona}.
     */
    public void guardarPersonas(ArrayList<Persona> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_PERSONAS))) {
            for (Persona p : lista) {
                writer.write(p.lineaTexto());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar persona: " + e.getMessage());
        }
    }

    /**
     * Lee y reconstruye la lista de personas desde el archivo de texto.
     *
     * @return Lista de objetos {@link Persona}.
     */
    public ArrayList<Persona> leerPersonas() {
        ArrayList<Persona> lista = new ArrayList<>();
        File archivo = new File(RUTA_PERSONAS);

        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");

                if (partes.length >= 5) {
                    String tipo = partes[0];

                    if (tipo.equalsIgnoreCase("CLIENTE")) {
                        try {
                            int telefono = Integer.parseInt(partes[3]);
                            int edad = Integer.parseInt(partes[4]);
                            lista.add(new Cliente(partes[1], partes[2], telefono, edad));
                        } catch (NumberFormatException e) {
                            System.err.println("error al convertir datos numericos de cliente " + partes[2]);
                        }
                    } else if (tipo.equalsIgnoreCase("GUIA")) {
                        try {
                            int telefono = Integer.parseInt(partes[3]);
                            lista.add(new GuiaTuristico(partes[1], partes[2], telefono, partes[4]));
                        } catch (NumberFormatException e) {
                            System.err.println("error al convertir datos numericos de Guia " + partes[2]);
                        }
                    } else if (tipo.equalsIgnoreCase("COLABORADOR")) {
                        try {
                            int telefono = Integer.parseInt(partes[3]);
                            lista.add(new ColaboradorExterno(partes[1], partes[2], telefono, partes[4]));
                        } catch (NumberFormatException e) {
                            System.err.println("error al convertir datos numericos de Colaborador " + partes[2]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer personas: " + e.getMessage());
        }
        return lista;
    }

    private final String RUTA_RECURSOS = "src/resources/Recursos.txt";

    /**
     * Guarda la lista de recursos de la agencia en el archivo correspondiente.
     *
     * @param lista Lista de objetos de tipo {@link RecursoAgencia}.
     */
    public void guardarRecursos(ArrayList<RecursoAgencia> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_RECURSOS))) {
            for (RecursoAgencia r : lista) {
                writer.write(r.lineaTexto());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar recursos: " + e.getMessage());
        }
    }

    /**
     * Lee y reconstruye la lista de recursos desde el archivo de texto.
     *
     * @return Lista de objetos {@link RecursoAgencia}.
     */
    public ArrayList<RecursoAgencia> leerRecursos() {
        ArrayList<RecursoAgencia> lista = new ArrayList<>();
        File archivo = new File(RUTA_RECURSOS);

        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 5) {
                    String tipo = partes[0];

                    if (tipo.equalsIgnoreCase("VEHICULO")) {
                        try {
                            boolean estado = Boolean.parseBoolean(partes[3]);
                            int kilometraje = Integer.parseInt(partes[4]);
                            lista.add(new Vehiculo(partes[1], partes[2], estado, kilometraje));
                        } catch (NumberFormatException e) {
                            System.err.println("Error al convertir datos numéricos del vehículo: " + partes[2]);
                        }
                    } else if (tipo.equalsIgnoreCase("EMBARCACION")) {
                        try {
                            boolean estado = Boolean.parseBoolean(partes[3]);
                            int capacidad = Integer.parseInt(partes[4]);
                            lista.add(new Embarcacion(partes[1], partes[2], estado, capacidad));
                        } catch (NumberFormatException e) {
                            System.err.println("Error al convertir datos numéricos del vehículo: " + partes[2]);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer recursos: " + e.getMessage());
        }

        return lista;
    }

    private final String RUTA_SERVICIOS = "src/resources/Servicios.txt";

    /**
     * Guarda la lista de servicios turísticos en el archivo correspondiente.
     *
     * @param lista Lista de objetos de tipo {@link ServicioTuristico}.
     */
    public void guardarServicios(ArrayList<ServicioTuristico> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_SERVICIOS))) {
            for (ServicioTuristico s : lista) {
                writer.write(s.lineaTexto());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar servicios: " + e.getMessage());
        }
    }

    /**
     * Lee y reconstruye la lista de servicios turísticos desde el archivo de
     * texto.
     *
     * @return Lista de objetos {@link ServicioTuristico}.
     */
    public ArrayList<ServicioTuristico> leerServicios() {
        ArrayList<ServicioTuristico> lista = new ArrayList<>();
        File archivo = new File(RUTA_SERVICIOS);

        if (!archivo.exists()) {
            return lista;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 5) {
                    String tipo = partes[0];

                    try {
                        if (tipo.equalsIgnoreCase("EXCURSION")) {
                            int cantidad = Integer.parseInt(partes[3]);
                            int kms = Integer.parseInt(partes[4]);
                            lista.add(new Excursion(partes[1], partes[2], cantidad, kms));

                        } else if (tipo.equalsIgnoreCase("LACUSTRE")) {
                            int cantidad = Integer.parseInt(partes[3]);
                            lista.add(new PaseoLacustre(partes[1], partes[2], cantidad, partes[4]));

                        } else if (tipo.equalsIgnoreCase("GASTRONOMICO")) {
                            int cantidad = Integer.parseInt(partes[3]);
                            int paradas = Integer.parseInt(partes[4]);
                            lista.add(new TourGastronomico(partes[1], partes[2], cantidad, paradas));
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error de formato numérico en servicio: " + partes[1]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer servicios: " + e.getMessage());
        }
        return lista;
    }

    private final String RUTA_RESERVAS = "src/resources/Reservas.txt";
    private final String RUTA_DETALLE_RESERVAS = "src/resources/Detalle_Reservas.txt";

    /**
     * Persiste la lista de reservas en dos archivos: uno para la cabecera y
     * otro para el detalle de clientes.
     *
     * @param lista Lista de objetos {@link ReservaTuristica}.
     */
    public void guardarReservas(ArrayList<ReservaTuristica> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_RESERVAS))) {
            for (ReservaTuristica r : lista) {
                writer.write(r.getCodigoReserva() + ";" + r.getMes() + ";" + r.getRutGuia() + ";"
                        + r.getCodigoRecurso() + ";" + r.getCodigosServicios());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar reservas (cabecera): " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_DETALLE_RESERVAS))) {
            for (ReservaTuristica r : lista) {
                if (r.getListaRutClientes() != null && !r.getListaRutClientes().isEmpty()) {
                    for (String rut : r.getListaRutClientes()) {
                        writer.write(r.getCodigoReserva() + ";" + rut);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al guardar detalle de reservas: " + e.getMessage());
        }
    }

    /**
     * Lee y reconstruye la lista de reservas turísticas, uniendo los datos de
     * cabecera y detalle.
     *
     * @return Lista completa de objetos {@link ReservaTuristica}.
     */
    public ArrayList<ReservaTuristica> leerReservas() {
        ArrayList<ReservaTuristica> listaReservas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_RESERVAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 5) {
                    ReservaTuristica r = new ReservaTuristica(
                            partes[0],
                            Integer.parseInt(partes[1]),
                            partes[2],
                            partes[3],
                            partes[4],
                            new ArrayList<>()
                    );
                    listaReservas.add(r);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo de reservas: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_DETALLE_RESERVAS))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String codigoReserva = partes[0];
                    String rutCliente = partes[1];

                    for (ReservaTuristica res : listaReservas) {
                        if (res.getCodigoReserva().equals(codigoReserva)) {
                            res.agregarCliente(rutCliente);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo de detalles: " + e.getMessage());
        }

        return listaReservas;
    }
}
