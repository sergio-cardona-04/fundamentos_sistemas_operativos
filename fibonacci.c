#include <stdio.h>

int cantNumeros = 10;

void fibonacci(int num1, int num2, int numeros){
    int resultado;
    if(numeros <= 2){
        printf("0, 1, ");
    }
    if(numeros < cantNumeros){
        resultado = num1 + num2;
        printf("%d, ", resultado);
        num1 = num2;
        num2 = resultado;
        numeros++;
        fibonacci(num1, num2, numeros);
    }else{
        return;
    }
}

int main(){
    printf("Cantidad de datos: %d\n", cantNumeros);
    fibonacci(0,1,2);
}