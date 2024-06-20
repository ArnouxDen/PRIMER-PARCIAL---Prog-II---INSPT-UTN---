package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Modelo serializable de datos y logica interna. Es manejado desde controlador
 * y NO se comunica diractamente con vista
 *
 */
public class MScoutsPoo implements Serializable {

    private HashMap<String, Usuario> regUsuarios = new HashMap();
    private HashMap<String, Scout> regScouts = new HashMap();
    private HashMap<Integer, Sede> regSedes = new HashMap();
    private HashMap<Integer, Grupo> regGrupos = new HashMap();
    private HashMap<Integer, Comunidad> regComunidades = new HashMap();
    private ArrayList<Actividad> regActividades = new ArrayList();

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

    Calendar calendario = Calendar.getInstance();
    //Calendar calendarionew GregorianCalendar(); 

    /**/
 /*
    public void prueba() {
    }

 /*
 /**/
    //.............................................................................METODOS SCOUTS 
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

    public void modificacionScout(int cod, String apodo, String nombre, String apellido, String Graduacion) {
        Scout s = buscarScout(apodo);
        if (s.getCodigo() == cod) {
            s.setNombre(nombre);
            s.setApellido(apellido);
            s.setGraduacion(Graduacion);
        }
    }

    public Scout buscarScout(String apodo) {
        return this.regScouts.get(apodo);
    }

    public ArrayList listaScouts() {
        ArrayList<Scout> scouts = new ArrayList(regScouts.values());
        return scouts;
    }

    public ArrayList<Actividad> actividadesAnio(int anio) {
        ArrayList<Actividad> actividades = new ArrayList<>();

        for (Actividad actividad : regActividades) {
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(actividad.getFecha());
            if (calendario.get(Calendar.YEAR) == anio) {
                actividades.add(actividad);
            }
        }

        return actividades;
    }

//..............................................................................METODOS SEDES
    public void altaSede(String nombre, String direccion, String provincia, String localidad) {
        int codigo = regSedes.size() + 1;
        Sede s = new Sede(codigo, nombre, direccion, provincia, localidad);
        regSedes.put(codigo, s);

    }

    public void bajaSede(int codigo, String nombre) {
        Sede sede = regSedes.get(codigo);
        if (sede.getNombre().equals(nombre)) {
            sede.setNombre(sede.getNombre().concat("->SEDE ELIMINADA"));
        }

    } //OJO SCOUTS ASIGNADOS

    public void ModificacionSede(int codigo, String nombre, String direccion, String provincia, String localodad) {
        Sede sede = regSedes.get(codigo);
        sede.setNombre(nombre);
        sede.setDireccion(direccion);
        sede.setProvincia(provincia);
        sede.setLocalidad(localodad);

    }

    public Sede buscarSede(int cod) {
        return this.regSedes.get(cod);
    }

    public ArrayList ListaSedes() {
        ArrayList<Sede> sedes = new ArrayList(regSedes.values());
        return sedes;
    }

    //.............................................................................METODOS GRUPOS
    public void altaGrupo(String denominacion) {
        int codigo = regGrupos.size() + 1;
        Grupo g = new Grupo(codigo, denominacion);
        regGrupos.put(codigo, g);
    }

    public void bajaGrupo(int codigo, String denominacion) {
        Grupo g = regGrupos.get(codigo);
        if (g.getDenominacion().equals(denominacion)) {
            g.setDenominacion(g.getDenominacion().concat("->GRUPO SUSPENDIDO"));
        }

    }//OJO SCOUTS ASIGNADOS

    public void ModificacionGrupo(int codigo, String denominacion) {
        Grupo g = regGrupos.get(codigo);
        g.setDenominacion(denominacion);

    }

    private Grupo buscarGrupo(int cod) {
        return this.regGrupos.get(cod);
    }

    public ArrayList listaGrupos() {
        ArrayList<Grupo> grupos = new ArrayList(regGrupos.values());
        return grupos;
    }

//..............................................................................METODOS COMUNIDADES
    public void altaComunidad(String actPrincipal) {
        int numero = regComunidades.size() + 1;
        Comunidad c = new Comunidad(numero, actPrincipal);
        regComunidades.put(numero, c);
    }

    public void bajaComunidad(int numero, String act) {
        Comunidad c = regComunidades.get(numero);
        if (c.getActPrincipal().equals(act)) {
            c.setActPrincipal(c.getActPrincipal().concat("->COMUNIDAD SUSPENDIDA"));
        }
    }//OJO SCOUTS ASIGNADOS

    public void ModificacionComunidad(int numero, String actPrincipal) {
        Comunidad c = regComunidades.get(numero);
        c.setActPrincipal(actPrincipal);
    }

    public Comunidad buscarComunidad(int num) {
        return this.regComunidades.get(num);
    }

    public ArrayList listaComunidades() {
        ArrayList<Comunidad> comunidades = new ArrayList(regComunidades.values());
        return comunidades;
    }

//..............................................................................METODOS ACTIVIDADES
    public void altaActividad(String descripcion, int dia, int mes, int anio) {
        int codigo = regActividades.size() + 1;
        calendario.set(anio, mes, dia);
        Date fecha = calendario.getTime();
        Actividad a = new Actividad(codigo, descripcion, fecha);
        regActividades.add(a);
    }
//for(Actividad act : regActividades){}

    public void bajaActividad(int codigo) {
        for (Actividad act : regActividades) {
            if (act.getCodigo() == codigo) {
                act.setDescripcion("ACTIVIDAD SUPENDIDA");
            }
        }
    }

    public void ModificacionActividad(int codigo, String descripcion, int dia, int mes, int anio) {
        Iterator<Actividad> it = regActividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            if (act.getCodigo() == codigo) {
                act.setDescripcion(descripcion);
                calendario.set(anio, mes, dia);
                Date fecha = calendario.getTime();
                act.setFecha(fecha);
            }
        }
    }

    public void agrgegarParticipante(int codigo, Scout sc) {
        Iterator<Actividad> it = regActividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            if (act.getCodigo() == codigo) {
                act.agregarParticipante(sc);
            }
        }
    }

    public void agrgegarParticipante(int codigo, Scout sc, String resp) {
        Iterator<Actividad> it = regActividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            if (act.getCodigo() == codigo) {
                act.agregarParticipante(sc, resp);
            }
        }
    }

    public void agrgegarParticipante(int codigo, Scout sc, String resp1, String resp2) {
        Iterator<Actividad> it = regActividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            if (act.getCodigo() == codigo) {
                act.agregarParticipante(sc, resp1, resp2);
            }
        }
    }

    public void agrgegarParticipante(int codigo, Scout sc, String resp1, String resp2, String resp3) {
        Iterator<Actividad> it = regActividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            if (act.getCodigo() == codigo) {
                act.agregarParticipante(sc, resp1, resp2, resp3);
            }
        }
    }

    public Actividad buscarActividad(int cod) {
        Actividad act = null;
        for (Actividad actividad : regActividades) {
            if (actividad.getCodigo() == cod) {
                act = actividad;
            }
        }
        return act;
    }

    public ArrayList actividadesAñoPorScout(int anio, String apodo) {
        ArrayList<Actividad> actividades = new ArrayList();
        Scout sc = regScouts.get(apodo);
        Iterator<Actividad> it = regActividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            //calendario.clear();
            //calendario.setTime(act.getFecha());
            if ((act.getFecha().getYear() == anio) && (act.esParticipante(sc))) {
                actividades.add(act);
            }
        }
        return actividades;
    }

    //.............................................................................METODOS USUARIOS
    public void altaUsuario(String s, String pwd) {
        Scout sc = buscarScout(s);
        Usuario usr = new Usuario(sc, pwd);
        regUsuarios.put(sc.getApodo(), usr);

    }

    public void bajaUsuario(String apodo) {
        regUsuarios.remove(apodo);
    }

    public void modificacionUsuario(String s, String newPwd) {
        Scout sc = buscarScout(s);
        Usuario usr = regUsuarios.get(sc);
        usr.setContraseña(newPwd);
    }

    public boolean validarUsuarioyContraseña(ArrayList datos) {
        return regUsuarios.get(datos.get(0)).validarContraseña((String) datos.get(1));
    }
}
