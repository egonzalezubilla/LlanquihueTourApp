Actividad Formativa 5 - Aplicando polimorfismo y colecciones genéricas

👤 Autor del proyecto

Nombre completo: Elías González Ubilla



Carrera: Analista Programador



Sede: Sede Online



📘 Descripción del proyecto

Este proyecto, denominado LlanquihueTourApp, es una aplicación desarrollada en Java diseñada para modelar la operación de una agencia de turismo. En esta etapa, el sistema ha evolucionado para implementar polimorfismo y el uso de colecciones genéricas (ArrayList), permitiendo gestionar y recorrer dinámicamente diversos tipos de servicios turísticos desde una colección única, aplicando la sobrescritura de métodos para diferenciar comportamientos.



🧱 Jerarquía de clases

ServicioTuristico (superclase): Define los atributos comunes como nombre y duración.



RutaGastronomica (subclase): Extiende la superclase y añade el atributo: número de paradas.



PaseoLacustre (subclase): Extiende la superclase y añade el atributo: tipo de embarcación.



ExcursionCultural (subclase): Extiende la superclase y añade el atributo: lugar histórico.



🧱 Estructura del proyecto

📁 src/



├── data/        # Contiene la clase GestorServicios, que gestiona la colección polimórfica de servicios turísticos.



├── model/       # Contiene la jerarquía de clases: ServicioTuristico, RutaGastronomica, PaseoLacustre y ExcursionCultural con el método mostrarInformacion() sobrescrito.



└── ui/          # Contiene la clase Main, el punto de entrada que recorre y muestra los resultados por consola.



⚙️ Cómo ejecutar el proyecto

Clona el repositorio: https://github.com/egonzalezubilla/LlanquihueTourApp.git



Abre el proyecto utilizando Apache NetBeans.



Localiza y ejecuta el archivo Main.java dentro del paquete ui.



Repositorio GitHub: https://github.com/egonzalezubilla/LlanquihueTourApp.git



Fecha de entrega: 02/07/2026



© Duoc UC | Escuela de Informática y Telecomunicaciones

