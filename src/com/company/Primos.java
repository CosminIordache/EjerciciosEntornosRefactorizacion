package com.company;
import java.util.Scanner;

/**
 * @author ElGranCOSMIN
 * @version 1.1.1
 */
public class Primos {
    // Generar números primos de 1 a max

    /**
     * El programa genera los numeros primos del 1 al max
     * @param max Numero maximo de primos que genera
     * @return Devuelve los numeros primos de dicho numero
     */
    public static int[] generarPrimos (int max) {
        int i,j;
        if (max >= 2) {
            // Declaraciones
            int tamañoNumero = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[tamañoNumero];
            // Inicializar el array
            for (i=0; i<tamañoNumero; i++) {
                esPrimo[i] = true;
            }
            // Eliminar el 0 y el 1, que no son primos
            EliminarZeroYUnos(esPrimo);
            // Criba
            for (i=2; i<Math.sqrt(tamañoNumero)+1; i++) {
                if (esPrimo[i]) {
                    // Eliminar los múltiplos de i
                    eliminarMultiplosDe1(i, tamañoNumero, esPrimo);
                }
            }
            // ¿Cuántos primos hay?
            int contador = 0;
            for (i=0; i<tamañoNumero; i++) {
                if (esPrimo[i]) {
                    contador++;
                }
            }
            // Rellenar el vector de números primos
            int[] primos = new int[contador];
            rellenarVector(tamañoNumero, esPrimo, primos);
            return primos;
        }
        else { // max < 2
            return vaciarVector();
            // Vector vacío
        }
    }

    /**
     * Vacia el vector
     * @return Devuelve el vector vacio
     */
    private static int[] vaciarVector() {
        return new int[0];
    }

    /**
     * Rellena el vector
     * @param tamañoNumero Tamaño del numero
     * @param esPrimo Si un numero es primo
     * @param primos Cantidad de numeros primos
     */
    private static void rellenarVector(int tamañoNumero, boolean[] esPrimo, int[] primos) {
        int j;
        int i;
        for (i=0, j=0; i< tamañoNumero; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
    }

    /**
     * Elimina los mutiplos de 1
     * @param i Recorre el vector
     * @param tamañoNumero
     * @param esPrimo
     */
    private static void eliminarMultiplosDe1(int i, int tamañoNumero, boolean[] esPrimo) {
        int j;
        for (j = 2 * i; j < tamañoNumero; j += i) {
            esPrimo[j] = false;
        }
    }

    /**
     * Elminima el 0 y el 1
     * @param esPrimo
     */
    private static void EliminarZeroYUnos(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }
}