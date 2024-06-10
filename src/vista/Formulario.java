/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *recibe texto encabezado y un array con preguntas que muestra por consola, 
 *devuelve un ArrayList con las respuestas (se maneja desde vScoutsPoo)
 * 
 */
public class Formulario {
    private String encabezado;
    private String preguntas[];
    private ArrayList<String> respuestas= new ArrayList();
    
    //Contructor

    public Formulario(String encabezado, String[] preguntas) {
        this.encabezado = encabezado;
        this.preguntas = preguntas;
    }
    
    
    
    public ArrayList mostrar(){
        Scanner s= new Scanner(System.in);
        System.out.println(encabezado);
        
        for (String pregunta:preguntas){
            System.out.println(pregunta);
            respuestas.add(s.nextLine());
        }
                
        return respuestas;
    }
    
}
