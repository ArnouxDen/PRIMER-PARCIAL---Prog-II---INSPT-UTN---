package modelo;

import java.io.Serializable;

public class Usuario extends Scout implements Serializable{
    
       private String contraseña;

    public Usuario(Scout s, String contraseña) {
        super(s);
        this.contraseña = contraseña;
    }

   
    public boolean validarContraseña (String pwd){
       return this.contraseña.equals(pwd);
    }
    
    //SETTERS

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
