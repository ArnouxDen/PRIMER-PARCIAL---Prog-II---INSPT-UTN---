package modelo;

import java.io.Serializable;
/**
 * La clase scout es el la pieza central del sistema.
 * Presentan, segun requerimientos codigo, apodo, nombre, apellido y graduacion 
 * -Castor,Lobato y Lobezna, Scout, Caminante, Rover o Educador/a-
 * Tambien tienen, por conveniencia funcional del sistema e interpretación de los requerimientos, un grupo, una sede y una comunidad
 * si bien estas se instancian de forma independiente.
 * 
 * 
 */

public class Scout implements Serializable {

    private int codigo;
    private String apodo;
    private String nombre;
    private String apellido;
    private String graduacion;
    private Grupo grupo; 
    private Sede sede;
    private Comunidad comunidad; 
    

    public Scout(int codigo, String apodo, String nombre, String apellido, String graduacion) {
        this.codigo = codigo;
        this.apodo = apodo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.graduacion = graduacion;
    }

    public Scout(int codigo, String apodo, String nombre, String apellido, String graduacion, Grupo grupo, Sede sede, Comunidad comunidad) {
        this.codigo = codigo;
        this.apodo = apodo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.graduacion = graduacion;
        this.grupo = grupo;
        this.sede = sede;
        this.comunidad = comunidad;
    }

    public Scout(Scout s) {
        this.codigo = s.codigo;
        this.apodo = s.apodo;
        this.nombre = s.nombre;
        this.apellido = s.apellido;
        this.graduacion = s.graduacion;
        this.grupo = s.grupo;
        this.sede = s.sede;
        this.comunidad = s.comunidad;
    }

    public Scout() {
    }

    // Getters
    public String getGraduacion() {
        return graduacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getApodo() {
        return apodo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Sede getSede() {
        return sede;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    // Setters
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
