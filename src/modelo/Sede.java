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
public class Sede implements Serializable {
    private int codigo;
    private String nombre;
    private String direccion;     //????
    private float ubicacion[];
    
    //constructor
    
    public Sede(int codigo, String nombre, String direccion, float[] ubicacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
    }
    
    //geters

    public int getCodigo() {
        return codigo;
    }
    
    
}
