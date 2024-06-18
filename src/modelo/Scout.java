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
public class Scout implements Serializable {
    private int codigo;
    private String apodo;
    private String nombre;
    private String apellido;
    private String graduacion;
    
    private Sede sede;
    
    private Comunidad comunidad; //?
    private Grupo grupo;         //?
    

    public Scout(int codigo, String apodo, String nombre, String apellido, String graduacion) {
        this.codigo = codigo;
        this.apodo = apodo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.graduacion = graduacion;
    }

    public Scout(Scout s){
        this.codigo = s.codigo;
        this.apodo = s.apodo;
        this.nombre = s.nombre;
        this.apellido = s.apellido;
        this.graduacion = s.graduacion;
                
    }

    public Scout() {
    }
    
    
//GETERS
    
    public String getGraduacion() {
        return graduacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getApodo() {
        return apodo;
    }

    
    
    //SETERS
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

       public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGraduacion(String graduacion) {
        this.graduacion = graduacion;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    
                                      
    
}



