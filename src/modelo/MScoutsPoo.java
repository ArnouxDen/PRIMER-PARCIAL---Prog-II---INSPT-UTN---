/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


/**
 * Modelo serializable de datos y logica interna. Es manejado dese controlador y
 * NO se comunica diractamente con vista
 *
 */
public class MScoutsPoo implements Serializable {

    private HashMap<String, Usuario> regUsuarios = new HashMap();
    private HashMap<String, Scout> regScouts = new HashMap();
    private HashMap<Integer, Sede> regSedes = new HashMap();
    private HashMap<Integer, Grupo> regGrupos = new HashMap();
    private HashMap<Integer, Comunidad> regComunidades = new HashMap();
    private HashMap<Integer, Actividad> regActividades = new HashMap();

    public MScoutsPoo() {
    }

    public MScoutsPoo(MScoutsPoo archivo) {
        this.regActividades = archivo.regActividades;
        this.regComunidades = archivo.regComunidades;
        this.regGrupos = archivo.regGrupos;
        this.regScouts = archivo.regScouts;
        this.regUsuarios = archivo.regUsuarios;
        this.regSedes = archivo.regSedes;
    }

    /**/
 /**/
    public void prueba() {
        System.out.println("aqui modelo, que tal?");
        Scout pepe = new Scout(101, "pepe", "jose", "gomez", "castor");
        Scout rojo = new Scout(101, "carlitos", "jose", "gomez", "lobzno");
        Scout azul = new Scout(101, "coso", "jose", "gomez", "rober");
        regScouts.put("Pepe", pepe);
        regScouts.put("carlitos", rojo);
        regScouts.put("coso", azul);

        System.out.println("veo un " + regScouts.get("Pepe").getGraduacion());
        System.out.println("veo un " + regScouts.get("carlitos").getGraduacion());
        System.out.println("veo un " + regScouts.get("coso").getGraduacion());

    }

    /**/
 /**/
 /* 
 private Auto buscarAuto (String Patente){
     Auto autoEncontrado=null;
     Iterator<auto> it =this.autos.iterator();
     while(it.hasNext() && autoEncontrado==null){
         Auto a = it.next();
         if(a.getPatente().equalsIgnoreCase(patente)){
             autoEncontrado = a;
         }
     }
     return autoEncontrado;
 } */
    //............................................................................BUEQUEDA
    private Scout buscarScout(String apodo) {
        return this.regScouts.get(apodo);
    }

    private Sede buscarSede(int cod) {
        return this.regSedes.get(cod);
    }

    private Grupo buscarGrupo(int cod) {
        return this.regGrupos.get(cod);
    }

    private Comunidad buscarComunidad(int num) {
        return this.regComunidades.get(num);
    }

    private Actividad buscarActividad(int cod) {              //ojo! mas de una acto por cod (dif fecha?)
        return regActividades.get(cod);
    }

    //.............................................................................abm scout  
    public void altaScout(String apodo, String nombre, String apellido, String graduacion) {
        int cod = regScouts.size() + 1;
        Scout scout = new Scout(cod, apodo, nombre, apellido, graduacion);
        regScouts.put(apodo, scout);
    }

    //BAJA SCOUT.. TRANSFORMA EL CODIGO EN CERO (0)
    public void bajaScout(int cod, String apodo) {
        Scout s = buscarScout(apodo);
        if (s.getCodigo() == cod) {
            s.setCodigo(0);
        }

    }

    public void modificacionScout() {
    }

//..............................................................................abm sede
    public void altaSede(int codigo, String nombre, String direccion, float ubicacion[]) {
        Sede s = new Sede(codigo, nombre, direccion, ubicacion);
        regSedes.put(codigo, s);

    }

    public void bajaSede() {
    } //OJO SCOUTS ASIGNADOS

    public void ModificacionSede() {
    }

    //.............................................................................abm grupo
    public void altaGrupo(int codigo, String denominacion) {
        Grupo g = new Grupo(codigo, denominacion);
        regGrupos.put(codigo, g);
    }

    public void bajaGrupo() {
    }//OJO SCOUTS ASIGNADOS

    public void ModificacionGrupo() {
    }

//..............................................................................abm comunidad
    public void altaComunidad(int numero, String actPrincipal) {
        Comunidad c = new Comunidad(numero, actPrincipal);
        regComunidades.put(numero, c);
    }

    public void bajaComunidad() {
    }//OJO SCOUTS ASIGNADOS

    public void ModificacionComunidad() {
    }

//..............................................................................abm actividad
    public void altaActividad(int codigo, String descripcion, Calendar fecha) {
        Actividad a = new Actividad(codigo, descripcion, fecha);
        regActividades.put(codigo, a);
    }

    public void bajaActividad() {
    }

    public void ModificacionActividad() {
    }

//validar usuario y contraseña, devolver graducacion(rama/auth)
    public boolean validarUsuarioyContraseña(ArrayList datos) {
        return false; //(?
    }

}
