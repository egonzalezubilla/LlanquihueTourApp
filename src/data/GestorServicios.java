package data;

import java.util.ArrayList;
import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

public class GestorServicios {

    public ArrayList<ServicioTuristico> obtenerServicios() {

        ArrayList<ServicioTuristico> servicios = new ArrayList<>();

        servicios.add(new RutaGastronomica("Ruta del Vino", 4, 3));
        servicios.add(new PaseoLacustre("Vista al Volcan", 2, "Catamaran"));
        servicios.add(new ExcursionCultural("Museo Local", 3, "Centro Historico"));
        servicios.add(new RutaGastronomica("Tour de Quesos", 5, 2));
        servicios.add(new PaseoLacustre("Avistamiento de Aves", 3, "Bote a remo"));
        servicios.add(new ServicioTuristico("Spa Llanquihue", 3));
        servicios.add(new PaseoLacustre("Lago Llanquihue", 3, "Kayak"));
        servicios.add(new RutaGastronomica("Sabores del Sur", 6, 4));
        servicios.add(new PaseoLacustre("Travesia al atardecer", 2, "Lancha motorizada"));
        servicios.add(new ExcursionCultural("Tour de artesanias", 4, "Barrio artesanal"));
        servicios.add(new RutaGastronomica("Cata de cervezas", 3, 5));
        return servicios;
    }

}
