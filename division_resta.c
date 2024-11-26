#include <stdio.h>

int division(int resultado, int dividendo, int divisor){
    if(dividendo >= divisor){
        dividendo = dividendo - divisor;
        resultado++;
        return division(resultado, dividendo, divisor);
    }else{
        return resultado;
    }
}

int main(){
    int divisr = 30;
    int dividen = 2;
    int r = division(0,divisr,dividen);
    printf("Divisor : %d\n", divisr);
    printf("Dividendo : %d\n", dividen);
    printf("resultado de la division: %d\n", r);
    printf("\n");
}