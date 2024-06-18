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
    private Date fecha;
    private ArrayList<Participante> participantes = new ArrayList();
    
    //CONSTRUCTOR

    public Actividad(int codigo, String descripcion, Date fecha) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
      
 //GETTERS

    public int getCodigo() {
        return codigo;
    }
   public Date getFecha(){
       return fecha;
   }
    
    //SETTERS  

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }
   
   
    /***/ 
  public void agregarParticipante(Scout scout){
      Participante p=new Participante(scout);
      participantes.add(p);
     }
  
   public void agregarParticipante(Scout scout,String responsabilidad){
      Participante p=new Participante(scout);
      p.asignarResponsabilidad(responsabilidad);
      participantes.add(p);
     }
   
   public void agregarParticipante(Scout scout,String resp1,String resp2){
      Participante p=new Participante(scout);
      p.asignarResponsabilidad(resp1);
      p.asignarResponsabilidad(resp2);
      participantes.add(p);
     }
   
    public void agregarParticipante(Scout scout,String resp1,String resp2,String resp3){
      Participante p=new Participante(scout);
      p.asignarResponsabilidad(resp1);
      p.asignarResponsabilidad(resp2);
      p.asignarResponsabilidad(resp3);
      participantes.add(p);
     }
  
  public boolean esParticipante(Scout s){
      return participantes.contains((Participante)s); ///??smelly
  }
  
    
}
