Evaluación Final Transversal - LlanquihueTourApp

👤 Autor del proyecto

Nombre completo: Elías González Ubilla



Carrera: Analista Programador



Sede: Sede Online



📘 Descripción del proyecto

LlanquihueTourApp es un sistema de gestión integral diseñado para optimizar las operaciones de una agencia de turismo. Esta aplicación permite centralizar la administración de la agencia mediante el almacenamiento y gestión eficiente de Personas (clientes, guías y colaboradores), Recursos (vehículos y embarcaciones) y Servicios turísticos (excursiones, paseos lacustres y tours gastronómicos).



El núcleo funcional del proyecto radica en su capacidad para articular estos elementos en la creación y administración de reservas de servicios turísticos. La experiencia de usuario está diseñada bajo un entorno de interfaz gráfica intuitiva, organizada mediante pestañas dedicadas que facilitan la navegación y el control de cada área de la agencia.



🧱 Estructura y Jerarquía del Proyecto

El sistema está organizado para garantizar un diseño modular, escalable y mantenible. A continuación se detalla la organización de los paquetes y sus componentes:



data: Contiene los gestores encargados de la persistencia de datos (lectura/escritura en archivos) y la lógica de manipulación de colecciones.



Clases: GestorArchivos, GestorPersonas, GestorRecursos, GestorReservas, GestorServicios.



model: Define el dominio del problema mediante una robusta jerarquía de clases que implementan polimorfismo.



Clases: Persona, Cliente, GuiaTuristico, ColaboradorExterno, RecursoAgencia, Vehiculo, Embarcacion, ServicioTuristico, Excursion, PaseoLacustre, TourGastronomico, ReservaTuristica e interfaz Registrable.



ui: Contiene la capa de presentación que interactúa con el usuario.



Clases: Main.



util: Contiene clases de utilidad para el sistema.



Clases: Validador.



resources: Almacena los archivos de texto que actúan como base de datos persistente.



Archivos: Personas.txt, Recursos.txt, Servicios.txt, Reservas.txt, Detalle\_Reservas.txt.



⚙️ Cómo ejecutar el proyecto

Abre el proyecto en Apache NetBeans.



Navega hasta el paquete ui.



Haz clic derecho sobre la clase Main.java y selecciona "Run File" para desplegar la interfaz gráfica.



🔗 Repositorio

GitHub: https://github.com/egonzalezubilla/LlanquihueTourApp.git



Fecha de entrega: 19/07/2026



© Duoc UC | Escuela de Informática y Telecomunicaciones

