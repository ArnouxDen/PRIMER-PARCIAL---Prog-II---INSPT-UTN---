

##PRIMER PARCIAL - PROGRAMACIÓN II ORIENTADA A OBJETOS
##fecha de entrega: 25/06/2024 19:00

##PARTICIPANTES:
    Daiana Carolina Denise Decima
    DNI:40035462

    Federico Manuel Nadal Viñals
    DNI: 35094004


##COMISION:2.603

##DOCENTES:Diego Corsi y Matías Avalos

##CONSIGNA:
Desarrolle un sistema para gestionar la información de los jóvenes que realizan el trayecto scout, teniendo en cuenta que:

     Un scout se define por su apodo (único), su nombre y apellidos, y su graduación scout (Castor, Lobato y Lobezna, Scout, Caminante, Rover o Educador/a).
     Existen varias sedes, cada una se define por su código de sede, nombre y ubicación.
     Hay que tener en cuenta que existen diferentes Grupos de Scouts, y cada uno se define por un código de grupo y denominación.
     Los scouts están agrupados en comunidades, siendo significativa para cada una de éstas, el número de comunidad y la actividad principal que realiza.
     Se desea controlar las actividades que realizan los scouts, definidas por el código de actividad y descripción.
 
 Consideraciones de diseño: 
     Un scout pertenece a un único grupo y a una única comunidad, durante todo el trayecto scout. A una comunidad pertenecen scouts de diferentes grupos, sin haber relación entre comunidades y grupos.
     Los scouts de una misma comunidad pueden estar destinados en diferentes sedes, es decir, una comunidad puede estar ubicada en varias sedes, y en una sede puede haber varias comunidades. Eso sí, un scout sólo está en una sede.
     Un scout realiza varias actividades a lo largo de su paso por el trayecto scout. Un misma actividad puede ser realizada por más de un scout (con independencia de la comunidad), siendo significativa la fecha de realización.
     Al sistema podrán acceder tres tipos de usuarios: scouts (que sólo lo podrán consultar), rovers (que administrarán a los scouts y las actividades) y educadores (que administrarán todo).

Para ello:
     Analice los requerimientos anteriores
     Determine los objetos requeridos para implementar ese sistema
     Establezca los atributos que deben tener estos objetos
     Fije los comportamientos que exhibirán estos objetos
     Especifique la forma en que los objetos deben interactuar entre sí para cumplir con los equerimientos del sistema

    El sistema deberá utilizar abstracción, encapsulamiento, herencia, polimorfismo y persistencia (no BD).
    La E/S del sistema será exclusivamente por consola (no GUI).
    Se deberán subir a GitLab o GitHub el ejecutable (en formato jar), el código fuente, la documentación (generada con javadoc) y los diagramas UML de caso-uso, de clases y uno de secuencia (generados con http://plantuml.com/es o http://www.planttext.com y grabados en formato png).


    ##DIAGRAMAS UML
    @startuml
        left to right direction
        actor "usr Nivel-1 \n(Castor/Lobato/Lobezna/Caminante)" as s
        package  {
        actor "usr Nivel 3 (Educador)" as e
        actor "usr Nivel-2" (Rover)" as r
        
        }
        package Vista {

        usecase "ver datos personales" as UC0
        usecase "ver Actividades en que participa" as UC1
        usecase "ver Actividades (todas)" as UC2
        (tomar asistencia).> (UC2)  : extends
        usecase "ABM actividades" as UC3
        usecase "Asignar participantes en act." as UC4
        usecase "ABM scouts" as UC5
        usecase "ABM grupos" as UC6
        usecase "ABM sedes" as UC7
        usecase "ABM comunidades" as UC8
        }

        s --> UC0
        s --> UC1
        r --> UC2
        r --> UC3
        r --> UC4
        e --> UC2
        e --> UC3
        e --> UC4
        e --> UC5
        e --> UC6
        e --> UC7
        e --> UC8

        @enduml

##DIAGRAMA BASICO DEL MODELO 
@startuml

title ScoutsPoo

class Scout {
-String apodo
-String nombre
-string apellido
-Rama graduacion

}

class Sede{
-int codigo
-String Nombre
-Ubicacion ubicacion
}

class Participante {
-String Responsabilidades
-String Asistencia
}

class Usuario{
-Contraseña
}

class Comunidad{
-int numero
-String actPrincipal
}

class Grupo{
-int codigo
-String denominacion
}

class Actividad{
-int codigo
-String descripcion
-Fecha fecha
}
Usuario --|> Scout
Participante --|> Scout
Participante --> Actividad
Sede o--Scout
Grupo o--Scout
Comunidad o--Scout

@enduml




    



