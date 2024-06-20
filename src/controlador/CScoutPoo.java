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
import vista.VScoutsPoo;

public class CScoutPoo {

    VScoutsPoo vista = new VScoutsPoo();
    MScoutsPoo modelo = new MScoutsPoo();
    Usuario usr;

    public CScoutPoo() {
    }

    public void run() {
        int rta;
      //  cargaDatos.cargarEn(modelo);

        rta = vista.menuInicial();
        System.out.println("La respuesta fue: " + rta);
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
                    System.out.println("Acceso denegado");
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

    private void mostrarMenuSegunGraduacion(String graduacion) {
        switch (graduacion.toLowerCase()) {
            case "castor":
            case "lobato":
            case "lobezna":
            case "scout":
            case "caminante":
                vista.menuScouts(this);
                break;
            case "rover":
                vista.menuRovers(this);
                break;
            case "educador":
                vista.menuEducador(this);
                break;
            default:
                System.out.println("Graduación no reconocida");
                break;
        }
    }

    public void mostrarActividadesScout(int año) {
        ArrayList<Actividad> actividades = modelo.actividadesAñoPorScout(año, usr.getApodo());
        vista.mostrarActividadesScout(actividades);
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    }

    public void mostrarActividadesPorAño(int año) {
        ArrayList<Actividad> actividades = modelo.actividadesAnio(año);
        vista.mostrarActividadesScout(actividades);
        mostrarMenuSegunGraduacion(usr.getGraduacion());
        
    }

    public void mostrarDatosScout() {
        Scout scout = modelo.buscarScout(usr.getApodo());
        vista.mostrarDatosScout(scout);
        }

    public void mostrarDetallesActividad(int codigoActividad) {
        Actividad actividad = modelo.buscarActividad(codigoActividad);
        vista.mostrarDetallesActividad(actividad);
    }

    public void darAltaActividad() {
        ArrayList<String> datosNuevaActividad = vista.formNuevaActividad();
        Scanner scanner = new Scanner(System.in);
        String descripcion = datosNuevaActividad.get(0);
        int dia = Integer.parseInt(datosNuevaActividad.get(1));
        int mes = Integer.parseInt(datosNuevaActividad.get(2));
        int año = Integer.parseInt(datosNuevaActividad.get(3));

        modelo.altaActividad(descripcion, dia, mes, año);
        System.out.println("Actividad creada con éxito.");
        System.out.println("Presione ENTER para continuar");
        scanner.nextLine();
    }

   
    public void modificarActividad() {
    int codigoActividad = vista.solicitarCodigoActividad();
    Actividad actividad = modelo.buscarActividad(codigoActividad);
    if (actividad != null) {
        vista.mostrarDetallesActividad(actividad);
        int opcionModificacion;
        Scanner scanner = new Scanner(System.in);
        do {
            vista.mostrarMenuModificacion();
            opcionModificacion = scanner.nextInt();
            switch (opcionModificacion) {
                case 1:
                    System.out.print("Nueva descripción: ");
                    scanner.nextLine(); 
                    String nuevaDescripcion = scanner.nextLine();
                    actividad.setDescripcion(nuevaDescripcion);
                    System.out.println("Descripción modificada con éxito.");
                    break;
                case 2:
                    System.out.print("Nuevo día: ");
                    int nuevoDia = scanner.nextInt();
                    actividad.getFecha().setDate(nuevoDia);
                    System.out.println("Día modificado con éxito.");
                    break;
                case 3:
                    System.out.print("Nuevo mes: ");
                    int nuevoMes = scanner.nextInt();
                    actividad.getFecha().setMonth(nuevoMes - 1); 
                    System.out.println("Mes modificado con éxito.");
                    break;
                case 4:
                    System.out.print("Nuevo año: ");
                    int nuevoAnio = scanner.nextInt();
                    actividad.getFecha().setYear(nuevoAnio - 1900); 
                    System.out.println("Año modificado con éxito.");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcionModificacion != 0);
        mostrarMenuSegunGraduacion(usr.getGraduacion());
    } else {
        System.out.println("No se encontró una actividad con el código ingresado.");
    }
}

    

    public void darDeBajaActividad() {
        int codigoActividad = vista.solicitarCodigoActividad();
        Actividad actividad = modelo.buscarActividad(codigoActividad);
        if (actividad != null) {
            vista.mostrarDetallesActividad(actividad);
            if (vista.confirmarBajaActividad()) {
                modelo.bajaActividad(codigoActividad);
                vista.mostrarMensaje("Actividad dada de baja con éxito.");
            } else {
                vista.mostrarMensaje("Operación cancelada.");
            }
        } else {
            vista.mostrarMensaje("No se encontró una actividad con el código ingresado.");
        }
    }

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

    public void abrir() {
        try {
            MScoutsPoo modeloGuardado = new MScoutsPoo();
            FileInputStream fileInputStream = new FileInputStream("FileMScoutsPoo.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            modeloGuardado = (MScoutsPoo) objectInputStream.readObject();
            modelo = new MScoutsPoo(modeloGuardado);
        } catch (Exception e) {
            System.out.println("\tBienvenido al Sistema de gestión de actividades de Scouts Argentina \n\t ATENCIÓN: No se ha encontrado un archivo previo");
        }
    }
}
