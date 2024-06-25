package modelo;

import java.io.Serializable;

/**
 *
 * La clase comunidad presenta numero y actividad prncipal segun requerimientos
 */
public class Comunidad implements Serializable {

    private final int numero;
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
