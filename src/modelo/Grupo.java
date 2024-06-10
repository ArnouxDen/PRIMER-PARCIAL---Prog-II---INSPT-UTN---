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
public class Grupo implements Serializable {
    private int codigo;
    private String denominacion;
    
    //CONSTRUCTOR

    public Grupo(int codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }
    
    
    //GETTERS

    public int getCodigo() {
        return codigo;
    }
    
    
}
