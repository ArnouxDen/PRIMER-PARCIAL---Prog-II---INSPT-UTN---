package vista;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Vista principal, maneja tablas, formularios y menues. Es manejada desde Controlador -- no se comunica diractamente con modelo 
 * 
 */
public class VScoutsPoo {

    public VScoutsPoo() {
    }
    
    
    
    public void prueba(){
        System.out.println("Aqui vista, reportanose");
           }
    
    public int menuInicial(){
        String encabezado = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t Bienvenidx! Ingrese la opcion deseada: \n\n";
        String[] opciones={"\t\t\t1: Iniciar Sesion","\t\t\t2: Crear nuevo usuario", "\t\t\t3: Salir"};
        
        Menu m = new Menu(encabezado, opciones);
        int rta = m.mostrar();
        return rta;
}
    
    public ArrayList formInicioSesion(){
        String encabezado = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t INICIO SESION \n\n";
        String[] preguntas={"\t\t\tApodo:", "\t\t\tContraseña:"};
         
        Formulario f = new Formulario(encabezado,preguntas);
        return f.mostrar();
        
        
    }
    public ArrayList formNuevoUsuario(){
        String encabezado = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t  NUEVO USUARIO \n\n";
        String[] preguntas={"\tApodo:", "\tContraseña:", "\tDIreccion:", "\ttelefono: " , "\tnombre de la mascota:"};
         
        Formulario f = new Formulario(encabezado,preguntas);
        return f.mostrar();
        
        
    }
    
}
