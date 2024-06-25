package vista;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La clase Menu agrupa y organiza los menu utilizados en la vista del progrma.
 * como comportamiento general presentan ocpiones y devuelven un int
 *
 */
public class Menu {

    Scanner scanner = new Scanner(System.in);

    public Menu() {

    }

    public int inicio() {
        System.out.println(Constantes.HEADER_MENU_PRINCIPAL);
        System.out.println(Constantes.INICIO_SESION);
        System.out.println(Constantes.CREAR_NEW_USUARIO);
        System.out.println(Constantes.SALIR_GUARDAR);
        System.out.print(Constantes.ING_OPC);
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception InputMismatchException) {
                System.out.println(Constantes.ERR_OPC_INVALIDA);
                System.out.print(Constantes.ING_OPC);
            }
        } while (opcion == 0 || opcion > 3);
        return opcion;
    }

    // POR GRADUACION:
    public int opcionesScout() {
        int opcion = 0;
        System.out.println(Constantes.HEADER_MENU_SCOUTS);
        System.out.println(Constantes.VER_ACT);
        System.out.println(Constantes.VER_DATOS);
        System.out.println(Constantes.SALIR);
        do {
            System.out.print(Constantes.ING_OPC);
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 0 || opcion > 2) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                }
            } catch (Exception e) {
                System.out.println(Constantes.INGRESE_NUM);
                opcion = -1;
            }
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }

    public int opcionesRover() {
        int opcion = 0;
        System.out.println(Constantes.HEADER_MENU_ROVER);
        System.out.println(Constantes.VER_ACT);
        System.out.println(Constantes.CREAR_ACT);
        System.out.println(Constantes.MOD_ACT);
        System.out.println(Constantes.BAJA_ACT);
        System.out.println(Constantes.ASIG_PART);
        System.out.println(Constantes.SALIR);
        do {
            System.out.print(Constantes.ING_OPC);
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 0 || opcion > 5) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                }
            } catch (Exception e) {
                System.out.println(Constantes.INGRESE_NUM);
                opcion = -1;
            }
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    public int opcionesEducador() {
        int opcion = -1;
        while (opcion < 0 || opcion > 9) {
            System.out.println(Constantes.HEADER_MENU_EDUCADOR);
            System.out.println(Constantes.VER_ACT);
            System.out.println(Constantes.CREAR_ACT);
            System.out.println(Constantes.MOD_ACT);
            System.out.println(Constantes.BAJA_ACT);
            System.out.println(Constantes.ASIG_PART);
            System.out.println("\t\t\t6 - ALTA/BAJA/MODIFICACION DE SCOUTS");
            System.out.println("\t\t\t7 - ALTA/BARA/MODIFICACION DE GRUPOS");
            System.out.println("\t\t\t8 - ALTA/BAJA/MODIFICACION DE SEDES");
            System.out.println("\t\t\t9 - ALTA/BAJA/MODIFICACION DE COMUNIDADES");
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ING_OPC);
            try {
                opcion = scanner.nextInt();
                if (opcion < 0 || opcion > 9) {
                    System.out.println(Constantes.ERR_OPC_INVALIDA);
                    scanner.next();
                }
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INGRESE_NUM);
                scanner.next();
            }
        }
        return opcion;
    }

    public int opcionesModificacionActividad() {
        int opcion = 0;
        boolean inputValido = false;
        while (!inputValido) {
            System.out.println(Constantes.HEADER_MOD_ACT);
            System.out.println("\t\t\t1. Modificar descripcion");
            System.out.println("\t\t\t2. Modificar dia");
            System.out.println("\t\t\t3. Modificar mes");
            System.out.println("\t\t\t4. Modificar año");
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ING_OPC);
            try {
                opcion = scanner.nextInt();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INGRESE_NUM);
                scanner.nextLine();
            }
        }
        return opcion;
    }

    public int opcionesAbmScout() {
        int opcion = 0;
        boolean inputValido = false;
        while (!inputValido) {
            System.out.println(Constantes.HEADER_ABM_SCOUTS);
            System.out.println(Constantes.VER_LISTA_DE + "SCOUTS");
            System.out.println(Constantes.DAR_ALTA_NUEVA + "UN NUEVO SCOUT");
            System.out.println(Constantes.DAR_BAJA + "UN SCOUT");
            System.out.println(Constantes.MODIF_DATOS + "UN SCOUT");
            System.out.print(Constantes.ING_OPC);
            try {
                opcion = scanner.nextInt();
                inputValido = true; // Si se ejecuta sin lanzar excepción, la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INGRESE_NUM);
                scanner.nextLine(); // Limpiar el búfer del scanner
            }
        }
        return opcion;

    }

    public int opcionesAbmGrupos() {
        int opcion = 0;
        boolean inputValido = false;
        while (!inputValido) {
            System.out.println("\nMenu Altas, Bajas y Modificaciones de Grupos");
            System.out.println(Constantes.VER_LISTA_DE + "GRUPOS");
            System.out.println(Constantes.DAR_ALTA_NUEVA + "UN NUEVO GRUPO");
            System.out.println(Constantes.DAR_BAJA + "UN GRUPO");
            System.out.println(Constantes.MODIF_DATOS + "UN GRUPO");
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ING_OPC);
            try {
                opcion = scanner.nextInt();
                inputValido = true; // Si se ejecuta sin lanzar excepción, la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INGRESE_NUM);
                scanner.nextLine(); // Limpiar el búfer del scanner
            }
        }
        return opcion;
    }

    public int opcionesAbmSede() {
        int opcion = 0;
        boolean inputValido = false;
        while (!inputValido) {
            System.out.println(Constantes.HEADER_ABM_SEDES);
            System.out.println(Constantes.VER_LISTA_DE + "SEDES");
            System.out.println(Constantes.DAR_ALTA_NUEVA + "UNA NUEVA SEDE");
            System.out.println(Constantes.DAR_BAJA + "UNA SEDE");
            System.out.println(Constantes.MODIF_DATOS + "UNA SEDE");
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ING_OPC);
            try {
                opcion = scanner.nextInt();
                inputValido = true; // Si se ejecuta sin lanzar excepción, la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INGRESE_NUM);
                scanner.nextLine(); // Limpiar el búfer del scanner
            }
        }
        return opcion;

    }

    public int opcionesAbmComunidad() {
        int opcion = 0;
        boolean inputValido = false;
        while (!inputValido) {
            System.out.println("\nMenu Altas, Bajas y Modificaciones de Comunidades");
            System.out.println(Constantes.VER_LISTA_DE + "COMUNIDADES");
            System.out.println(Constantes.DAR_ALTA_NUEVA + "UNA NUEVA COMUNIDAD");
            System.out.println(Constantes.DAR_BAJA + "UNA COMUNIDAD");
            System.out.println(Constantes.MODIF_DATOS + "UNA COMUNIDAD");
            System.out.println(Constantes.SALIR);
            System.out.print(Constantes.ING_OPC);
            try {
                opcion = scanner.nextInt();
                inputValido = true; // Si se ejecuta sin lanzar excepción, la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println(Constantes.INGRESE_NUM);
                scanner.nextLine(); // Limpiar el búfer del scanner
            }
        }
        return opcion;
    }
}
/*
    //FUNCIONES AUXILIARES

    public int mostrar() {
        Scanner s = new Scanner(System.in);
        System.out.println(encabezado);
        for (String op : opciones) {
            System.out.println(op);
        }

        int respuesta;
        do {
            System.out.print("Ingrese una opcion valida: ");
            respuesta = s.nextInt();
        } while (respuesta < 1 || respuesta > opciones.length);

        return respuesta;
    }
}
 */
