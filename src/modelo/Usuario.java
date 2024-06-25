package modelo;

import java.io.Serializable;

/**
 * La clase usuario es una sub-clase de scout que presenta una contraseña para
 * acceder al sistema. en tanto Scout, el usr posee una graduacion determinada y
 * esta determinara el nivel de gestion al que puede acceder en el sistema.
 *
 */

public class Usuario extends Scout implements Serializable {

    private String contraseña;

    public Usuario(Scout s, String contraseña) {
        super(s);
        this.contraseña = contraseña;
    }

    public boolean validarContraseña(String pwd) {
        return this.contraseña.equals(pwd);
    }

    //SETTERS
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
