package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Actividad implements Serializable {
    private int codigo;
    private String descripcion;
    private Date fecha;
    private ArrayList<Participante> participantes = new ArrayList<>();
    private SimpleDateFormat fechaConFormato= new SimpleDateFormat("dd-MM-yyyy");

    // Constructor
    public Actividad(int codigo, String descripcion, Date fecha) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }

    public Date getFecha() {
        return fecha;
    }

      public String getFechaConFormato(){
        return fechaConFormato.format(fecha);
       }
      
    public String getDescripcion() {
        return descripcion;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setParticipantes(ArrayList<Participante> participantes) {
        this.participantes = participantes;
    }

    // Métodos para agregar participantes
    public void agregarParticipante(Scout scout) {
        Participante p = new Participante(scout);
        participantes.add(p);
    }

    public void agregarParticipante(Scout scout, String responsabilidad) {
        Participante p = new Participante(scout);
        p.asignarResponsabilidad(responsabilidad);
        participantes.add(p);
    }

    public void agregarParticipante(Scout scout, String resp1, String resp2) {
        Participante p = new Participante(scout);
        p.asignarResponsabilidad(resp1);
        p.asignarResponsabilidad(resp2);
        participantes.add(p);
    }

    public void agregarParticipante(Scout scout, String resp1, String resp2, String resp3) {
        Participante p = new Participante(scout);
        p.asignarResponsabilidad(resp1);
        p.asignarResponsabilidad(resp2);
        p.asignarResponsabilidad(resp3);
        participantes.add(p);
    }

    public boolean esParticipante(Scout s) {
        return participantes.contains((Participante) s); // ??smelly
    }
}
