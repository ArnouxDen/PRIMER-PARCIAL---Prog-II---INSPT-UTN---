package modelo;

import java.io.Serializable;

/**
 * La clase grupo presenta código y denominación segun requerimientos
 *
 */

public class Grupo implements Serializable {

    private final int codigo;
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

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}
