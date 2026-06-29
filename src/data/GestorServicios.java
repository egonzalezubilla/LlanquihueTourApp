package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;

public class GestorServicios {

    public static void mostrarServicios() {

        RutaGastronomica r1 = new RutaGastronomica("Ruta del pinon", 4, 3);
        RutaGastronomica r2 = new RutaGastronomica("Sabores del Sur", 3, 2);

        PaseoLacustre p1 = new PaseoLacustre("Lago Llanquihue", 1, "Catamaran");
        PaseoLacustre p2 = new PaseoLacustre("Rio Pucon", 2, "Bote");

        ExcursionCultural e1 = new ExcursionCultural("Buscando la Guerra de Arauco", 2, "Fuerte espanol");
        ExcursionCultural e2 = new ExcursionCultural("Tour Historico Puerto Varas", 3, "Centro Ciudad");

        System.out.println("---- MOSTRANDO LOS SERVICIOS DISPONIBLES ----\n");
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(e1);
        System.out.println(e2);

    }

}
