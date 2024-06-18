package controlador;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.MScoutsPoo;
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
        /*
        carga datos
         */
       cargaDatos.cargarEn(modelo);

        rta = vista.menuInicial();
        System.out.println("La respuesta fue: " + rta);
        switch (rta) {
            case 1:
                // Inicio de sesión

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
                // Nuevo usuario
                ArrayList<String> datosNuevoUsuario = vista.formNuevoUsuario();
                for (Object dato : datosNuevoUsuario) {
                    System.out.println(dato);
                }
                break;
            case 3:
                System.out.println("Opcion tres no registrada aún");
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
                vista.menuScouts();
                break;
            case "rover":
                vista.menuRovers();
                break;
            case "educador":
                vista.menuEducador();
                break;
            default:
                System.out.println("Graduación no reconocida");
                break;
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


