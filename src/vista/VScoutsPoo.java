package vista;

import java.util.ArrayList;
import java.util.Scanner;
import controlador.CScoutPoo;
import modelo.Actividad;
import modelo.Scout;

public class VScoutsPoo {

    public VScoutsPoo() {
    }

    public void menuScouts(CScoutPoo controlador) {
        System.out.println("\nMENU SCOUTS (CASTOR/LOBATO/LOVEZNA/CAMINANTE):");
        System.out.println("1- VER ACTIVIDADES POR AÑO (EN LAS QUE ESTA INSCRIPTO)");
        System.out.println("2 - VER DATOS PERSONALES");
        System.out.println("0 - SALIR AL MENU PRINCIPAL");
        System.out.print("Ingrese una opcion: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                int año = solicitarAño();
                if (año == 0) {
                    menuScouts(controlador); // Regresar al menú de Scouts
                } else {
                    controlador.mostrarActividadesScout(año);
                }
                break;
            case 2:
                controlador.mostrarDatosScout();
                menuScouts(controlador); // Regresar al menú de Scouts
                break;
            case 0:
                controlador.run();

            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void menuRovers(CScoutPoo controlador) {
        System.out.println("\nMENU ROVERS:");
        System.out.println("1 - VER ACTIVIDADES POR AÑO (TODAS)");
        System.out.println("2 - CREAR NUEVA ACTIVIDAD");
        System.out.println("3 - MODIFICAR ACTIVIDAD");
        System.out.println("4 - DAR DE BAJA ACTIVIDAD");
        System.out.println("5 - ASIGNAR PARTICIPANTES A UNA ACTIVIDAD");
        System.out.println("0 - SALIR AL MENU PRINCIPAL");
        System.out.print("Ingrese una opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                int año = solicitarAño();
                if (año == 0) {
                    menuRovers(controlador); // Regresar al menú de Rovers
                } else {
                    controlador.mostrarActividadesPorAño(año);
                }
                break;
            case 2:
                controlador.darAltaActividad();
                menuRovers(controlador);
                break;
            case 3:
                controlador.modificarActividad();
                break;
            case 4:
                controlador.darDeBajaActividad();
                break;
            case 0:
                controlador.run();
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void menuEducador(CScoutPoo controlador) {
        System.out.println("\nMENU EDUCADOR:");
        System.out.println("1 - VER ACTIVIDADES POR AÑO (TODAS)");
        System.out.println("2 - CREAR NUEVA ACTIVIDAD");
        System.out.println("3 - MODIFICAR ACTIVIDAD");
        System.out.println("4 - DAR DE BAJA ACTIVIDAD");
        System.out.println("5 - ASIGNAR PARTICIPANTES A UNA ACTIVIDAD");
        System.out.println("0 - SALIR AL MENU PRINCIPAL");
        System.out.print("Ingrese una opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                int año = solicitarAño();
                if (año == 0) {
                    menuEducador(controlador); // Regresar al menú de Educador
                } else {
                    controlador.mostrarActividadesPorAño(año);
                }
                break;
            case 2:
                controlador.darAltaActividad();
                break;
            case 3:
                controlador.modificarActividad();
                break;
            case 4:
                controlador.darDeBajaActividad();
                break;
            case 0:
                controlador.run();
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public int menuInicial() {
        System.out.println("\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t Bienvenido! Ingrese la opcion deseada:");
        System.out.println("\t\t\t1: Iniciar Sesion");
        System.out.println("\t\t\t2: Crear Nuevo Usuario");
        System.out.println("\t\t\t3: Salir");
        System.out.print("Ingrese una opcion: ");
        int opcion = 0;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                opcion = scanner.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("Opcion invalida");
                System.out.print("Ingrese una nueva opcion: ");
            }
        } while (opcion == 0);
        return opcion;
    }

    public ArrayList<String> formInicioSesion() {
        ArrayList<String> datos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t INICIO SESION");
        System.out.print("\t\t\tApodo: ");
        datos.add(scanner.nextLine());
        System.out.print("\t\t\tContraseña: ");
        datos.add(scanner.nextLine());
        return datos;
    }

    public ArrayList<String> formNuevoUsuario() {
        ArrayList<String> datos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t NUEVO USUARIO");
        System.out.print("\tApodo: ");
        datos.add(scanner.nextLine());
        System.out.print("\tContraseña: ");
        datos.add(scanner.nextLine());
        System.out.print("\tDirección: ");
        datos.add(scanner.nextLine());
        System.out.print("\tTeléfono: ");
        datos.add(scanner.nextLine());
        System.out.print("\tNombre de la mascota: ");
        datos.add(scanner.nextLine());
        return datos;
    }

    public int solicitarAño() {
        Scanner scanner = new Scanner(System.in);
        int año;
        while (true) {
            System.out.print("Ingrese el año para ver las actividades (o 0 para regresar al menú): ");
            año = scanner.nextInt();
            if (año >= 0) {
                break;
            } else {
                System.out.println("");
            }
        }
        return año;
    }

    public void mostrarActividadesScout(ArrayList<Actividad> actividades) {
        Scanner scanner = new Scanner(System.in);
        if (actividades.isEmpty()) {
            System.out.println("No hay actividades inscritas para el año ingresado.");
        } else {
            System.out.println("ACTIVIDADES");
            System.out.println("FECHA | CODIGO | DESCRIPCION");
            for (Actividad actividad : actividades) {
                System.out.println(actividad.getFechaConFormato() + " | " + actividad.getCodigo() + " | " + actividad.getDescripcion());
            }
        }
        System.out.println("Presione ENTER para continuar");
        scanner.nextLine();
       }

    public void mostrarDetallesActividad(Actividad actividad) {
        System.out.println("Detalles de la actividad:");
        System.out.println("Código: " + actividad.getCodigo());
        System.out.println("Descripción: " + actividad.getDescripcion());
        System.out.println("Fecha: " + actividad.getFechaConFormato());
    }

    public void mostrarDatosScout(Scout scout) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("DATOS PERSONALES");
        System.out.println("Apodo: " + scout.getApodo());
        System.out.println("Codigo: " + scout.getCodigo());
        System.out.println("Nombre: " + scout.getNombre());
        System.out.println("Apellido: " + scout.getApellido());
        System.out.println("Graduacion: " + scout.getGraduacion());
        System.out.println("Presione ENTER para continuar");
        scanner.nextLine();
    }

    public ArrayList<String> formNuevaActividad() {
        ArrayList<String> datos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nCREAR NUEVA ACTIVIDAD");
        System.out.print("Descripción de la actividad: ");
        datos.add(scanner.nextLine());
        System.out.print("Día: ");
        datos.add(scanner.nextLine());
        System.out.print("Mes: ");
        datos.add(scanner.nextLine());
        System.out.print("Año: ");
        datos.add(scanner.nextLine());
        return datos;
    }

    public int solicitarCodigoActividad() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código de la actividad a modificar: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarMenuModificacion() {
        System.out.println("\nMenu de Modificación de Actividad");
        System.out.println("1. Modificar descripción");
        System.out.println("2. Modificar día");
        System.out.println("3. Modificar mes");
        System.out.println("4. Modificar año");
        System.out.println("0. Volver al menú principal");
        System.out.print("Ingrese una opción: ");
    }

    public boolean confirmarBajaActividad() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Está seguro que desea dar de baja esta actividad? (si/no): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("si");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
