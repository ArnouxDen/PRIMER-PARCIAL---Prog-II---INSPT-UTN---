/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.Scanner;

/**
 *recibe texto encabezado y un array con opciones que muestra por consola, devuelve un int (se maneja desde vScoutsPoo)
 * 
 */
public class Menu {
    private String encabezado;
    private String opciones[];
    private int respuesta;
    
    

    public Menu(String encabezado, String[] opciones) {
        this.opciones = opciones;
        this.encabezado=encabezado;
    }
         
    public int mostrar(){
        Scanner s= new Scanner(System.in);
        System.out.println(encabezado);
        for (String op:opciones){
            System.out.println(op);
        }
        do{
        this.respuesta=Integer.parseInt(s.nextLine()); 
        } while (respuesta>opciones.length);
       
        //s.close();
        return respuesta;
        
    }
    
}
