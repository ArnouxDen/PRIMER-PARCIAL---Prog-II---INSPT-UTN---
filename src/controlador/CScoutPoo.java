/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.MScoutsPoo;
import vista.VScoutsPoo;

/**
 *
 * COntrolador del programa. Insatncia y maneja la vista ( comunicacion con el usr) y el modelo(datos y lógica interna)
 */

public class CScoutPoo {

    VScoutsPoo vista = new VScoutsPoo();
    MScoutsPoo modelo = new MScoutsPoo();

    public CScoutPoo() {
    }

    public void run() {
        int rta;
        //vista.prueba();
        rta=vista.menuInicial();
        System.out.println("la rta fue : "+ rta);
       switch(rta){
        case 1:
            //inicio sesion
            ArrayList datosUsuario = vista.formInicioSesion();
            System.out.println(modelo.validarUsuarioyContraseña(datosUsuario)?"Bienvenidx" : "acceso denegadou");
           break;
        case 2:
            //nuevo usuario
             ArrayList datosNuevoUsuario = vista.formNuevoUsuario();
            for (Object dato: datosNuevoUsuario){
                System.out.println(dato);
             
            }
            break;
        case 3:
             System.out.println("op tres no registrada aun");
             break;
        default:
            break;
    }
        
        
       // modelo.prueba();

        
        
    }
/*
* METDOS GUARDAR Y ABRIR
*
 */
    public void guardar() {
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("FileMScoutsPoo.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(modelo);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "ERROR en guardar");
        }
    }

    public void abrir() {
        try {
            MScoutsPoo modeloGuardado = new MScoutsPoo();
            FileInputStream fileInputStream = new FileInputStream("FileMScoutsPoo.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            modeloGuardado = (MScoutsPoo) objectInputStream.readObject();
            modelo = new MScoutsPoo(modeloGuardado);

        } catch (Exception e) {
            //System.out.println(e.getMessage();
            System.out.println("\tBienvenidx al Sistema de gestion de actividades de Scouts Argentina \n\t ATENCION: No se ha encontrado un archivo previo" );
                    }

    }

    private void Switch(int rta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
