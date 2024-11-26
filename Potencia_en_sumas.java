import java.util.Scanner;

public class Potencia_en_sumas {
    
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("------------------- POTENCIA A BASE DE SUMAS -------------------");
        System.out.print("Ingrese la base: ");
        int base = leer.nextInt();
        System.out.print("Ingrese la altura: ");
        int exponente = leer.nextInt();
        int resultado = potencia(base, exponente);
        System.out.println("Resultado: " + resultado);
    }

    private static int sumaRepetida(int a, int b) {
        if (b == 0) {
            return 0; 
        }
        return a + sumaRepetida(a, b - 1);
    }

    public static int potencia(int base, int exp) {
        if (exp == 0) {
            return 1; 
        }
        if (exp == 1) {
            return base; 
        }
        int resultadoPrevio = potencia(base, exp - 1); 
        return sumaRepetida(base, resultadoPrevio);
    }
}