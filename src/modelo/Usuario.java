/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Fd
 */
public class Usuario extends Scout implements Serializable{
    
       private String contraseña;

    public Usuario(Scout s, String contraseña) {
        super(s);
        this.contraseña = contraseña;
    }

   
    public boolean validarContraseña (String pwd){
       return this.contraseña.equals(pwd);
    }
    
    
    //SETTERS

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
