package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Actividad;
import modelo.Scout;
import java.util.InputMismatchException;
import modelo.Comunidad;
import modelo.Grupo;
import modelo.Sede;

/**
 * La clase vista es unico punto de contacto con el usuario, presentando la
 * informacion del sistema de forma estructurada y recibiendo comandos para
 * transmitir al controlador utiliza tablas, menues y formularios
 *
 */
public class VScoutsPoo {

    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    Tabla tabla = new Tabla();
    Formulario formulario = new Formulario();

    public VScoutsPoo() {
    }

    /**
     *
     *
     */
    public int menuInicial() {
        return menu.inicio();
    }

    public ArrayList<String> formInicioSesion() {
        return formulario.inicioSesion();
    }

    public int menuScouts() {
        return menu.opcionesScout();
    }

    public int menuRovers() {
        return menu.opcionesRover();
    }

    public int menuEducador() {
        return menu.opcionesEducador();
    }

    public ArrayList<String> formNuevoUsuario() {
        return formulario.nuevoUsuario();
    }

    public Integer solicitarAño() {
        scanner.nextLine();
        int año = 0;
        do {
            System.out.print("Ingrese el año para ver las actividades (o 0 para regresar al menu): ");
            try {
                año = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.INGRESE_NUM);
                scanner.nextLine();
            }
            if (año <= 0) {
                System.out.println(Constantes.ANIO_INVALIDO);
            }
        } while (año <= 0);
        return año;
    }

    public void mostrarActividadesScout(ArrayList<Actividad> actividades) {
        tabla.actividadesScout(actividades);
        int rta;
        if (actividades.isEmpty()) {
            System.out.println(Constantes.PRESIONE_ENTER);
            scanner.nextLine();
            rta = 0;
        } else {
            System.out.println("Ingrese el codigo de la actividad que desea inspeccionar o \"0\" para salir: ");
            try {
                rta = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println(Constantes.ERR_OPC_INVALIDA);
                rta = 0;
            }
        }
        if (rta != 0) {
            int flag = 0;
            for (Actividad act : actividades) {
                if (act.getCodigo() == rta) {
                    mostrarDetallesActividad(act);
                    flag = 1;
                    break; //SUB-OPTIMO
                }
            }
            if (flag == 0) {
                System.out.println("Actividad no encontrada.");
            }
        }
    }

    public void mostrarDetallesActividad(Actividad actividad) {
        tabla.detalleActividad(actividad);
        System.out.println(Constantes.PRESIONE_ENTER);
        scanner.nextLine();
    }

    public void mostrarDatosScout(Scout scout) {
        tabla.datosScout(scout);
        System.out.println(Constantes.PRESIONE_ENTER);
        scanner.nextLine();
    }

    public ArrayList<String> formNuevaActividad() {
        return formulario.nuevaActividad();
    }

    public ArrayList<String> formularioAgregarParticipante() {
        return formulario.agregarParticipante();
    }

    public Integer solicitarCodigoActividad() {
        Integer codigoActividad = null;
        while (codigoActividad == null) {
            try {
                System.out.print("Ingrese el codigo de la actividad: ");
                codigoActividad = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(Constantes.ERR_OPC_INVALIDA);
                scanner.next(); // Limpiar el buffer del scanner
            }
        }
        return codigoActividad;
    }

    public int mostrarMenuModificacion() {
        return menu.opcionesModificacionActividad();
    }

    public boolean confirmarBajaActividad() {
        System.out.print(Constantes.CONFIRMAR_BAJA);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("si");
    }

    public Actividad modificarActividad(Actividad actividad) {

        if (actividad != null) {
            if (actividad.getDescripcion().equals("ACTIVIDAD SUSPENDIDA")) {
                mostrarMensaje(Constantes.ACTIVIDAD_SUSPENDIDA_MOD);
                System.out.println(Constantes.PRESIONE_ENTER);
                scanner.nextLine();
            } else {
                mostrarDetallesActividad(actividad);
                int opcionModificacion;
                do {
                    opcionModificacion = mostrarMenuModificacion();
                    switch (opcionModificacion) {
                        case 1:
                            System.out.print("Nueva descripcion: ");
                            String nuevaDescripcion = scanner.nextLine();
                            actividad.setDescripcion(nuevaDescripcion);
                            System.out.println("Descripcion modificada con exito.");
                            break;
                        case 2:
                            System.out.print("Nuevo dia: ");
                            int nuevoDia = Integer.parseInt(scanner.nextLine());
                            actividad.getFecha().setDate(nuevoDia);
                            System.out.println("Dia modificado con exito.");
                            break;
                        case 3:
                            System.out.print("Nuevo mes: ");
                            int nuevoMes = Integer.parseInt(scanner.nextLine());
                            actividad.getFecha().setMonth(nuevoMes - 1);
                            System.out.println("Mes modificado con exito.");
                            break;
                        case 4:
                            System.out.print("Nuevo año: ");
                            int nuevoAnio = Integer.parseInt(scanner.nextLine());
                            actividad.getFecha().setYear(nuevoAnio - 1900);
                            System.out.println("Año modificado con exito.");
                            break;
                        case 0:
                            System.out.println("Volviendo al menu principal...");
                            break;
                        default:
                            System.out.println(Constantes.ERR_OPC_INVALIDA);
                            break;
                    }
                } while (opcionModificacion != 0);
            }
        } else {
            System.out.println("\n\nNo se encontro una actividad con el codigo ingresado.");
        }
        return actividad;
    }

    public boolean confirmarModificarActividad() {
        System.out.print(Constantes.CONFIRMAR_MOD);
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("si");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int menuAbmScout() {
        return menu.opcionesAbmScout();
    }

    public void mostrarListadoScouts(ArrayList<Scout> listaScouts) {
        tabla.listaScouts(listaScouts);
    }

    public ArrayList formularioAltaScout(ArrayList<Scout> listaScouts, ArrayList<Grupo> listaGrupos, ArrayList<Sede> listaSedes, ArrayList<Comunidad> listaComunidades) {
        ArrayList<String> datos = formulario.altaScout(listaScouts);
        String grupo = null;
        String sede = null;
        String comunidad = null;
        try {
            do {
                System.out.println("Seleccione el código de grupo del Scout");
                mostrarListadoGrupos(listaGrupos);
                System.out.println("Código grupo: ");

                grupo = scanner.nextLine();

            } while (Integer.parseInt(grupo) <= 0 || Integer.parseInt(grupo) > listaGrupos.size());

            System.out.println("Grupo seleccionado: " + grupo);
            System.out.println(Constantes.PRESIONE_ENTER);
            datos.add(grupo);
            scanner.nextLine();

            do {
                System.out.println("Seleccione el código sede del Scout");
                mostrarListadoSedes(listaSedes);
                System.out.println("Código sede: ");

                sede = scanner.nextLine();

            } while (Integer.parseInt(sede) <= 0 || Integer.parseInt(sede) > listaSedes.size());

            System.out.println("Sede selecionada: " + sede);
            System.out.println(Constantes.PRESIONE_ENTER);
            datos.add(sede);
            scanner.nextLine();

            do {
                System.out.println("Seleccione el numero de comunidad del Scout");
                mostrarListadoComunidades(listaComunidades);
                System.out.println("Numero Comunidad: ");

                comunidad = scanner.nextLine();

            } while (Integer.parseInt(comunidad) <= 0 || Integer.parseInt(comunidad) > listaComunidades.size());

            System.out.println("Comunidad selecionada: " + comunidad);
            System.out.println(Constantes.PRESIONE_ENTER);
            datos.add(sede);
            scanner.nextLine();

            datos.add(comunidad);
        } catch (Exception e) {
            System.out.println(Constantes.ERR_OPC_INVALIDA);
            datos = null;
        }
        return datos;
    }

    public ArrayList formularioBajaScout() {
        return formulario.bajaScout();
    }

    public ArrayList formularioModificacionDatosScout(ArrayList<Scout> listaScouts) {
        Scout scout = null;
        System.out.println("Ingrese el apodo del Scout que desea modificar:");
        String apodo = scanner.nextLine();
        while (scout == null) {
            for (Scout sc : listaScouts) {
                if (sc.getApodo().equals(apodo)) {
                    scout = sc;
                }
            }
            if (scout == null) {
                System.out.println("Apodo no encontrado");
            }
        }
        return formulario.modificacionDatosScout(scout);
    }

    public int menuAbmGrupo() {
        return menu.opcionesAbmGrupos();
    }

    public void mostrarListadoGrupos(ArrayList<Grupo> listaGrupos) {
        tabla.listaGrupos(listaGrupos);
    }

    public ArrayList<String> formularioAltaGrupo() {
        return formulario.altaGrupo();
    }

    public ArrayList<String> formularioBajaGrupo() {
        return formulario.bajaGrupo();
    }

    public ArrayList<String> formularioModificacionDatosGrupo(ArrayList<Grupo> listaGrupos) {
        return formulario.modificacionDatosGrupo(listaGrupos);
    }

    public void mostrarListadoSedes(ArrayList<Sede> listaSedes) {
        tabla.listaSedes(listaSedes);
    }

    public int menuAbmSede() {
        return menu.opcionesAbmSede();
    }

    public ArrayList<String> formularioAltaSede() {
        return formulario.altaSede();
    }

    public ArrayList<String> formularioBajaSede() {
        return formulario.bajaSede();
    }

    public void mostrarListadoComunidades(ArrayList<Comunidad> listaComunidades) {
        tabla.listaComunidades(listaComunidades);
    }

    public ArrayList<String> formularioModificacionDatosSede(ArrayList<Sede> listaSedes) {
        return formulario.modificacionDatosSede(listaSedes);
    }

    public int menuAbmComunidad() {
        return menu.opcionesAbmComunidad();
    }

    public ArrayList<String> formularioAltaComunidad() {
        return formulario.altaComunidad();
    }

    public ArrayList<String> formularioBajaComunidad() {
        return formulario.bajaComunidad();
    }

    public ArrayList<String> formularioModificacionDatosComunidad(ArrayList<Comunidad> listaComunidades) {
        return formulario.modificacionDatosComunidad(listaComunidades);
    }
}
