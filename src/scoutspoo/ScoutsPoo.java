/*
                    PRIMER PARCIAL (Límite para la entrega: 18/06/2024 – 19:00)
                                              reprogramado: 25/06/2024  -19:00

Scouts de Argentina (scouts.org.ar)

Desarrolle un sistema para gestionar la información de los jóvenes que realizan el trayecto scout,
teniendo en cuenta que:

     Un scout se define por su apodo (único), su nombre y apellidos, y su graduación scout (Castor,
Lobato y Lobezna, Scout, Caminante, Rover o Educador/a).
     Existen varias sedes, cada una se define por su código de sede, nombre y ubicación.
     Hay que tener en cuenta que existen diferentes Grupos de Scouts, y cada uno se define por un
código de grupo y denominación.
     Los scouts están agrupados en comunidades, siendo significativa para cada una de éstas, el número
de comunidad y la actividad principal que realiza.
     Se desea controlar las actividades que realizan los scouts, definidas por el código de actividad y
descripción.
Consideraciones de diseño: 
     Un scout pertenece a un único grupo y a una única comunidad, durante todo el trayecto scout. A una
comunidad pertenecen scouts de diferentes grupos, sin haber relación entre comunidades y grupos.
     Los scouts de una misma comunidad pueden estar destinados en diferentes sedes, es decir, una
comunidad puede estar ubicada en varias sedes, y en una sede puede haber varias comunidades.
Eso sí, un scout sólo está en una sede.
     Un scout realiza varias actividades a lo largo de su paso por el trayecto scout. Un misma actividad
puede ser realizada por más de un scout (con independencia de la comunidad), siendo significativa
la fecha de realización.
     Al sistema podrán acceder tres tipos de usuarios: scouts (que sólo lo podrán consultar), rovers (que
administrarán a los scouts y las actividades) y educadores (que administrarán todo).
Para ello:
     Analice los requerimientos anteriores
     Determine los objetos requeridos para implementar ese sistema
     Establezca los atributos que deben tener estos objetos
     Fije los comportamientos que exhibirán estos objetos
     Especifique la forma en que los objetos deben interactuar entre sí para cumplir con los
requerimientos del sistema

    El sistema deberá utilizar abstracción, encapsulamiento, herencia, polimorfismo y persistencia (no BD).
La E/S del sistema será exclusivamente por consola (no GUI).
Se deberán subir a GitLab o GitHub el ejecutable (en formato jar), el código fuente, la documentación
(generada con javadoc) y los diagramas UML de caso-uso, de clases y uno de secuencia (generados con
http://plantuml.com/es o http://www.planttext.com y grabados en formato png)
 */
package scoutspoo;

import controlador.CScoutPoo;

/**
 *
 * @authors Fd && DD
 */
public class ScoutsPoo {

    /**
     * @param L
     */
    public static void main(String[] args) {
        CScoutPoo ctrl = new CScoutPoo(); 
        ctrl.abrir();
        ctrl.run();
        ctrl.guardar();
        // TODO code application logic here
    }
    
}
