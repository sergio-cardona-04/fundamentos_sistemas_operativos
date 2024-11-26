import java.util.Scanner;

public class Simulador_administrador_memoria {

    static Scanner leer = new Scanner(System.in);
    static int tamañoMemoria;
    static Proceso[] particiones;
    static int[] tamañoParticiones;

    public static void main(String[] args) {
        inicializar_memoria();
        menu();
    }

    static void menu() {
        int op = 0;
        do {
            System.out.println("\n0.Salir.");
            System.out.println("1.Generar proceso");
            System.out.println("2.Liberar proceso");
            System.out.println("3.Mostrar espacio en la memoria");
            System.out.print("Seleccione una opcion: ");
            op = leer.nextInt();

            switch (op) {
                case 0:
                    System.out.println("Adios...");
                    return;
                case 1:
                    generar_proceso();
                    break;
                case 2:
                    liberar_proceso();
                    break;
                case 3:
                    mostrar_memoria();
                    break;
                default:
                    System.out.println("Opcion invalida, vuelva a intentar.");
                    ;
            }
        } while (op != 0);
    }

    private static void inicializar_memoria() {
        System.out.print("Digite tamano total de la memoria (KB): ");
        tamañoMemoria = leer.nextInt();
        System.out.print("Digite cantidad de particiones: ");
        particiones = new Proceso[leer.nextInt()];
        tamañoParticiones = new int[particiones.length];
        for (int i = 0; i < particiones.length; i++) {
            System.out.print("Ingrese tamano de la particion " + (i + 1) + " (KB): ");
            tamañoParticiones[i] = leer.nextInt();
        }
    }

    private static void generar_proceso() {
        System.out.print("\nDigite id del proceso: ");
        int id = leer.nextInt();
        System.out.print("Digite tamano del proceso (KB): ");
        int tamaño = leer.nextInt();
        
        boolean espacio = false;
        for (int i = 0; i < particiones.length && espacio == false; i++) {
            if (particiones[i] == null) {
                if (tamaño < tamañoParticiones[i]) {
                    particiones[i] = new Proceso(id, tamaño);
                    espacio = true;
                    System.out.println("Proceso " + id + " almacenado en la celda " + (i + 1));
                }
            }
        }
        if(!espacio){
            System.out.println("Error al guardar el proceso");
        }
    }

    
    private static void liberar_proceso() {
        mostrar_memoria();
        System.out.println("");
        System.out.print("Ingrese el ID DEL PROCESO que se desea eliminar: ");
        int eliminar = leer.nextInt();
        
        boolean eliminado = false;
        for(int i = 0; i < particiones.length; i++){
            if(particiones[i] != null){
                if(particiones[i].getId() == eliminar){
                    particiones[i] = null;
                    eliminado = true;
                    System.out.println("\nEliminado satisfactoriamente");
                }
            }
        }
        if(!eliminado){
            System.out.println("\nNo se encontro el proceso");
        }
    }

    private static void mostrar_memoria() {
        System.out.println("\nTamano total de la memoria: " + tamañoMemoria);
        System.out.println("Numero de particiones en memoria: " + particiones.length + " \n");
        for (int i = 0; i < particiones.length; i++) {
            if(particiones[i] == null){
                System.out.println("Particion " + (i+1) + " (" + tamañoParticiones[i] + " KB): libre");
            }else{
                System.out.println("Particion " + (i+1) + " (" + tamañoParticiones[i] + " KB): proceso " + particiones[i].getId() + " ( " + particiones[i].getTamaño() + " KB)");
            }
        }
    }
}
