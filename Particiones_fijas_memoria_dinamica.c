#include <stdio.h>
#include <stdlib.h>

typedef struct Bloque {
    int tamano;
    int id_de_proceso; // -1 si está libre
    struct Bloque *siguiente;
} Bloque;

// Crear un nuevo bloque de memoria
Bloque *crear_bloque(int tamano, int id_de_proceso) {
    Bloque *nuevo_bloque = (Bloque *)malloc(sizeof(Bloque));
    nuevo_bloque->tamano = tamano;
    nuevo_bloque->id_de_proceso = id_de_proceso;
    nuevo_bloque->siguiente = NULL;
    return nuevo_bloque;
}

// Imprimir el estado de la memoria
void imprime_memoria(Bloque *memoria) {
    printf("\nEstado de la memoria:\n");
    int i = 1;
    while (memoria != NULL) {
        if (memoria->id_de_proceso == -1) {
            printf("Bloque %d: %d KB (Libre)\n", i, memoria->tamano);
        } else {
            printf("Bloque %d: %d KB (Proceso %d)\n", i, memoria->tamano, memoria->id_de_proceso);
        }
        memoria = memoria->siguiente;
        i++;
    }
    printf("\n");
}

// Asignar proceso
void asignar_proceso(Bloque **memoria, int id_de_proceso, int tam_proceso) {
    Bloque *actual = *memoria;

    while (actual != NULL) {
        if (actual->id_de_proceso == -1 && actual->tamano >= tam_proceso) {
            if (actual->tamano > tam_proceso) {
                // Dividir el bloque
                Bloque *nuevo_bloque = crear_bloque(actual->tamano - tam_proceso, -1);
                nuevo_bloque->siguiente = actual->siguiente;
                actual->siguiente = nuevo_bloque;
                actual->tamano = tam_proceso;
            }
            actual->id_de_proceso = id_de_proceso;
            printf("Proceso %d asignado a un bloque de %d KB.\n", id_de_proceso, tam_proceso);
            return;
        }
        actual = actual->siguiente;
    }

    printf("No se encontró un bloque disponible para el proceso %d.\n", id_de_proceso);
}

// Liberar proceso
void liberar_proceso(Bloque **memoria, int id_de_proceso) {
    Bloque *actual = *memoria;

    while (actual != NULL) {
        if (actual->id_de_proceso == id_de_proceso) {
            actual->id_de_proceso = -1;

            // Combinar bloques libres consecutivos
            while (actual->siguiente != NULL && actual->siguiente->id_de_proceso == -1) {
                Bloque *libre = actual->siguiente;
                actual->tamano += libre->tamano;
                actual->siguiente = libre->siguiente;
                free(libre);
            }

            printf("Proceso %d liberado.\n", id_de_proceso);
            return;
        }
        actual = actual->siguiente;
    }

    printf("No se encontró el proceso %d en la memoria.\n", id_de_proceso);
}

int main() {
    int memoria_total;
    Bloque *memoria = NULL;

    // Solicitar tamaño total de la memoria
    printf("Ingrese el tamaño total de la memoria (KB): ");
    scanf("%d", &memoria_total);

    // Crear un único bloque inicial que representa toda la memoria libre
    memoria = crear_bloque(memoria_total, -1);

    int op;
    do {
        printf("\n--- Menú ---\n");
        printf("1. Asignar proceso\n");
        printf("2. Liberar proceso\n");
        printf("3. Mostrar estado de la memoria\n");
        printf("4. Salir\n");
        printf("Seleccione una opción: ");
        scanf("%d", &op);

        switch (op) {
            case 1: {
                int id_de_proceso, tam_proceso;
                printf("Ingrese el ID del proceso: ");
                scanf("%d", &id_de_proceso);
                printf("Ingrese el tamaño del proceso (KB): ");
                scanf("%d", &tam_proceso);
                asignar_proceso(&memoria, id_de_proceso, tam_proceso);
                break;
            }
            case 2: {
                int id_de_proceso;
                printf("Ingrese el ID del proceso a liberar: ");
                scanf("%d", &id_de_proceso);
                liberar_proceso(&memoria, id_de_proceso);
                break;
            }
            case 3:
                imprime_memoria(memoria);
                break;
            case 4:
                printf("Saliendo del programa.\n");
                break;
            default:
                printf("Opción no válida.\n");
        }
    } while (op != 4);

    // Liberar toda la memoria al salir
    while (memoria != NULL) {
        Bloque *temp = memoria;
        memoria = memoria->siguiente;
        free(temp);
    }

    return 0;
}
