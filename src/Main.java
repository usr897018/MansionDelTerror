import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // La mansión del terror
        // Programación de videojuegos En Java


        //--------------- Declaración de los objetos---------------

        final int HUESO = 1;
        final int LLAVE = 2;
        final int ESCALERA = 3;
        final int PERRO = 4;

        //--------------- clase de datos para los objetos---------------

        class Objeto
        {
            int estado; // Estado del objeto
            String desc1; // Descripción para estado 1
            String desc2; // Descripción para estado 2
            int hab; // Habitación en la que se encuentra
            int lotengo; // Indica si tengo este objeto en mi inventario
        }

        //--------------- clase  de datos para las habitaciónes---------------

        class Habitacion
        {
            String desc;
            int norte;
            int sur;
            int este;
            int oeste;
        }

        //--------------- Declarasion de arrays ---------------

        Objeto[] objetos = new Objeto[5];
        Habitacion[] habitaciones = new Habitacion[10];

        //--------------- Inicialización de arrays ---------------

        for (int i = 0; i < objetos.length; i++) {
            objetos[i] = new Objeto();
        }
        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i] = new Habitacion();
        }

        //--------------- Inicialización de objetos ---------------

        //--------------- hueso ---------------

        objetos[HUESO].estado = 1;
        objetos[HUESO].desc1 = "un hueso";
        objetos[HUESO].desc2 = "un hueso";
        objetos[HUESO].hab = 2;
        objetos[HUESO].lotengo = 0;

        //--------------- llave ---------------

        objetos[LLAVE].estado = 1;
        objetos[LLAVE].desc1 = "una llave sobre la lampara";
        objetos[LLAVE].desc2 = "una llave sobre la lampara";
        objetos[LLAVE].hab = 3;
        objetos[LLAVE].lotengo = 0;

        //--------------- escalera ---------------

        objetos[ESCALERA].estado = 1;
        objetos[ESCALERA].desc1 = "una escalera";
        objetos[ESCALERA].desc2 = "una escalera";
        objetos[ESCALERA].hab = 9;
        objetos[ESCALERA].lotengo = 0;

        //--------------- perro ---------------

        objetos[PERRO].estado = 1;
        objetos[PERRO].desc1 = "un perro rabioso";
        objetos[PERRO].desc2 = "un perro comiendose un hueso";
        objetos[PERRO].hab = 9;
        objetos[PERRO].lotengo = 0;

        //--------------- Inicialización de habitaciones ---------------

        //--------------- Habitación 1 ---------------

        habitaciones[1].desc = "Estas en una pequeña habitación pintada de blanco. Junto a ti " +
                "puedes ver una cama y una mesita de noche.";
        habitaciones[1].norte = 0;
        habitaciones[1].sur = 4;
        habitaciones[1].este = 0;
        habitaciones[1].oeste = 0;

        //--------------- Habitación 2 ---------------

        habitaciones[2].desc = "Estas en una habitación pintada de verde. Junto a ti puedes ver " +
                "una cama y una mesita de noche.";
        habitaciones[2].norte = 0;
        habitaciones[2].sur = 5;
        habitaciones[2].este = 0;
        habitaciones[2].oeste = 0;

        //--------------- Habitación 3 ---------------

        habitaciones[3].desc = "Estas en el salón de la casa. Puedes ver una gran mesa rodeada " +
                "de sillas.";
        habitaciones[3].norte = 0;
        habitaciones[3].sur = 6;
        habitaciones[3].este = 0;
        habitaciones[3].oeste = 0;

        //--------------- Habitación 4 ---------------

        habitaciones[4].desc = "Estas en el pasillo.";
        habitaciones[4].norte = 1;
        habitaciones[4].sur = 7;
        habitaciones[4].este = 5;
        habitaciones[4].oeste = 0;

        //--------------- Habitación 5 ---------------

        habitaciones[5].desc = "Estas en el pasillo.";
        habitaciones[5].norte = 2;
        habitaciones[5].sur = 8;
        habitaciones[5].este = 6;
        habitaciones[5].oeste = 4;

        //--------------- Habitación 6 ---------------

        habitaciones[6].desc = "Estas en el pasillo.";
        habitaciones[6].norte = 3;
        habitaciones[6].sur = 9;
        habitaciones[6].este = 0;
        habitaciones[6].oeste = 5;

        //--------------- Habitación 7 ---------------

        habitaciones[7].desc = "Estas en el típico servicio, con sus típicas piezas.";
        habitaciones[7].norte = 4;
        habitaciones[7].sur = 0;
        habitaciones[7].este = 0;
        habitaciones[7].oeste = 0;

        //--------------- Habitación 8 ---------------

        habitaciones[8].desc = "Estas en la entrada de la casa. Puedes ver la puerta cerrada.";
        habitaciones[8].norte = 5;
        habitaciones[8].sur = 0;
        habitaciones[8].este = 0;
        habitaciones[8].oeste = 0;

        //--------------- Habitación 9 ---------------

        habitaciones[9].desc = "Estas en la cocina.";
        habitaciones[9].norte = 6;
        habitaciones[9].sur = 0;
        habitaciones[9].este = 0;
        habitaciones[9].oeste = 0;


        //---------------Inicialización del estado de juego.---------------

        //--------------- variable que indica la habitación en la que estamos---------------
        int habitacionActual = 1;
        //--------------- variable que indica cuantos objetos hay---------------
        int numeroOjetos = 4;


        //--------------- Bucle del Juego --------------------------

        String verbo, nombre;
        int i, accion;
        boolean done = false;
        Scanner datosEntrada = new Scanner(System.in);

        //--------------- Instrucciones Del Juego ---------------
        System.out.printf("\n\nBienvenido a \"La Mansión del Terror\", un juego de aventuras en el que debes escapar" +
                           "\nde una misteriosa mansión. Explora habitaciones, recoge objetos clave y utiliza comandos" +
                           "\npara interactuar con el entorno. " +
                           "\n\n   -> Moverse: Usa ir norte, ir sur, ir este, ir oeste." +
                           "\n   -> Recoger objetos: Usa coger [nombre del objeto]." +
                           "\n   -> Usar objetos: Usa usar [nombre del objeto]." +
                           "\n   -> Interactuar con elementos: Usa dar [nombre del objeto]." +
                           "\n\nTu objetivo es encontrar la llave y usarla en la puerta de la entrada para escapar.");

        while (!done) {
            //--------------- Mostramos información de la habitación.---------------

            //--------------- Descripción---------------

            System.out.printf("\n\n" + habitaciones[habitacionActual].desc);

            //--------------- Mostramos si hay algun objeto---------------

            for (i = 1; i <= numeroOjetos; i++) {
                if (objetos[i].hab == habitacionActual) {
                    System.out.printf("\nTambien puedes ver ");

                    //--------------- mostramos la descripción del objeto según su estado---------------

                    if (objetos[i].estado == 1) {
                        System.out.printf(objetos[i].desc1);
                    } else {
                        System.out.printf(objetos[i].desc2);
                    }
                }
            }

            //--------------- Mostramos las posibles salidas ---------------
            System.out.printf("\nPuedes ir hacia el: ");
            if (habitaciones[habitacionActual].norte != 0)
                System.out.printf("Norte ");
            if (habitaciones[habitacionActual].sur != 0)
                System.out.printf("Sur ");
            if (habitaciones[habitacionActual].este != 0)
                System.out.printf("Este ");
            if (habitaciones[habitacionActual].oeste != 0)
                System.out.printf("Oeste ");

            //--------------- Leemos la entrada del jugador ---------------
            System.out.printf("\n>>> ");
            verbo = datosEntrada.next();
            nombre = datosEntrada.next();

            //--------------- Procesamos la entrada del jugador ---------------

            //--------------- coger ---------------
            if (verbo.equalsIgnoreCase("coger"))
            {
                accion = 0;

                //--------------- Hueso ---------------

                if (nombre.equalsIgnoreCase("hueso") && objetos[HUESO].hab == habitacionActual) {
                    accion = 1;
                    objetos[HUESO].hab=0;
                    objetos[HUESO].lotengo=1;
                    System.out.printf("\nHas cogido el hueso.");
                }

                //--------------- Llave ---------------

                if (nombre.equalsIgnoreCase("llave") && objetos[LLAVE].hab == habitacionActual) {
                    accion = 1;

                //--------------- para coger la llave necesitamos la escalera ---------------

                    if (objetos[ESCALERA].lotengo == 1)
                    {
                        objetos[LLAVE].hab=0;
                        objetos[LLAVE].lotengo=1;
                        System.out.printf("\nTras subirte a la escalera, alcanzas la llave.");
                    }
                    else
                    {
                        System.out.printf("\nNo alcanzo la llave. Está demasiado alta.");
                    }
                }

                //--------------- Escalera ---------------

                if (nombre.equalsIgnoreCase("escalera") && objetos[ESCALERA].hab == habitacionActual) {
                    accion = 1;
                    if (objetos[PERRO].estado == 2) {
                        objetos[ESCALERA].hab = 0;
                        objetos[ESCALERA].lotengo = 1;
                        System.out.printf("\nHas cogido las escaleras.");
                    } else {
                        System.out.printf("\nEl perro gruñe y ladra y no te deja cogerlo.");
                    }
                }
                if (accion == 0)
                    System.out.printf("\nNo puedes hacer eso.");
            }

            //--------------- dar ---------------

            if (verbo.equalsIgnoreCase("dar")) {
                accion = 0;

                //--------------- Hueso ---------------

                if (nombre.equalsIgnoreCase("hueso") && objetos[HUESO].lotengo == 1 && objetos[PERRO].hab ==
                        habitacionActual) {
                    accion = 1;
                    objetos[HUESO].lotengo = 0;
                    objetos[PERRO].estado = 2;
                    System.out.printf("\nEl perro coge el hueso y se retira a comerselo tranquilamente.");
                }
                if (accion == 0)
                    System.out.printf("\nNo puedes hacer eso.");
            }

            //--------------- usar ---------------

            if (verbo.equalsIgnoreCase("usar")) {
                accion = 0;

                //--------------- Llave ---------------

                if (nombre.equalsIgnoreCase("llave") && objetos[LLAVE].lotengo == 1 && habitacionActual == 8) {
                    accion = 1;
                    System.out.printf("\nENHORABUENA!!! Has escapado de la mansión del terror.");
                    done = true;
                }
                if (accion == 0)
                    System.out.printf("\nNo puedes hacer eso.");
            }

            //--------------- ir ---------------

            if (verbo.equalsIgnoreCase("ir")) {
                accion = 0;

                //--------------- norte ---------------

                if (nombre.equalsIgnoreCase("norte") && habitaciones[habitacionActual].norte != 0) {
                    accion = 1;
                    habitacionActual = habitaciones[habitacionActual].norte;
                }

                //--------------- sur ---------------

                if (nombre.equalsIgnoreCase("sur") && habitaciones[habitacionActual].sur != 0) {
                    accion = 1;
                    habitacionActual = habitaciones[habitacionActual].sur;
                }

                //--------------- este ---------------

                if (nombre.equalsIgnoreCase("este") && habitaciones[habitacionActual].este != 0) {
                    accion = 1;
                    habitacionActual = habitaciones[habitacionActual].este;
                }

                //--------------- oeste ---------------

                if (nombre.equalsIgnoreCase("oeste") && habitaciones[habitacionActual].oeste != 0) {
                    accion = 1;
                    habitacionActual = habitaciones[habitacionActual].oeste;
                }
                if (accion == 0)

                    System.out.printf("\nNo puedes hacer eso.");

            }
        }
    }
}