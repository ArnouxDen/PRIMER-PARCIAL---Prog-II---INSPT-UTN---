package vista;

import java.util.ArrayList; 
import java.util.Scanner;

public class VScoutsPoo {

    public VScoutsPoo() {
    }

    public void menuScouts() {
    System.out.println("\nMENU SCOUTS (CASTOR/LOBATO/LOVEZNA/CAMINANTE):");
    System.out.println("1- VER ACTIVIDADES POR AÑO (EN LAS QUE ESTA INSCRIPTO)");
    System.out.println("2 - VER DATOS PERSONALES");
    System.out.print("Ingrese una opcion: ");
    Scanner scanner = new Scanner(System.in);
    int opcion = scanner.nextInt();

    if (opcion == 1) {
        String encabezado = "ACTIVIDADES - 2024";
        String[] preguntas = {"FECHA", "CODIGO(DE ACTIVIDAD)", "DESCRIPCION(DE LA ACTIVIDAD)", "ASISTENCIA(PRESENTE O AUSENTE)"};

        Tabla tabla = new Tabla(encabezado, preguntas);
        tabla.mostrarTablaScout();
        }
    }

    public void menuRovers() {
        System.out.println("\nMENU ROVERS:");
        System.out.println("1 - VER ACTIVIDADES POR AÑO (TODAS)");
        System.out.println("2 - CREAR NUEVA ACTIVIDAD");
        System.out.println("3 - MODIFICAR ACTIVIDAD");
        System.out.println("4 - DAR DE BAJA ACTIVIDAD");
        System.out.println("5 - ASIGNAR PARTICIPANTES A UNA ACTIVIDAD");
        System.out.println("6 - SCOUTS");
        System.out.println("7 - RESPONSABILIDADES");
        System.out.print("Ingrese una opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        // Aquí podrías manejar la opción ingresada según el menú
    }

    public void menuEducador() {
        System.out.println("\nMENU EDUCADOR:");
        System.out.println("1 - VER ACTIVIDADES POR AÑO (TODAS)");
        System.out.println("2 - CREAR NUEVA ACTIVIDAD");
        System.out.println("3 - MODIFICAR ACTIVIDAD");
        System.out.println("4 - DAR DE BAJA ACTIVIDAD");
        System.out.println("5 - ASIGNAR PARTICIPANTES A UNA ACTIVIDAD");
        System.out.println("6 - SCOUTS");
        System.out.println("7 - RESPONSABILIDADES");
        System.out.println("8 - AMB SCOUT");
        System.out.println("9 - ABM COMUNIDAD");
        System.out.println("10 - ABM SEDE");
        System.out.println("11 - ABM GRUPO");
        System.out.print("Ingrese una opción: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
    }

  
    public int menuInicial() {
        System.out.println("\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t Bienvenido! Ingrese la opcion deseada:");
        System.out.println("\t\t\t1: Iniciar Sesion");
        System.out.println("\t\t\t2: Crear Nuevo Usuario");
        System.out.println("\t\t\t3: Salir");
        System.out.print("Ingrese una opcion: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
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
}

/*
package vista;

import java.util.ArrayList;



/**
 * Vista principal, maneja tablas, formularios y menues. Es manejada desde Controlador -- no se comunica diractamente con modelo 
 * 
 
public class VScoutsPoo {

    public VScoutsPoo() {
    }
    
    
    
    public void prueba(){
        System.out.println("Aqui vista, reportanose");
           }
    
    public int menuInicial(){
        String encabezado = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t Bienvenidx! Ingrese la opcion deseada: \n\n";
        String[] opciones={"\t\t\t1: Iniciar Sesion","\t\t\t2: Crear nuevo usuario", "\t\t\t3: Salir"};
        
        Menu m = new Menu(encabezado, opciones);
        int rta = m.mostrar();
        return rta;
}
    
    public ArrayList formInicioSesion(){
        String encabezado = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t INICIO SESION \n\n";
        String[] preguntas={"\t\t\tApodo:", "\t\t\tContraseña:"};
         
        Formulario f = new Formulario(encabezado,preguntas);
        return f.mostrar();
        
        
    }
    public ArrayList formNuevoUsuario(){
        String encabezado = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t  NUEVO USUARIO \n\n";
        String[] preguntas={"\tApodo:", "\tContraseña:", "\tDIreccion:", "\ttelefono: " , "\tnombre de la mascota:"};
         
        Formulario f = new Formulario(encabezado,preguntas);
        return f.mostrar();
        
        
    }
    
}
*/