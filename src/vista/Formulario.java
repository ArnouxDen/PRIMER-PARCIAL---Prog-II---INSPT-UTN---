package vista;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Comunidad;
import modelo.Grupo;
import modelo.Scout;
import modelo.Sede;

/**
 * La clase Formulario organiza los formularios utilizxados en la vista. 
 * Como comportamiento general, todos devuelven un arrayList de un tipo determinado
 * 
 */
public class Formulario {

    private String encabezado;
    private String preguntas[];
    private final ArrayList<String> respuestas = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    //CONSTRUCTORES
    public Formulario(String encabezado, String[] preguntas) {
        this.encabezado = encabezado;
        this.preguntas = preguntas;
    }

    public Formulario() {
    }

    public ArrayList<String> inicioSesion() {
        ArrayList<String> datos = new ArrayList<>();

        System.out.println(Constantes.HEADER_INICIO);
        String apodo;
        do {
            System.out.print("\t\t\tApodo: ");
            apodo = scanner.nextLine().trim();
            if (apodo.isEmpty()) {
                System.out.println(Constantes.APODO_VACIO);
            }
        } while (apodo.isEmpty());
        datos.add(apodo);
        String contraseña;
        do {
            System.out.print("\t\t\tContraseña: ");
            contraseña = scanner.nextLine().trim();
            if (contraseña.isEmpty()) {
                System.out.println(Constantes.PASS_VACIO);
            }
        } while (contraseña.isEmpty());
        datos.add(contraseña);
        return datos;
    }

    public ArrayList<String> nuevoUsuario() {
        ArrayList<String> datos = new ArrayList<>();
        System.out.println(Constantes.HEADER_NEW_USUARIO);
        System.out.print("\tApodo: ");
        datos.add(scanner.nextLine());
        System.out.print("\tContraseña: ");
        datos.add(scanner.nextLine());
        System.out.print("\tDireccion: ");
        datos.add(scanner.nextLine());
        System.out.print("\tTelefono: ");
        datos.add(scanner.nextLine());
        //System.out.print("\tNombre de la mascota: "); ///??????
        //datos.add(scanner.nextLine());
        return datos;

    }

    public ArrayList<String> nuevaActividad() {

        ArrayList<String> datos = new ArrayList<>();
        System.out.println(Constantes.HEADER_NEW_ACT);
        System.out.print("Descripcion de la actividad: ");
        datos.add(scanner.nextLine());

        int dia = 0, mes = 0, anio = 0;
        boolean fechaValida = false;

        while (!fechaValida) {
            try {
                System.out.print("Dia: ");
                dia = Integer.parseInt(scanner.nextLine());

                System.out.print("Mes: ");
                mes = Integer.parseInt(scanner.nextLine());

                System.out.print("Año: ");
                anio = Integer.parseInt(scanner.nextLine());

                LocalDate fecha = LocalDate.of(anio, mes, dia);
                fechaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese números válidos para el día, mes y año.");
            } catch (DateTimeException e) {
                System.out.println(Constantes.FECHA_INVALIDA);
            }
        }

        datos.add(String.valueOf(dia));
        datos.add(String.valueOf(mes));
        datos.add(String.valueOf(anio));
        return datos;
    }

    public ArrayList<String> agregarParticipante() {
        ArrayList<String> datos = new ArrayList<>();
        System.out.print("Ingrese el apodo del participante: ");
        datos.add(scanner.nextLine());
        System.out.print("Ingrese la responsabilidad del participante: ");
        datos.add(scanner.nextLine());
        // System.out.print("Ingrese alguna observación: ");
        //datos.add(scanner.nextLine());
        return datos;
    }

    public ArrayList<String> mostrar() {

        System.out.println(encabezado);

        for (String pregunta : preguntas) {
            System.out.println(pregunta);
            respuestas.add(scanner.nextLine());
        }

        return respuestas;
    }

    public ArrayList altaScout(ArrayList<Scout> listaScouts) {
        ArrayList<String> datos = new ArrayList<>();
        System.out.print("Ingrese el apodo del/a nuevo/a Scout: ");
        String apodo = scanner.nextLine();
        int flag = 0;
        do {
            for (Scout sc : listaScouts) {
                flag = 0;
                if (sc.getApodo().equals(apodo)) {
                    System.out.println(Constantes.APODO_YA_USADO);
                    apodo = scanner.nextLine();
                    flag = 1;
                }
            } 
        } while (flag == 1);
        datos.add(apodo);
        System.out.print("Ingrese el nombre del/a nuevo/a Scout: ");
        datos.add(scanner.nextLine());
        System.out.print("Ingrese el apellido del/a nuevo/a Scout: ");
        datos.add(scanner.nextLine());
        
        String grad=null;
        do{
        System.out.println("Seleccione la graduacion de ingreso: ");
        System.out.println("1-Castor\t2-Lobato\t3-Lobezna\n4-Scout \t 5-Caminante\t6-Rover\n8-Educador/a");
        grad = scanner.nextLine();
        }while(!grad.equalsIgnoreCase("Castor")&&!grad.equalsIgnoreCase("Lobato")&&
                !grad.equalsIgnoreCase("Lobezna")&&!grad.equalsIgnoreCase("Scout")&&
                !grad.equalsIgnoreCase("Caminante")&&!grad.equalsIgnoreCase("Rover")&&
                !grad.equalsIgnoreCase("Educador/a")&&!grad.equalsIgnoreCase("Educador")&&
                !grad.equalsIgnoreCase("Educadora"));
       datos.add(grad);
        
        return datos;
    }

    public ArrayList bajaScout() {
        ArrayList<String> datosBaja = new ArrayList();
        System.out.println("Ingrese el CODIGO del scout que desea dar de baja:");
        datosBaja.add(scanner.nextLine());
        System.out.println("Ingrese el APODO del Scout que desea dar de baja");
        datosBaja.add(scanner.nextLine());
        return datosBaja;
    }

    public ArrayList modificacionDatosScout(Scout scout) {
        ArrayList<String> datosModificacionScout = new ArrayList();
        String nombre = scout.getNombre();
        String apellido = scout.getApellido();
        String graduacion = scout.getGraduacion();
        String sede = scout.getSede().getNombre();

        System.out.println("cod:" + scout.getCodigo());
        System.out.println("Apodo:" + scout.getApodo());
        System.out.println("Nombre:" + scout.getNombre());
        System.out.println("Apellido:" + scout.getApellido());
        System.out.println("Graduacion" + scout.getGraduacion());
        System.out.println("Grupo:" + scout.getGrupo().getDenominacion());
        System.out.println("Comunidad:" + scout.getComunidad().getActPrincipal());
        System.out.println("Sede:" + scout.getSede().getNombre());
        System.out.println("____________________________________________________");
        int op = 0;
        do {
            System.out.println(Constantes.SEL_OPC);
            System.out.println("1-Corregir Nombre \n 2-Corregir Apellido\n3-modificar Graduacion\n4-modificar Sede ");
            op = Integer.parseInt(scanner.nextLine());
        } while (op < 1 || op > 4);
        switch (op) {
            case 1:
                System.out.println("Ingrese nuevo nombre");
                nombre = scanner.nextLine();
                break;
            case 2:
                System.out.println("Ingrese nuevo Apellido");
                apellido = scanner.nextLine();
                break;
            case 3:
                System.out.println("Ingrese nueva Graduacion");
                graduacion = scanner.nextLine();
                break;
            case 4:
                System.out.println("Ingrese el CODIGO de la nueva Sede"); 
                sede = scanner.nextLine();
                break;
        }

        System.out.println("cod:" + scout.getCodigo());
        System.out.println("Apodo:" + scout.getApodo());
        System.out.println("Nombre:" + nombre);
        System.out.println("Apellido:" + apellido);
        System.out.println("Graduacion" + graduacion);
        System.out.println("Grupo:" + scout.getGrupo().getDenominacion());
        System.out.println("Comunidad:" + scout.getComunidad().getActPrincipal());
        System.out.println("Sede:" + sede);

        System.out.println(Constantes.CONFIRMAR_OPERACION);
        if (scanner.nextLine().toLowerCase().equals("si")) {
            datosModificacionScout.add(scout.getApodo());
            datosModificacionScout.add(nombre);
            datosModificacionScout.add(apellido);
            datosModificacionScout.add(graduacion);
            datosModificacionScout.add(sede);
        } else {
            System.out.println(Constantes.OPERACION_CANCELADA);
        }
        return datosModificacionScout;
    }

    public ArrayList altaGrupo() {
        ArrayList<String> datosAltaGrupo = new ArrayList();
        System.out.println("Para dar de alta un nuevo grupo Scout ingrese su DENOMINACION:");
        String denominacion = scanner.nextLine();
        datosAltaGrupo.add(denominacion);
        return datosAltaGrupo;
    }

    public ArrayList bajaGrupo() {

        ArrayList<String> datosBajaGrupo = new ArrayList();
        System.out.println("Para dar de baja un grupo Scout existente ingrese su CODIGO:");
        String codigo = scanner.nextLine();
        datosBajaGrupo.add(codigo);
        System.out.println("Ingrese la denominacion del grupo a dar de baja:");
        String denominacion = scanner.nextLine();
        datosBajaGrupo.add(denominacion);
        return datosBajaGrupo;
    }

    public ArrayList modificacionDatosGrupo(ArrayList<Grupo> listaGrupos) {
        Grupo grupo = null;
        int cod = 0;
        ArrayList<String> datosModificacionGrupo = new ArrayList();
        while (grupo == null) {
            System.out.println("Ingrese el CODIGO del grupo a modificar");
            cod = Integer.parseInt(scanner.nextLine());

            for (Grupo g : listaGrupos) {
                if (g.getCodigo() == cod) {
                    grupo = g;
                }
            }
            if (grupo == null) {
                System.out.println("Grupo no encontrado");
            }
        }
        System.out.println("cod:" + grupo.getCodigo());
        System.out.println("Deniminacion:" + grupo.getDenominacion());
        System.out.println("____________________________________________________");

        System.out.println("Ingrese nueva denominacion para el grupo:");
        String denominacion = scanner.nextLine();
        System.out.println(Constantes.CONFIRMAR_OPERACION);
        if (scanner.nextLine().toLowerCase().equals("si")) {
            datosModificacionGrupo.add(String.valueOf(cod));
            datosModificacionGrupo.add(denominacion);
        } else {
            System.out.println(Constantes.OPERACION_CANCELADA);
        }

        return datosModificacionGrupo;
    }

    public ArrayList altaSede() {
        ArrayList<String> datosAltaSede = new ArrayList();
        System.out.println("Para dar de alta una nueva Sede Scout ingrese su NOMBRE:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la direccion de la sede:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese la provincia:");
        String provincia = scanner.nextLine();
        System.out.println("Ingrese la localidad:");
        String localidad = scanner.nextLine();

        datosAltaSede.add(nombre);
        datosAltaSede.add(direccion);
        datosAltaSede.add(provincia);
        datosAltaSede.add(localidad);

        return datosAltaSede;
    }

    public ArrayList bajaSede() {
        ArrayList<String> datosBajaSede = new ArrayList();
        System.out.println("Para dar de baja una sede Scout existente ingrese su CODIGO:");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese el nombre de la sede a dar de baja:");
        String nombre = scanner.nextLine();

        System.out.println(Constantes.CONFIRMAR_BAJA);
        if (scanner.nextLine().toLowerCase().equals("si")) {
            datosBajaSede.add(codigo);
            datosBajaSede.add(nombre);
        } else {
            System.out.println(Constantes.OPERACION_CANCELADA);
        }
        return datosBajaSede;

    }

    public ArrayList modificacionDatosSede(ArrayList<Sede> listaSedes) {
        Sede sede = null;
        int cod = 0;
        ArrayList<String> datosModificacionSede = new ArrayList();
        while (sede == null) {
            System.out.println("Ingrese el CODIGO de la Sede a modificar");
            cod = Integer.parseInt(scanner.nextLine());

            for (Sede s : listaSedes) {
                if (s.getCodigo() == cod) {
                    sede = s;
                }
            }
            if (sede == null) {
                System.out.println("Sede no encontrada");
            }
        }
        String nombre = sede.getNombre();
        String direccion = sede.getDireccion();
        String provincia = sede.getProvincia();
        String localidad = sede.getLocalidad();

        System.out.println("cod:" + sede.getCodigo());
        System.out.println("Nombre:" + sede.getNombre());
        System.out.println("Direccion:" + sede.getDireccion());
        System.out.println("Provincia" + sede.getProvincia());
        System.out.println("Localidad:" + sede.getLocalidad());
        System.out.println("____________________________________________________");
        int op = 0;
        do {
            System.out.println(Constantes.SEL_OPC);
            System.out.println("1-Corregir Nombre \n 2-Modificar direccion\n3-Modificar provincia\n4-Modificar localidad");
            op = Integer.parseInt(scanner.nextLine());
        } while (op < 1 || op > 4);
        switch (op) {
            case 1:
                System.out.println("Ingrese nuevo nombre");
                nombre = scanner.nextLine();
                break;
            case 2:
                System.out.println("Ingrese nueva direccion");
                direccion = scanner.nextLine();

            case 3:
                System.out.println("Ingrese nueva provincia");
                provincia = scanner.nextLine();

            case 4:
                System.out.println("Ingrese nueva localidad");
                localidad = scanner.nextLine();
                break;
        }

        System.out.println("cod:" + sede.getCodigo());
        System.out.println("Nombre:" + nombre);
        System.out.println("Direccion:" + direccion);
        System.out.println("Provincia:" + provincia);
        System.out.println("Localidad:" + localidad);

        System.out.println(Constantes.CONFIRMAR_OPERACION);
        if (scanner.nextLine().toLowerCase().equals("si")) {
            datosModificacionSede.add(String.valueOf(cod));
            datosModificacionSede.add(nombre);
            datosModificacionSede.add(direccion);
            datosModificacionSede.add(provincia);
            datosModificacionSede.add(localidad);
        } else {
            System.out.println(Constantes.OPERACION_CANCELADA);
        }
        return datosModificacionSede;

    }

    public ArrayList altaComunidad() {
        ArrayList<String> datosAltaComunidad = new ArrayList();
        System.out.println("Para dar de alta una nueva Comunidad Scout ingrese su actividad principal:");
        String actPrincipal = scanner.nextLine();
        datosAltaComunidad.add(actPrincipal);
        return datosAltaComunidad;
    }

    public ArrayList bajaComunidad() {
        ArrayList<String> datosBajaComunidad = new ArrayList();
        System.out.println("Para dar de baja una Comunidad Scout existente ingrese su CODIGO:");
        String codigo = scanner.nextLine();

        System.out.println("Ingrese la actividad principal de la comunidad a dar de baja:");
        String actPrincipal = scanner.nextLine();

        System.out.println(Constantes.CONFIRMAR_BAJA);
        if (scanner.nextLine().toLowerCase().equals("si")) {
            datosBajaComunidad.add(codigo);
            datosBajaComunidad.add(actPrincipal);
        } else {
            System.out.println(Constantes.OPERACION_CANCELADA);
        }

        return datosBajaComunidad;

    }

    public ArrayList modificacionDatosComunidad(ArrayList<Comunidad> listaComunidades) {
        Comunidad comunidad = null;
        int num = 0;
        ArrayList<String> datosModificacionComunidad = new ArrayList();
        while (comunidad == null) {
            System.out.println("Ingrese el CODIGO de la comunidad a modificar");
            num = Integer.parseInt(scanner.nextLine());

            for (Comunidad c : listaComunidades) {
                if (c.getNumero() == num) {
                    comunidad = c;
                }
            }
            if (comunidad == null) {
                System.out.println("Comunidad no encontrada");
            }
        }
        System.out.println("num:" + comunidad.getNumero());
        System.out.println("Actividad Principal:" + comunidad.getActPrincipal());
        System.out.println("____________________________________________________");

        System.out.println("Ingrese nueva actividad Principal para la comunidad:");
        String actPrincipal = scanner.nextLine();
        System.out.println(Constantes.CONFIRMAR_OPERACION);
        if (scanner.nextLine().toLowerCase().equals("si")) {
            datosModificacionComunidad.add(String.valueOf(num));
            datosModificacionComunidad.add(actPrincipal);
        } else {
            System.out.println(Constantes.OPERACION_CANCELADA);
        }
        return datosModificacionComunidad;
    }
}
