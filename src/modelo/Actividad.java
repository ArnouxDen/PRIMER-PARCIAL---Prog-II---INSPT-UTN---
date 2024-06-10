/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Fd
 */
public class Actividad implements Serializable{
    private int codigo;
    private String descripcion;
    private Calendar fecha;
    private ArrayList<Participante> participantes = new ArrayList();
    
    //CONSTRUCTOR

    public Actividad(int codigo, String descripcion, Calendar fecha) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
        
 //GETTERS

    public int getCodigo() {
        return codigo;
    }
  
    
    /***/ 
  public void agregarParticipante(Scout scout){
      Participante p=new Participante(scout);
      participantes.add(p);
      
  }
    
    
}
