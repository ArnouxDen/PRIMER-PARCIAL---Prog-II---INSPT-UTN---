package vista;

/**
 * La clase Constantes presenta de forma organizada y sistematica la mayoria de
 * los mensajes que se utilizan de forma reiterada en el programa posibilitando
 * modificarlos de forma uniforme menteniendo el estilo. Se eligio final para
 * los constantes por: Inmutabilidad: Al ser final, el valor de la constante no
 * puede cambiar después de ser inicializado. Esto asegura que el mensaje de
 * error siempre será el mismo en toda la aplicación, eliminando la posibilidad
 * de que se cambie accidentalmente. Claridad: Indicar que una variable es final
 * deja claro a otros desarrolladores que esta variable es una constante y su
 * valor está destinado a permanecer igual durante toda la ejecución del
 * programa. Optimización: El compilador de Java puede realizar optimizaciones
 * adicionales para variables final porque sabe que su valor no cambiará.
 *
 */
public class Constantes {

    //Headers
    public static final String BIENVENIDA = "\tBienvenido al Sistema de gestion de actividades de Scouts Argentina \n\t ATENCIÓN: No se ha encontrado un archivo previo";
    public static final String HEADER_INICIO = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t INICIO SESION";
    public static final String HEADER_MENU_SCOUTS = "\n\t\t\tMENU SCOUTS (CASTOR/LOBATO/LOVEZNA/CAMINANTE):";
    public static final String HEADER_MENU_ROVER = "\n\t\t\tMENU ROVERS:";
    public static final String HEADER_MENU_EDUCADOR = "\n\t\t\tMENU EDUCADOR:";
    public static final String HEADER_MENU_PRINCIPAL = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t Bienvenido! Ingrese la opcion deseada:";
    public static final String HEADER_NEW_USUARIO = "\n\t\t\t\tSCOUTS ARGENTINA\n\t\t\t NUEVO USUARIO";
    public static final String HEADER_MOD_ACT = "\n\t\t\tMenu de Modificacion de Actividad";
    public static final String HEADER_ABM_SCOUTS = "\n\t\t\tMenu Altas, Bajas y Modificaciones de Scouts";
    public static final String HEADER_ABM_GRUPOS = "\n\t\t\tMenu Altas, Bajas y Modificaciones de Grupos";
    public static final String HEADER_ABM_SEDES = "\n\t\t\tMenu Altas, Bajas y Modificaciones de Sedes";
    public static final String HEADER_NEW_ACT = "\nCREAR NUEVA ACTIVIDAD";

    //Errores
    public static final String ACCESO_DENEGADO = "Acceso denegado";
    public static final String GRADUACION_NO_RECONOCIDA = "Graduación no reconocida. Intente de nuevo";
    public static final String ERR_OPC_INVALIDA = "Error: Opción inválida";
    public static final String OPERACION_CANCELADA = "Operacion cancelada.";
    public static final String ACTIVIDAD_SUSPENDIDA_MOD = "La actividad está suspendida y no puede ser modificada.";
    public static final String ACTIVIDAD_SUSPENDIDA_BAJA = "La actividad ya está suspendida y no puede ser dada de baja nuevamente.";
    public static final String ACTIVIDAD_DADA_BAJA = "Actividad dada de baja con éxito.";
    public static final String NO_SE_ENCONTRO_ACTIVIDAD = "No se encontro una actividad con el codigo ingresado.";
    public static final String SCOUT_NO_ENCONTRADO = "No se encontró un scout con el apodo ingresado.";
    public static final String ACTIVIDAD_NO_ENCONTRADA = "No se encontró una actividad con el código ingresado.";
    public static final String PRESIONE_ENTER = "Presione ENTER para continuar";
    public static final String ACTIVIDAD_ALTA_CANCELADA = "Se ha cancelado la operación de alta de actividad.";
    public static final String ACTIVIDAD_ALTA_EXITOSA = "Actividad dada de alta con exito.";
    public static final String INGRESE_NUM = "Opción inválida. Debe ingresar un numero.";
    public static final String PASS_VACIO = "\t\t\tLa contraseña no puede estar vacia. Por favor, ingrese una contraseña valida.";
    public static final String APODO_VACIO = "\t\t\tEl apodo no puede estar vacio. Por favor, ingrese un apodo valido.";
    public static final String COD_ACT_NO_FOUND = "No se encontró una actividad con el código ingresado.";
    public static final String ANIO_INVALIDO = "Ingrese un año valido (mayor o igual a 0).";
    public static final String FECHA_INVALIDA = "Fecha no válida. Por favor ingrese una fecha correcta.";
    public static final String APODO_YA_USADO = "El apodo ya fue utilizado, por favor seleccione otro:";
    //OPCIONES
    public static final String ING_OPC = "\n\t\t\tIngrese una opcion: ";
    public static final String SEL_OPC = "Seleccione una opción";
    public static final String SALIR = "\t\t\t0 - SALIR AL MENU PRINCIPAL";
    public static final String SALIR_GUARDAR = "\t\t\t3: Salir";
    public static final String PARTICIPANTE_AGREGADO = "Participante agregado con éxito a la actividad.";
    public static final String VER_DATOS = "\t\t\t2 - VER DATOS PERSONALES";
    public static final String VER_ACT = "\t\t\t1 - VER ACTIVIDADES POR AÑO";
    public static final String CREAR_ACT = "\t\t\t2 - CREAR NUEVA ACTIVIDAD";
    public static final String MOD_ACT = "\t\t\t3 - MODIFICAR ACTIVIDAD";
    public static final String BAJA_ACT = "\t\t\t4 - DAR DE BAJA ACTIVIDAD";
    public static final String ASIG_PART = "\t\t\t5 - ASIGNAR PARTICIPANTES A UNA ACTIVIDAD";
    public static final String INICIO_SESION = "\t\t\t1: Iniciar Sesion";
    public static final String CREAR_NEW_USUARIO = "\t\t\t2: Crear Nuevo Usuario";
    public static final String CONFIRMAR_OPERACION = "¿Desea confirmar la operacion? (SI/NO)";
    public static final String CONFIRMAR_BAJA = "¿Desea confirmar la baja? (SI/NO)";
    public static final String CONFIRMAR_MOD = "¿Desea confirmar la modificacion? (SI/NO)";
    public static final String ALTA_EXITOSA = "ALTA EXITOSA";
    public static final String BAJA_EXITOSA = "BAJA EXITOSA";
    public static final String VER_LISTA_DE = "\t\t\t1. VER LISTA DE ";
    public static final String DAR_ALTA_NUEVA = "\t\t\t2. DAR DE ALTA ";
    public static final String DAR_BAJA = "\t\t\t3. DAR DE BAJA ";
    public static final String MODIF_DATOS = "\t\t\t4. MODIFICAR DATOS DE ";

}
