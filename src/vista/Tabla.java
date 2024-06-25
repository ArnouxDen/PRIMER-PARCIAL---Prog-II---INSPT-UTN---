package vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import modelo.Actividad;
import modelo.Comunidad;
import modelo.Grupo;
import modelo.Participante;
import modelo.Scout;
import modelo.Sede;

/**
 * la clase Tabla agrupa y organiza las tablas utilizadas por la vista del
 * programa como comportamiento general no devuelven nada y presentan informción
 */
public class Tabla {

    public Tabla() {
    }

    Scanner scanner = new Scanner(System.in);

    public void mostrarTablaScout() {
        // Muestra la tabla con los encabezados y espacios en blanco para los datos
        System.out.println("\nACTIVIDADES - 2024");
        System.out.println("FECHA | CODIGO(DE ACTIVIDAD) | DESCRIPCION(DE LA ACTIVIDAD) | ASISTENCIA(PRESENTE O AUSENTE)");
        System.out.println("      |                       |                             |                              ");
    }

    public void datosScout(Scout scout) {
        System.out.println("DATOS PERSONALES");
        System.out.println("Apodo: " + scout.getApodo());
        System.out.println("Codigo: " + scout.getCodigo());
        System.out.println("Nombre: " + scout.getNombre());
        System.out.println("Apellido: " + scout.getApellido());
        System.out.println("Graduacion: " + scout.getGraduacion());
    }

    public void actividadesScout(ArrayList<Actividad> actividades) {
        if (actividades.isEmpty()) {
            System.out.println("No hay actividades inscritas para el año ingresado.");
        } else {
            System.out.println("ACTIVIDADES");
            System.out.println("FECHA      | CODIGO | DESCRIPCION");
            for (Actividad actividad : actividades) {
                System.out.println(actividad.getFechaConFormato() + " | " + actividad.getCodigo() + " | " + actividad.getDescripcion());
            }
        }
    }

    public void detalleActividad(Actividad actividad) {
        System.out.println("Detalles de la actividad:");
        try {
            System.out.println("Código: " + actividad.getCodigo());
            System.out.println("Descripción: " + actividad.getDescripcion());
            System.out.println("Fecha: " + actividad.getFechaConFormato() + "\n");
        } catch (Exception e) {
            System.out.println(Constantes.ERR_OPC_INVALIDA);

        }
        System.out.println("PARTICIPANTES \t\t| RESPONSABILIDADES\t\t| ASISTENCIA");
        System.out.println("___________________________________________________________________________________");
        for (Participante p : actividad.getParticipantes()) {
            System.out.println(" *" + p.getApodo());
            if (p.getResponsabilidades() == null) {
                System.out.println(".             " + ".");
            } else {
                for (String r : p.getResponsabilidades()) {
                    System.out.println("\t\t\t" + r);
                }
            }
            System.out.println("\t\t\t\t\t\t\t " + p.getAsistencia());
            System.out.println("___________________________________________________________________________________");
        }
    }

    public void listaScouts(ArrayList<Scout> listaScouts) {
        if (listaScouts.isEmpty()) {
            System.out.println("No se encontraros Scouts inscriptos.");
        } else {
            Collections.sort(listaScouts, (Scout s1, Scout s2) -> new Integer(s1.getCodigo()).compareTo(new Integer(s2.getCodigo())));
            System.out.println("Scouts Argentina");
            System.out.println("cod.\t\t|APODO\t\t| NOMBRE\t\t | APELLIDO\t\t| GRADUACION");
            for (Scout scout : listaScouts) {
                System.out.printf("%4d %20s %20s %20s %20s\n", scout.getCodigo(), scout.getApodo(), scout.getNombre(), scout.getApellido(), scout.getGraduacion());
            }
        }
    }

    public void listaGrupos(ArrayList<Grupo> listaGrupos) {
        if (listaGrupos.isEmpty()) {
            System.out.println("No se encontraros grupos inscriptos.");
        } else {
            Collections.sort(listaGrupos, (Grupo g1, Grupo g2) -> new Integer(g1.getCodigo()).compareTo(new Integer(g2.getCodigo())));
            System.out.println("Grupos de Scouts Argentina");
            System.out.println("cod.\t\t|DENOMINACION");
            for (Grupo grupo : listaGrupos) {
                System.out.printf("%5d %30s\n", grupo.getCodigo(), grupo.getDenominacion());
            }
        }
    }

    public void listaSedes(ArrayList<Sede> listaSedes) {
        if (listaSedes.isEmpty()) {
            System.out.println("No se encontraros sedes inscriptas.");
        } else {
            Collections.sort(listaSedes, (Sede s1, Sede s2) -> new Integer(s1.getCodigo()).compareTo(new Integer(s2.getCodigo())));
            System.out.println("Sedes de Scouts Argentina");
            System.out.println("cod.\t\t\t|NOMBRE\t\t\t | DIRECCION \t\t\t| PROVINCIA\t\t\t | LOCALIDAD");
            for (Sede sede : listaSedes) {
                System.out.printf("%5d %30s %40s %30s\n", sede.getCodigo(), sede.getNombre(), sede.getDireccion(), sede.getProvincia(), sede.getLocalidad());
            }
        }
    }

    public void listaComunidades(ArrayList<Comunidad> listaComunidades) {
        if (listaComunidades.isEmpty()) {
            System.out.println("No se encontraros comunidades inscriptas.");
        } else {
            Collections.sort(listaComunidades, (Comunidad c1, Comunidad c2) -> new Integer(c1.getNumero()).compareTo(new Integer(c2.getNumero())));
            System.out.println("Comunidades de Scouts Argentina");
            System.out.println("num.\t\t|ACT PRINCIPAL\t\t");
            for (Comunidad comunidad : listaComunidades) {
                System.out.printf("%4d %30s \n", comunidad.getNumero(), comunidad.getActPrincipal());
            }
        }
    }
}
