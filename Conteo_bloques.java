import java.util.Scanner;

public class Conteo_bloques {

    static Scanner leer = new Scanner(System.in);
    static byte arreglo[][] = new byte[8][8];
    static boolean celdasVisitadas[][] = new boolean[8][8];
    static int numeroDeBloques = 0;

    public static void main(String[] args) {
        iniciar_valores();
        mostrar_arreglo();
        contar_bloques();
        System.out.println("Numero de bloques: " + numeroDeBloques);
    }
    
        private static void mostrar_arreglo() {
        System.out.println("Arreglo: ");
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                System.out.print(arreglo[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }

    private static void contar_bloques() {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[i].length; j++) {
                if (arreglo[i][j] == 1 && !celdasVisitadas[i][j]) {
                    busqueda_profundidad(i, j);
                    numeroDeBloques++; 
                }
            }
        }
    }

    private static void busqueda_profundidad(int x, int y) {
        if (x < 0 || y < 0 || x >= arreglo.length || y >= arreglo[0].length) {
            return;
        }
        
        if (celdasVisitadas[x][y] || arreglo[x][y] == 0) {
            return;
        }
        
        celdasVisitadas[x][y] = true;
        busqueda_profundidad(x - 1, y); 
        busqueda_profundidad(x + 1, y); 
        busqueda_profundidad(x, y - 1); 
        busqueda_profundidad(x, y + 1); 
    }

    private static void iniciar_valores() {
        arreglo[1][1] = 1;
        arreglo[1][2] = 1;
        arreglo[2][1] = 1;
        arreglo[2][2] = 1;
        arreglo[3][1] = 1;
        arreglo[3][2] = 1;

        arreglo[0][5] = 1;
        arreglo[0][6] = 1;
        arreglo[0][7] = 1;
        arreglo[1][5] = 1;
        arreglo[1][6] = 1;
        arreglo[1][7] = 1;

        arreglo[5][4] = 1;
        arreglo[5][5] = 1;
        arreglo[6][4] = 1;
        arreglo[6][5] = 1;
    }
}
