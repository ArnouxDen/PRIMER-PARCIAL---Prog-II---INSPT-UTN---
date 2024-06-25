package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Modelo serializable de datos y logica interna. Es manejado desde controlador
 * y no se comunica diractamente con vista ni con el usuario. Almacena los
 * registros de usuarios,scouts,sedes,grupos,comunidades y actividades asi como
 * los principales metodos para modificarlos o acceder a sus valores
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
    
    ////////////////////////////////////////////////////////////////
    //METODOS SCOUTS 
    ///////////////////////////////////////////////////////////////

    /**
     * El metodo altaScout permite dar de alta un scout recibiendo los datos
     * solicitados por el contructor de la clase y generando automaticamente un
     * codigo segun el tamaño del registro para evitar duplicidades
     *
     * @param apodo
     * @param nombre
     * @param apellido
     * @param graduacion
     */
    public void altaScout(String apodo, String nombre, String apellido, String graduacion) {
        int cod = regScouts.size() + 1;
        Scout scout = new Scout(cod, apodo, nombre, apellido, graduacion);
        regScouts.put(apodo, scout);
    }

    /**
     * El metodo altaScout permite dar de alta un scout recibiendo los datos
     * solicitados por el contructor de la clase y generando automaticamente un
     * codigo segun el tamaño del registro para evitar duplicidades. El metodo
     * puede invocarse con firmas variadas registrando en el mismo llamado el
     * grupo, la sede y la comunidad.
     *
     * @param apodo
     * @param nombre
     * @param apellido
     * @param graduacion
     * @param codGrupo
     * @param codSede
     * @param numComunidad
     */
    public void altaScout(String apodo, String nombre, String apellido, String graduacion, int codGrupo, int codSede, int numComunidad) {
        int cod = regScouts.size() + 1;
        Grupo grupo = regGrupos.get(codGrupo);
        Sede sede = regSedes.get(codSede);
        Comunidad comunidad = regComunidades.get(numComunidad);
        Scout scout = new Scout(cod, apodo, nombre, apellido, graduacion, grupo, sede, comunidad);
        regScouts.put(apodo, scout);
    }

    /**
     * El Metodo bajaScout transforma el codigo de un Scout en cero. Un scout con
     * codigo cero no podra registrarse como participante en actividades
     *
     * @param cod
     * @param apodo
     */
    public void bajaScout(int cod, String apodo) {
        try {
            Scout s = buscarScout(apodo);
            if (s.getCodigo() == cod) {
                s.setCodigo(0);
            }
        } catch (Exception NullPointerException) {
            System.out.println("Apodo no registrado");
        }
    }

    /**
     * El metodo modificacionScout recibe los datos necesarios para actualizar
     * la informacion de un scout registrado que puede ser modificada segun
     * requerimientos, apodo, grupo y comunidad no pueden modificarse. por
     * requerimientos funcionales del sistema, el codigo del scout tampoco puede
     * modificarse por este metodo
     *
     * @param apodo
     * @param nombre
     * @param apellido
     * @param Graduacion
     * @param codSede
     */
    public void modificacionScout(String apodo, String nombre, String apellido, String Graduacion, int codSede) {
        Scout s = buscarScout(apodo);
        s.setNombre(nombre);
        s.setApellido(apellido);
        s.setGraduacion(Graduacion);
        s.setSede(regSedes.get(codSede));
    }

    /**
     * El metodo buscarScout devuelve un scout determinado por su apodo del
     * registro de scouts
     *
     * @param apodo
     * @return
     */
    public Scout buscarScout(String apodo) {
        Scout scout = this.regScouts.get(apodo);
        return scout;
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

    ////////////////////////////////////////////////////////////////
    //METODOS Sedes
    ///////////////////////////////////////////////////////////////.
    /**
     * El metodo altaSede permite dar de alta una sede recibiendo los datos
     * solicitados por el contructor de la clase y generando automaticamente un
     * codigo de sede segun el tamaño del registro de sedes para evitar
     * duplicidades.
     *
     * @param nombre
     * @param direccion
     * @param provincia
     * @param localidad
     */
    public void altaSede(String nombre, String direccion, String provincia, String localidad) {
        int codigo = regSedes.size() + 1;
        Sede s = new Sede(codigo, nombre, direccion, provincia, localidad);
        regSedes.put(codigo, s);
    }

    /**
     * El metodo bajaSede cambia el nombre de una sede a "SEDE ELIMINADA",
     * manteniendo el resto de los datos
     *
     * @param codigo
     * @param nombre
     */
    public void bajaSede(int codigo, String nombre) {
        try {
            Sede sede = regSedes.get(codigo);
            if (sede.getNombre().equals(nombre)) {
                sede.setNombre(sede.getNombre().concat("->SEDE ELIMINADA"));
            }
        } catch (Exception NullPointerException) {
            System.out.println("Sede no registrada");
        }
    } 

    /**
     * El metodo ModificacionSede recibe los datos para modificar o actualizar
     * los datos de una sede
     *
     * @param codigo
     * @param nombre
     * @param direccion
     * @param provincia
     * @param localodad
     */
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

    /**
     *
     * @return ArrayLit <Sede>
     */

    public ArrayList listaSedes() {
        ArrayList<Sede> sedes = new ArrayList(regSedes.values());
        return sedes;
    }

    ////////////////////////////////////////////////////////////////////
    //METODOS GRUPOS
    ////////////////////////////////////////////////////////////////////
    /**
     *
     * @param denominacion
     */
    public void altaGrupo(String denominacion) {
        int codigo = regGrupos.size() + 1;
        Grupo g = new Grupo(codigo, denominacion);
        regGrupos.put(codigo, g);
    }

    /**
     * El metodo bajaGrupo cambia el nombre de un grupo a "GRUPO SUPENDIDO",
     * manteniendo el resto de los datos
     *
     * @param codigo
     * @param denominacion
     */
    public void bajaGrupo(int codigo, String denominacion) {
        try {
            Grupo g = regGrupos.get(codigo);
            if (g.getDenominacion().equals(denominacion)) {
                g.setDenominacion(g.getDenominacion().concat("->GRUPO SUSPENDIDO"));
            }
        } catch (Exception NullPointerException) {
            System.out.println("grupo no registrado");
        }
    }

    /**
     *
     * @param codigo
     * @param denominacion
     */
    public void ModificacionGrupo(int codigo, String denominacion) {
        Grupo g = regGrupos.get(codigo);
        g.setDenominacion(denominacion);
    }

    private Grupo buscarGrupo(int cod) {
        return this.regGrupos.get(cod);
    }

    /**
     *
     * @return ArrayList<Grupo>
     */
    public ArrayList listaGrupos() {
        ArrayList<Grupo> grupos = new ArrayList(regGrupos.values());
        return grupos;
    }

    ////////////////////////////////////////////////////////////////////
    //METODOS COMUNIDADES
    ////////////////////////////////////////////////////////////////////
    /**
     *
     * @param actPrincipal
     */
    public void altaComunidad(String actPrincipal) {
        int numero = regComunidades.size() + 1;
        Comunidad c = new Comunidad(numero, actPrincipal);
        regComunidades.put(numero, c);
    }

    /**
     * el metodo bajaComunidad cambia el nombre de una comunidad a "COMUNIDAD
     * SUSPENDIDA", manteniendo el resto de los datos
     *
     * @param numero
     * @param act
     */
    public void bajaComunidad(int numero, String act) {
        try {
            Comunidad c = regComunidades.get(numero);
            if (c.getActPrincipal().equals(act)) {
                c.setActPrincipal(c.getActPrincipal().concat("->COMUNIDAD SUSPENDIDA"));
            }
        } catch (Exception NullPointerException) {
            System.out.println("Comunidad no registrada");
        }
    }

    /**
     *
     * @param numero
     * @param actPrincipal
     */
    public void ModificacionComunidad(int numero, String actPrincipal) {
        Comunidad c = regComunidades.get(numero);
        c.setActPrincipal(actPrincipal);
    }

    public Comunidad buscarComunidad(int num) {
        return this.regComunidades.get(num);
    }

    /**
     *
     * @return ArrayList<Comunidad>
     */
    public ArrayList listaComunidades() {
        ArrayList<Comunidad> comunidades = new ArrayList(regComunidades.values());
        return comunidades;
    }

    //////////////////////////////////////////////////////////////////////
    //METODOS ACTIVIDADES
    ////////////////////////////////////////////////////////////////////
    public void altaActividad(String descripcion, int dia, int mes, int anio) {
        int codigo = regActividades.size() + 1;
        calendario.set(anio, mes, dia);
        Date fecha = calendario.getTime();
        Actividad a = new Actividad(codigo, descripcion, fecha);
        regActividades.add(a);
    }

    /**
     * el metodo bajaActividad cambia el nombre de una Actividad a "ACTIVIDAD
     * SUSPENDIDA", manteniendo el resto de los datos
     *
     * @param codigo
     */
    public void bajaActividad(int codigo) {
        for (Actividad act : regActividades) {
            if (act.getCodigo() == codigo) {
                act.setDescripcion("ACTIVIDAD SUSPENDIDA");
                break;
            }
        }
    }

    /**
     *
     * @param codigo
     * @param descripcion
     * @param dia
     * @param mes
     * @param anio
     */
    public void modificacionActividad(int codigo, String descripcion, int dia, int mes, int anio) {
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

    /**
     *
     * @param codigoActividad
     * @return
     */
    public ArrayList<Participante> getParticipantesDeActividad(int codigoActividad) {
        Actividad actividad = buscarActividad(codigoActividad);
        if (actividad != null) {
            return actividad.getParticipantes();
        }
        return new ArrayList<>(); 
    }

    /**
     *
     * @param codigo
     * @param sc
     */
    public void agregarParticipante(int codigo, Scout sc) {
        Iterator<Actividad> it = regActividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            if (act.getCodigo() == codigo) {
                act.agregarParticipante(sc);
            }
        }
    }

    public void agregarParticipante(int codigo, Scout sc, String resp) {
        Iterator<Actividad> it = regActividades.iterator();
        while (it.hasNext()) {
            Actividad act = it.next();
            if (act.getCodigo() == codigo) {
                act.agregarParticipante(sc, resp);
            }
        }
    }

    public void agregarParticipante(int codigo, Scout sc, String resp1, String resp2) {
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

    //////////////////////////////////////////////////////////////////////
    //METODOS USUARIOS
    ////////////////////////////////////////////////////////////////////
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
        return (regUsuarios.get(datos.get(0)) == null) ? false : regUsuarios.get(datos.get(0)).validarContraseña((String) datos.get(1));
    }

}
