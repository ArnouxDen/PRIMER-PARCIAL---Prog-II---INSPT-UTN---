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
    private String provincia;
    private String localidad;
    
    //constructor

    public Sede(int codigo, String nombre, String direccion, String provincia, String localidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.provincia = provincia;
        this.localidad = localidad;
    }
    
   
    
    //geters

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
    
    
}
