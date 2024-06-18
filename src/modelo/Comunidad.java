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
public class Comunidad implements Serializable {
    private int numero;
    private String actPrincipal;
 
   //CONSTRUCTOR

    public Comunidad(int numero, String actPrincipal) {
        this.numero = numero;
        this.actPrincipal = actPrincipal;
    }
    
    
    
    //GETTERS

    public int getNumero() {
        return numero;
    }

    public String getActPrincipal() {
        return actPrincipal;
    }
    
    
    //SETTERS
    public void setActPrincipal(String actPrincipal) {
        this.actPrincipal = actPrincipal;
    }
    
    
}
