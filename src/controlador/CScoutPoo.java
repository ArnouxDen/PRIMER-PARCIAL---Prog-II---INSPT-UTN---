package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Actividad;
import modelo.MScoutsPoo;
import modelo.Scout;
import modelo.Usuario;
import modelo.Participante;
import vista.VScoutsPoo;
import vista.Constantes;

/**
 * CLASE CONTROLADOR: se encarga de mediar entre el modelo y la vista; gestiona
 * las interacciones del usuario para actualizar el modelo y transmite los datos
 * del modelo a la vista para que los muestre al usuario
 *
 */
public class CScoutPoo {

    VScoutsPoo vista = new VScoutsPoo();
    MScoutsPoo modelo = new MScoutsPoo();
    Scanner scanner = new Scanner(System.in);
    Usuario usr;
    int nivelDeGestion = 0;

    public CScoutPoo() {
    }

    /**
     * metodo abrir, busca un archivo con los datos guardados de una secion
     * anterior y lo carga. en caso de no encontrarlo, da la bienvenida al
     * usario por primera vez
     */
    public void abrir() {
        try {
            MScoutsPoo modeloGuardado = new MScoutsPoo();
            FileInputStream fileInputStream = new FileInputStream("FileMScoutsPoo.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            modeloGuardado = (MScoutsPoo) objectInputStream.readObject();
            modelo = new MScoutsPoo(modeloGuardado);
        } catch (Exception e) {
            System.out.println(Constantes.BIENVENIDA);
        }
    }

    /**
     * run: metodo de apertura, invoca al menu inicial y direcciona al usuario
     * segun sus respuestas
     */
    public void run() {
        int rta;
        //cargaDatos.cargarEn(modelo);
        rta = vista.menuInicial();
        // System.out.println("La respuesta fue: " + rta);
        switch (rta) {
            case 1:
                ArrayList<String> datosUsuario = vista.formInicioSesion();
                if (modelo.validarUsuarioyContraseña(datosUsuario)) {
                    usr = new Usuario(modelo.buscarScout(datosUsuario.get(0)), datosUsuario.get(1));
                    String graduacion = usr.getGraduacion();
                    System.out.println("Bienvenido");
                    System.out.println(graduacion);
                    mostrarMenuSegunGraduacion(graduacion);
                } else {
                    System.out.println(Constantes.ACCESO_DENEGADO);
                    run();
                }
                break;
            case 2:
                ArrayList<String> datosNuevoUsuario = vista.formNuevoUsuario();
                for (Object dato : datosNuevoUsuario) {
                    System.out.println(dato);
                }
                break;
            case 3:
                System.out.println("Gracias, tenga ud muy buen dia!");
                break;
            default:
                break;
        }
    }

    /**
     * el metodo mostrarMenusSegunGraduacion establece el nivel de gestion del
     * usuario segun su graduacion y lo redirige al menu corespondiente
     *
     * @param graduacion
     */
    private void mostrarMenuSegunGraduacion(String graduacion) {
        int opcion = 0;

        switch (graduacion.toLowerCase()) {
            case "castor":
            case "lobato":
            case "lobezna":
            case "scout":
            case "caminante":
                nivelDeGestion = 1;
                opcion = vista.menuScouts();
                break;
            case "rover":
                nivelDeGestion = 2;
                opcion = vista.menuRovers();
                break;
            case "educador/a":
            case "educador":
            case "educadora":
                nivelDeGestion = 3;
                opcion = vista.menuEducador();
                break;
            default:
                System.out.println(Constantes.GRADUACION_NO_RECONOCIDA);
        }

        switch (opcion) {
            case 1:
                int año = vista.solicitarAño();
                if (año == 0) {
                    mostrarMenuSegunGraduacion(graduacion); // Regresar al menú de Scouts
                } else {
                    if (nivelDeGestion == 1) {
                        mostrarActividadesScout(año);
                    }
                    if (nivelDeGestion == 2 || nivelDeGestion == 3) {
                        mostrarActividadesPorAño(año);
                    }
                }
                break;

            case 2:
                if (nivelDeGestion == 1) {
                    mostrarDatosScout();
                }
                if (nivelDeGestion == 2 || nivelDeGestion == 3) {
                    darAltaActividad();
                }
                mostrarMenuSegunGraduacion(graduacion); // Regresar al menú de Scouts
                break;

            case 3:
                if (nivelDeGestion == 1) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                } else if (nivelDeGestion == 2 || nivelDeGestion == 3) {
                    modificarActividad();
                }
                mostrarMenuSegunGraduacion(graduacion);
                break;

            case 4:
                if (nivelDeGestion == 1) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                } else if (nivelDeGestion == 2 || nivelDeGestion == 3) {
                    darDeBajaActividad();
                }
                mostrarMenuSegunGraduacion(graduacion);
                break;

            case 5:
                if (nivelDeGestion == 1) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                } else if (nivelDeGestion == 2 || nivelDeGestion == 3) {
                    agregarParticipanteActividad();
                }
                mostrarMenuSegunGraduacion(graduacion);
                break;

            case 6:
                if (nivelDeGestion == 1 || nivelDeGestion == 2) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                } else if (nivelDeGestion == 3) {
                    abmScout();
                }
                mostrarMenuSegunGraduacion(graduacion);
                break;
            case 7:
                if (nivelDeGestion == 1 || nivelDeGestion == 2) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                } else if (nivelDeGestion == 3) {
                    abmGrupo();
                }
                mostrarMenuSegunGraduacion(graduacion);
                break;
            case 8:
                if (nivelDeGestion == 1 || nivelDeGestion == 2) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                } else if (nivelDeGestion == 3) {
                    abmSede();
                }
                mostrarMenuSegunGraduacion(graduacion);
                break;
            case 9:
                if (nivelDeGestion == 1 || nivelDeGestion == 2) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                } else if (nivelDeGestion == 3) {
                    abmComunidad();
                }
                mostrarMenuSegunGraduacion(graduacion);
                break;

            case 0:
                run();
                break;
            default:
                System.out.println(Constantes.ERR_OPC_INVALIDA);
                break;
        }
    }

    /**
     * El metodo MostrarActividadeScout llama a la vista para mostrar SOLO las
     * actividades del año en las que se encentra inscripto el Scout que
     * consulta. Es el modo de acceder a la informacion del modelo pensada para
     * los usr de nivel de gestion 1 -castores,lobeznas,lobatos,scouts y
     * caminantes-
     *
     * @param año
     */
    public void mostrarActividadesScout(int año) {
        ArrayList<Actividad> actividades = modelo.actividadesAñoPorScout(año, usr.getApodo());
        vista.mostrarActividadesScout(actividades);
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    }

    /**
     * el metodo mostrarActividadesPorAño llama la vista para mostrar todas las
     * actividades registradas del año. Es el modo de acceder a la informacion
     * de las actividades de los usuarios con nivel de gestion 2 y 3 -Rovers y
     * Educadores/as-
     *
     * @param año
     */
    public void mostrarActividadesPorAño(int año) {
        ArrayList<Actividad> actividades = modelo.actividadesAnio(año);
        vista.mostrarActividadesScout(actividades);
        tomarAsistencia();
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    }

    /**
     * El metodo mostrarDatosScout solicita al modelo un objeto Scout
     * determinado y lo envia a la vista para mostrar sus datos al usr
     */
    public void mostrarDatosScout() {
        Scout scout = modelo.buscarScout(usr.getApodo());
        vista.mostrarDatosScout(scout);
    }

    /**
     * El metodo tomarAsistencia permite a los usrs de nivel de gestion 2 y 3
     * -rovers y educadores/as - modificar el registro de asistencia de los
     * participantes
     *
     */
    public void tomarAsistencia() {  
        if (nivelDeGestion == 2 || nivelDeGestion == 3) {
            System.out.println("\n\nDesea modificar el registro de asistencia? (si/no) ");
            if (scanner.nextLine().toLowerCase().equals("si")) {
                System.out.println("Ingrese el codigo de la actividad:");
                int codigoActividad = Integer.parseInt(scanner.nextLine());
                Actividad actividad = modelo.buscarActividad(codigoActividad);
                for (Participante p : actividad.getParticipantes()) {
                    System.out.println(" -> " + p.getApodo() + "(" + p.getNombre() + " " + p.getApellido() + ")");
                    System.out.println("ASISTENCIA:");
                    p.setAsistencia(scanner.nextLine());
                    System.out.println("");
                }
                vista.mostrarDetallesActividad(actividad);
            }
        }
    }

    ////////////////////////////////////////////////////
    //
    //METODOS DE ACTIVIDADES
    //
    ////////////////////////////////////////////////////
    /**
     * darAltaActividad permite enviar al modelo los datos de una nueva
     * actividad para registrarla
     */
    public void darAltaActividad() {
        ArrayList<String> datosNuevaActividad = vista.formNuevaActividad();
        String descripcion = datosNuevaActividad.get(0);
        int dia = Integer.parseInt(datosNuevaActividad.get(1));
        int mes = Integer.parseInt(datosNuevaActividad.get(2));
        int anio = Integer.parseInt(datosNuevaActividad.get(3));

        System.out.println("Descripcion: " + descripcion);
        System.out.println("Fecha: " + dia + "/" + mes + "/" + anio);

        System.out.println("¿Esta seguro de dar de alta esta actividad? (Si/No)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("Si")) {
            modelo.altaActividad(descripcion, dia, mes, anio);
            System.out.println(Constantes.ACTIVIDAD_ALTA_EXITOSA);
            System.out.println(Constantes.PRESIONE_ENTER);
            scanner.nextLine();
            mostrarMenuSegunGraduacion(usr.getGraduacion());
        } else {
            System.out.println(Constantes.OPERACION_CANCELADA);
            System.out.println(Constantes.PRESIONE_ENTER);
            scanner.nextLine();
            mostrarMenuSegunGraduacion(usr.getGraduacion());
        }

        System.out.println(Constantes.PRESIONE_ENTER);
        scanner.nextLine();
    }

    /**
     * modificarActividad permite enviar al modelo los datos de una actividad
     * que se desea modificar
     */
    public void modificarActividad() {

        int codigoActividad = vista.solicitarCodigoActividad();
        Actividad actividad = modelo.buscarActividad(codigoActividad);
        actividad = vista.modificarActividad(actividad);

        System.out.println("Asi quedarian los cambios:");
        vista.mostrarDetallesActividad(actividad);
        if (vista.confirmarModificarActividad()) {
            modelo.modificacionActividad(actividad.getCodigo(), actividad.getDescripcion(), actividad.getFecha().getDate(),
                    actividad.getFecha().getMonth(), actividad.getFecha().getYear() + 1900);
            vista.mostrarMensaje("Actividad modificada con exito.");
        } else {
            System.out.println(Constantes.OPERACION_CANCELADA);
            mostrarMenuSegunGraduacion(usr.getGraduacion());
        }
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    }

    /**
     * darDeBajaActividad permite enviar al modelo el CODIGO de una actividad
     * que se desea dar de baja
     */
    public void darDeBajaActividad() {
        int codigoActividad = vista.solicitarCodigoActividad();
        Actividad actividad = modelo.buscarActividad(codigoActividad);
        if (actividad != null) {
            if (actividad.getDescripcion().equals("ACTIVIDAD SUSPENDIDA")) {
                vista.mostrarMensaje(Constantes.ACTIVIDAD_SUSPENDIDA_BAJA);
                System.out.println(Constantes.PRESIONE_ENTER);
                scanner.nextLine();
                mostrarMenuSegunGraduacion(usr.getGraduacion());
                return;
            }
            vista.mostrarDetallesActividad(actividad);
            if (vista.confirmarBajaActividad()) {
                modelo.bajaActividad(codigoActividad);
                vista.mostrarMensaje(Constantes.BAJA_EXITOSA);
                mostrarMenuSegunGraduacion(usr.getGraduacion());
            } else {
                vista.mostrarMensaje(Constantes.OPERACION_CANCELADA);
                mostrarMenuSegunGraduacion(usr.getGraduacion());
            }
        } else {
            vista.mostrarMensaje("No se encontro una actividad con el codigo ingresado.");
            System.out.println(Constantes.PRESIONE_ENTER);
            scanner.nextLine();
            mostrarMenuSegunGraduacion(usr.getGraduacion());
        }
    }

    /**
     * agregarParticipanteActividad permite enviar al modelo los datos de un
     * nuevo participante para registrar en una actividad determinada
     */
    public void agregarParticipanteActividad() {
        int codigoActividad = vista.solicitarCodigoActividad();
        Actividad actividad = modelo.buscarActividad(codigoActividad);
        if (actividad != null) {
            ArrayList<String> datosParticipante = vista.formularioAgregarParticipante();
            String apodo = datosParticipante.get(0);
            String responsabilidad = datosParticipante.get(1);
            // String observacion = datosParticipante.get(2);
            Scout scout = modelo.buscarScout(apodo);
            if (scout != null && scout.getCodigo() != 0) {
                modelo.agregarParticipante(codigoActividad, scout, responsabilidad);
                vista.mostrarMensaje("Participante agregado con éxito a la actividad.");

            } else {
                vista.mostrarMensaje("No se encontró un scout con el apodo ingresado participando en la organizacion.");
                System.out.println(Constantes.PRESIONE_ENTER);
                scanner.nextLine();
                mostrarMenuSegunGraduacion(usr.getGraduacion());
            }
        } else {
            vista.mostrarMensaje(Constantes.COD_ACT_NO_FOUND);
        }
        System.out.println(Constantes.PRESIONE_ENTER);
        scanner.nextLine();
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    }

    ////////////////////////////////////////////////////
    //
    //ABMs GENERALES  (SCOUT,GRUPO, SEDE Y COMUNIDAD ) EXCLUSIVOS PARA USR DE NIVEL DE GESTION 3 -EDUCADERES/AS
    //
    ////////////////////////////////////////////////////
    /**
     * ABM SCOUT PERMITE ENVIAR AL MODELO PEDIDO DE ALTA, BAJA Y MODIFICACION DE
     * SCOUTS
     */
    public void abmScout() {
        //mostrar menu de opciones
        switch (vista.menuAbmScout()) {
            case 1:
                vista.mostrarListadoScouts(modelo.listaScouts());
                break;
            case 2:
                ArrayList<String> datosAltaScout = vista.formularioAltaScout(modelo.listaScouts(), modelo.listaGrupos(), modelo.listaSedes(), modelo.listaComunidades());
                try {
                    modelo.altaScout(datosAltaScout.get(0), datosAltaScout.get(1), datosAltaScout.get(2), datosAltaScout.get(3), Integer.parseInt(datosAltaScout.get(4)), Integer.parseInt(datosAltaScout.get(5)), Integer.parseInt(datosAltaScout.get(6)));
                } catch (Exception e) {
                    System.out.println("Imposible efectuar el alta.");
                }
                break;

            case 3:
                ArrayList<String> datosBaja = vista.formularioBajaScout();
                modelo.bajaScout(Integer.parseInt(datosBaja.get(0)), datosBaja.get(1));
                break;
            case 4:
                ArrayList<String> datosModificacion = vista.formularioModificacionDatosScout(modelo.listaScouts());
                modelo.modificacionScout(datosModificacion.get(0), datosModificacion.get(1), datosModificacion.get(2), datosModificacion.get(3), Integer.parseInt(datosModificacion.get(4)));
                break;
            case 0:

                break;
            default:

        }
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    }

    /**
     * ABMGRUPO PERMITE ENIVAR AL MODELO PEDIDO DE ALTA, BAJA Y MODIFICACION DE
     * GRUPOS
     */
    public void abmGrupo() {
        //mostrar menu de opciones
        switch (vista.menuAbmGrupo()) {
            case 1:
                vista.mostrarListadoGrupos(modelo.listaGrupos());
                break;
            case 2:
                modelo.altaGrupo(vista.formularioAltaGrupo().get(0));
                break;
            case 3:
                ArrayList<String> datosBaja = vista.formularioBajaGrupo();
                modelo.bajaGrupo(Integer.parseInt(datosBaja.get(0)), datosBaja.get(1));
                break;
            case 4:
                ArrayList<String> datosModificacionGrupo = vista.formularioModificacionDatosGrupo(modelo.listaGrupos());
                modelo.ModificacionGrupo(Integer.parseInt(datosModificacionGrupo.get(0)), datosModificacionGrupo.get(1));
                break;
            case 0:

                break;
            default:

        }
        mostrarMenuSegunGraduacion(usr.getGraduacion());

    }

    /**
     * ABM SEDE PERMITE ENIVAR AL MODELO PEDIDO DE ALTA, BAJA Y MODIFICACION DE
     * SEDE
     */
    public void abmSede() {
        switch (vista.menuAbmSede()) {
            case 1:
                vista.mostrarListadoSedes(modelo.listaSedes());
                break;
            case 2:
                modelo.altaSede(vista.formularioAltaSede().get(0), vista.formularioAltaSede().get(1), vista.formularioAltaSede().get(2), vista.formularioAltaSede().get(3));
                break;
            case 3:
                ArrayList<String> datosBaja = vista.formularioBajaSede();
                modelo.bajaSede(Integer.parseInt(datosBaja.get(0)), datosBaja.get(1));
                break;
            case 4:
                ArrayList<String> datosModificacionSede = vista.formularioModificacionDatosSede(modelo.listaSedes());
                modelo.ModificacionSede(Integer.parseInt(datosModificacionSede.get(0)), datosModificacionSede.get(1), datosModificacionSede.get(2), datosModificacionSede.get(3), datosModificacionSede.get(4));
                break;
            case 0:

                break;
            default:
        }
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    }

    /**
     * ABM COMUNIDAD PERMITE ENIVAR AL MODELO PEDIDO DE ALTA, BAJA Y
     * MODIFICACION DE COMUNIDADES
     */
    public void abmComunidad() {
        switch (vista.menuAbmComunidad()) {
            case 1:
                vista.mostrarListadoComunidades(modelo.listaComunidades());
                break;
            case 2:
                modelo.altaComunidad(vista.formularioAltaComunidad().get(0));
                break;
            case 3:
                ArrayList<String> datosBaja = vista.formularioBajaComunidad();
                modelo.bajaComunidad(Integer.parseInt(datosBaja.get(0)), datosBaja.get(1));
                break;
            case 4:
                ArrayList<String> datosModificacionComunidad = vista.formularioModificacionDatosComunidad(modelo.listaComunidades());
                modelo.ModificacionComunidad(Integer.parseInt(datosModificacionComunidad.get(0)), datosModificacionComunidad.get(1));
                break;
            case 0:
                break;
            default:
        }
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    }

    /**
     * El metodo GUARDAR permite guardar las modificaciones hechas en los
     * registro de la clase modelo en un archivo de datos, este podra abrirse en
     * posteriores sesiones ATENCION! EL METODO SOLO SE INVOCA AL FINALIZAR EL
     * PROGRAMA, POR LO QUE SI SE INTERRUMPE EN MEDIO DE LA EJECUCION LA
     * INFORMACION MODIFICADA SE PIERDE
     */
    public void guardar() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("FileMScoutsPoo.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(modelo);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage() + "ERROR en guardar");
        }
    }
}
