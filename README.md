Evaluacion Sumativa 3 - Aplicando polimorfismo y colecciones genéricas



👤 Autor del proyecto



Nombre completo: Elías González Ubilla



Carrera: Analista Programador



Sede: Sede Online



📘 Descripción del proyecto



Este proyecto, denominado LlanquihueTourApp, es una aplicación desarrollada en Java diseñada para modelar la operación de una agencia de turismo. En esta etapa, el sistema ha evolucionado para implementar una interfaz gráfica (JFrame), polimorfismo y el uso de colecciones genéricas (ArrayList), permitiendo gestionar y registrar dinámicamente diversos tipos de personal y recursos de la agencia, aplicando la sobrescritura de métodos para diferenciar comportamientos.



🧱 Jerarquía de clases



Registrable (Interfaz): Define el contrato para el registro.



Persona (Superclase): Clase base para GuiaTuristico y ColaboradorExterno.



RecursoAgencia (Superclase): Clase base para Vehiculo.



GuiaTuristico, ColaboradorExterno, Vehiculo (Subclases): Implementan la interfaz Registrable y sobrescriben métodos para comportamientos específicos.



🧱 Estructura del proyecto



📁 src/



├── data/        # Contiene la clase GestorEntidades, responsable de la lógica polimórfica y el almacenamiento en memoria de las colecciones.



├── model/       # Contiene la jerarquía de clases: Persona, GuiaTuristico, ColaboradorExterno, RecursoAgencia, Vehiculo y la interfaz Registrable.



└── ui/          # Contiene la clase Main, el punto de entrada principal que contiene el JFrame y la lógica de interacción con el usuario.



⚙️ Cómo ejecutar el proyecto



Abre el proyecto utilizando Apache NetBeans.



Localiza el paquete ui.



Haz clic derecho sobre la clase Main.java y selecciona "Run File" para iniciar la interfaz gráfica.



Repositorio GitHub: https://github.com/egonzalezubilla/LlanquihueTourApp.git



Fecha de entrega: 13/07/2026



© Duoc UC | Escuela de Informática y Telecomunicaciones

