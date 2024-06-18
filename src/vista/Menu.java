package vista;

import java.util.Scanner;

public class Menu {
    private String encabezado;
    private String opciones[];

    public Menu(String encabezado, String[] opciones) {
        this.encabezado = encabezado;
        this.opciones = opciones;
    }

    public int mostrar() {
        Scanner s = new Scanner(System.in);
        System.out.println(encabezado);
        for (String op : opciones) {
            System.out.println(op);
        }

        int respuesta;
        do {
            System.out.print("Ingrese una opcion valida: ");
            respuesta = s.nextInt();
        } while (respuesta < 1 || respuesta > opciones.length);

        return respuesta;
    }
}
/*
package vista;

import java.util.Scanner;

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
*/