import java.util.ArrayList;
import java.util.Scanner;

public class Fila_prioridad {

    static Scanner leer = new Scanner(System.in);
    static ArrayList<Nodo> fila = new ArrayList<Nodo>();
    static int numeroDeNodos = 0;

    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("\n------------------ SIMULADOR DE FILA CON PRIORIDAD ------------------");
            System.out.println("\n0. Salir");
            System.out.println("1. Agregar Proceso");
            System.out.println("2. Atender proceso (de acuerdo al orden de prioridad)");
            System.out.println("3. Ver estado actual de la fila");
            System.out.print("Seleccione una opcion: ");
            op = leer.nextInt();

            switch (op) {
                case 0 ->
                    System.out.println("Adios...");
                case 1 ->
                    agregar();
                case 2 ->
                    atender();
                case 3 ->
                    mostrar_fila();
                default ->
                    System.out.println("Opcion invalida, vuelva a intentarlo");
            }
        } while (op != 0);
    }

    static private void agregar() {
        System.out.println("");
        int id;
        do{
            System.out.print("Ingrese id del proceso (diferente de 0): ");
            id = leer.nextInt();
            if(id <= 0){
                System.out.println("Ingrese un numero diferente");
            }
        }while(id <= 0);
        System.out.print("Ingrese prioridad del proceso: ");
        int priori = leer.nextInt();

        Nodo n = new Nodo(id, priori);
        fila.add(n);
        numeroDeNodos++;

        if (numeroDeNodos != 1) {
            fila.get(fila.size() - 2).setSiguiente(id);
        }

        System.out.println("\nAgregado correctamente");
    }

    static private void atender() {
        if (numeroDeNodos > 0) {
            Nodo n = fila.get(0);
            int prioridad = n.getPrioridad(), posNodo = 0;
            int idSiguiente; 
            
            for (int i = 1; i < fila.size(); i++) {
                if(fila.get(i).getPrioridad() > prioridad){
                    prioridad = fila.get(i).getPrioridad();
                    posNodo = i ;
                }
            }
            
            idSiguiente = fila.get(posNodo).getSiguiente();
            if(posNodo > 0){
                fila.get(posNodo -1).setSiguiente(idSiguiente);
            }
            fila.remove(posNodo);
            numeroDeNodos--;
            System.out.println("Atendido correctamente");
        }else{
            System.out.println("\nNo hay nodos para atender");
        }

    }

    static private void mostrar_fila() {
        System.out.println("");
        for (int i = 0; i < fila.size(); i++) {
            if (i != fila.size() - 1) {
                System.out.println("Proceso " + fila.get(i).getId() + ": "
                        + "prioridad de " + fila.get(i).getPrioridad()
                        + " apunta a -->" + fila.get(i).getSiguiente());
            } else {
                System.out.println("Proceso " + fila.get(i).getId() + ": "
                        + "prioridad de " + fila.get(i).getPrioridad());
            }
        }
    }
}

