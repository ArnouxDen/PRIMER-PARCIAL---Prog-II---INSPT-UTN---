package modelo;

import java.io.Serializable;

/**
 * La clase sede presenta, segun requerimientos, nombre direccion y ubicacion. En
 * versiones iniciales del sistema se propuso registrar esta ultima en
 * coordenada geodesicas [int,int] pero dadas la propuesta de vista por consola,
 * resultaba mas claro utilizar direccion, provincia, y localidad.
 *
 */
public class Sede implements Serializable {

    private final int codigo;
    private String nombre;
    private String direccion;
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

    public String getDireccion() {
        return direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getLocalidad() {
        return localidad;
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
