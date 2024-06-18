package vista;

import java.util.ArrayList;

public class Tabla extends Formulario {
    public Tabla(String encabezado, String[] preguntas) {
        super(encabezado, preguntas);
    }

    public void mostrarTablaScout() {
        // Muestra la tabla con los encabezados y espacios en blanco para los datos
        System.out.println("\nACTIVIDADES - 2024");
        System.out.println("FECHA | CODIGO(DE ACTIVIDAD) | DESCRIPCION(DE LA ACTIVIDAD) | ASISTENCIA(PRESENTE O AUSENTE)");

        // Imprime una fila de espacios en blanco para representar una tabla vacía por ahora
        System.out.println("      |                       |                             |                              ");
    }
}



