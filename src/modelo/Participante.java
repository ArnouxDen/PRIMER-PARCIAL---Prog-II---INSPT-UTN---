package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La clase participantes es una sub-clase de Scout que presenta tambien
 * resposabilidades y asistencia. Se instancian en una actividad determinada
 *
 */

public class Participante extends Scout implements Serializable {

    private String asistencia;
    private ArrayList<String> responsabilidades = new ArrayList();
    private String observaciones = null;

    public Participante(Scout s) {
        super(s);
        this.asistencia = new String("Pendiente");
    }

//GETTERS
    public String getAsistencia() {
        return asistencia;
    }

    public ArrayList<String> getResponsabilidades() {
        return responsabilidades;
    }

    public String getDevolucion() {
        return observaciones;
    }

//SETTERS
    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }

    public void setResponsabilidades(ArrayList<String> responsabilidades) {
        this.responsabilidades = responsabilidades;
    }

    public void asignarResponsabilidad(String responsabilidad) {
        responsabilidades.add(responsabilidad);
    }

    public void setDevolucion(String devolucion) {
        this.observaciones = devolucion;
    }

    public Scout getScout() {
        return this;
    }
}
