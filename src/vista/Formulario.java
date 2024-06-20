package vista;

import java.util.ArrayList;
import java.util.Scanner;

public class Formulario {
    private String encabezado;
    private String preguntas[];
    private ArrayList<String> respuestas = new ArrayList<>();

    public Formulario(String encabezado, String[] preguntas) {
        this.encabezado = encabezado;
        this.preguntas = preguntas;
    }

    public ArrayList<String> mostrar() {
        Scanner s = new Scanner(System.in);
        System.out.println(encabezado);

        for (String pregunta : preguntas) {
            System.out.println(pregunta);
            respuestas.add(s.nextLine());
        }

        return respuestas;
    }
}
