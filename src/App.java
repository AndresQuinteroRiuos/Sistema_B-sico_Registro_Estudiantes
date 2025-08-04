
import java.util.Scanner;

public class App {



    // Variables de alcance de clase
    static String estudianteActualNombre = "N/A";
    static double nota1 = -1, nota2 = -1, nota3 = -1;


    public static void main(String[] args) {

       // se crea el Scanner para leer datos del usuario
        Scanner sc = new Scanner(System.in);

       
        
        int opcion = 0; // se crea una variable para almacenar la opción elegida inicialmente en 0

        /* se crea un bucle do-while para mostrar el menu y realizar las acciones correspondientes
        * hasta que el usuario elija la opción 0       
        */ 

        do {

             mostrarMenu();  //se llama a la función mostrarMenu() para mostrar el menu
          
            if (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un número.");
                sc.next(); // limpiar entrada inválida
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) { //se utiliza un switch para ejecutar la acción correspondiente a la opción elegida|
                case 1:
                    if (!estudianteActualNombre.equals("N/A")) { // se comprueba si ya hay un estudiante registrado
                        System.out.print("Ya hay un estudiante registrado. ¿Desea registrar otro? (s/n): ");
                        String confirmacion = sc.nextLine();
                        if (!confirmacion.equalsIgnoreCase("s")) {// se comprueba si el usuario quiere registrar otro estudiante
                            System.out.println("Registro cancelado.");
                            break;
                        }
                    }
                    registrarEstudiante(sc);// se llama a la función registrarEstudiante() para registrar el estudiante
                    break;
                case 2:
                    mostrarInfoEstudiante(); // se llama a la función mostrarInfoEstudiante() para mostrar los datos del estudiante
                    break;
                case 3:
                    double promedio = calcularPromedioEstudiante();
                    /*se llama a la función calcularPromedioEstudiante() para calcular el promedio
                    del estudiante y se imprime el resultado                    
                    */  
                    System.out.println("Promedio de notas: " + promedio);
                    System.out.println(aprobadoEstudiante(promedio)); 
                      /*se llama a la función aprobadoEstudiante() para mostrar el resultado y definir si el estudiante aprobó o reprobó  */                 
                     
                  
                    break;
                case 4:
                    limpiarDatos();// se llama a la función limpiarDatos() para limpiar los datos del estudiante
                    System.out.println("Datos borrados. ");
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");// salir del programa y se imprime un mensaje de despedida
                    break;
                default:
                    System.out.println("Opción inválida.");// se imprime un mensaje de error si la opción elegida es inválida
            }

        } 
        while (opcion != 0);    

        sc.close();
        
    }

    static void mostrarMenu() {
        /*  se crea una función para mostrar el menu de opciones, 
        *   Imprime las opciones disponibles en consola.
        *   El usuario escoge digitando un número.   */
     
        System.out.println("\n==========================================");
        System.out.println("\n  | SISTEMA DE REGISTRO DE ESTUDIANTES | ");
        System.out.println("\n==========================================");       
        System.out.println("1. Registrar datos del estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio y mostrar aprobación");
        System.out.println("4. Borrar datos del estudiante actual");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opción: ");
    }

    static void registrarEstudiante(Scanner sc) { // se crea una función para registrar el estudiante
        String nombre;
        do {
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = sc.nextLine(); // se lee el nombre del estudiante
        } while (!validarNombre(nombre)); // se llama a la función validarNombre() para validar el nombre

        double n1 = pedirNota(sc, "Primera");// se llama a la función pedirNota() para pedir la nota1 y se guarda en la variable n1
        double n2 = pedirNota(sc, "Segunda");// se llama a la función pedirNota() para pedir la nota2 y se guarda en la variable n2
        double n3 = pedirNota(sc, "Tercera");// se llama a la función pedirNota() para pedir la nota3 y se guarda en la variable n3

        System.out.println("\nResumen del estudiante:");// se imprime un resumen del estudiante 
        System.out.println("Nombre: " + nombre);
        System.out.println("Nota 1: " + n1);
        System.out.println("Nota 2: " + n2);
        System.out.println("Nota 3: " + n3);
        System.out.print("¿Desea confirmar el registro? (s/n): ");// se imprime un mensaje para confirmar el registro
        String confirmacion = sc.nextLine(); // se lee la confirmación

        if (confirmacion.equalsIgnoreCase("s")) {// se comprueba si la confirmación es "s"
            estudianteActualNombre = nombre;// se guarda el nombre del estudiante, y las notas
            nota1 = n1;
            nota2 = n2;
            nota3 = n3;
            System.out.println("Registro confirmado.");
        } else {
            System.out.println("Registro cancelado."); // se imprime un mensaje de cancelación del registro en caso de que la confirmación sea "n"
        }
    }

    static double pedirNota(Scanner sc, String etiqueta) { // se crea una función para pedir la nota con un etiqueta y se retorna la nota
        double nota = -1; // se inicializa la nota en -1
        boolean esValida = false;// se inicializa la variable esValida en false

        do {
            System.out.print("Ingrese la " + etiqueta + " nota (0-100): "); // se imprime un mensaje para pedir la nota

            if (sc.hasNextDouble()) { // se comprueba si la  entrada es un número    
                nota = sc.nextDouble();// la nota se guarda en la variable nota
                esValida = validarNota(nota);// se llama a la función validarNota() para validar la nota y se guarda en la variable esValida
                if (!esValida) {// se comprueba si la nota es inválida q
                    System.out.println("Nota fuera de rango. Debe estar entre 0 y 100.");
                }
            } else {
                System.out.println("Entrada inválida. Debe ser un número.");
                sc.next(); //  limpiar entrada inválida
            }
        } while (!esValida);// se repite el ciclo mientras la nota sea inválida
        sc.nextLine(); // limpiar buffer
        return nota; 
    }

    static void mostrarInfoEstudiante() { // se crea una función para mostrar la información del estudiante actual 
        if (estudianteActualNombre.equals("N/A")) {
            System.out.println("No se ha registrado ningún estudiante.");
        } else {
            System.out.println("\n============================");
            System.out.println("\n  | DATOS DEL ESTUDIANTE |");
            System.out.println("\n============================");

            System.out.println("Nombre: " + estudianteActualNombre);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }
    }

    static double calcularPromedioEstudiante() {// se crea una función para calcular el promedio del estudiante  
        if (estudianteActualNombre.equals("N/A")) {// se comprueba si ya hay un estudiante registrado, se imprime un mensaje y se retorna 0
            System.out.println("No se ha registrado ningún estudiante.");
            return 0;
        }
        return (nota1 + nota2 + nota3) / 3;
    }

    static String aprobadoEstudiante(double promedio) {// se crea una función para determinar si el estudiante esta aprobado o reprobado
        return promedio >= 60 ? " Aprobado" : " Reprobado";// Devuelve " Aprobado" si el promedio es ≥ 60; si no, " Reprobado".
    }

    static void limpiarDatos() {// se crea una función para limpiar los datos del estudiante
        estudianteActualNombre = "N/A";
        nota1 = nota2 = nota3 = -1;
    }

    static boolean validarNota(double nota) {// se crea una función para validar la nota
        return nota >= 0 && nota <= 100;// Devuelve true si la nota es ≥ 0 y ≤ 100; si no, false
    }

    static boolean validarNombre(String nombre) {// se crea una función para validar el nombre
        return nombre != null && !nombre.trim().isEmpty(); // Devuelve true si el nombre no es nulo y no es una cadena vacía; si no, false
    }

}


