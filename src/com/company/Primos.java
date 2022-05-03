package com.company;

/**
 * El programa genera los numeros primos del 1 al max
 * @author Cosmin
 * @version 1.1.1
 */
public class Primos {
    // Generar números primos de 1 a max

    /**
     * Calcula la cantidad del primos que tiene un vector
     * @param max Es el numero maximo de primos hasta el que tiene que generar
     * @return Devuelve los numeros primos generados
     */
    public static int[] generarPrimos (int max) {
        int i,j;
        if (max >= 2) {
            // Declaraciones
            int tamañoNumeros = max + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[tamañoNumeros];
            // Inicializar el array
            for (i=0; i<tamañoNumeros; i++) {
                esPrimo[i] = true;
            }
            // Eliminar el 0 y el 1, que no son primos
            eliminarZerosYUnos(esPrimo);
            // Criba
            for (i=2; i<Math.sqrt(tamañoNumeros)+1; i++) {
                eliminarMultiplosDeUno(i, tamañoNumeros, esPrimo);
            }
            // ¿Cuántos primos hay?
            int contador = 0;
            for (i=0; i<tamañoNumeros; i++) {
                if (esPrimo[i]) {
                    contador++;
                }
            }
            // Rellenar el vector de números primos
            int[] primos = new int[contador];
            rellenarVector(tamañoNumeros, esPrimo, primos);
            return primos;
        }
        else { // max < 2
            return vaciarVector();
            // Vector vacío
        }
    }

    /**
     * Rellena el vector
     * @param tamañoNumeros El tamano del vector
     * @param esPrimo Indica que numeros son primos y cuales no
     * @param primos Todos los numeros del vector
     */
    private static void rellenarVector(int tamañoNumeros, boolean[] esPrimo, int[] primos) {
        int j;
        int i;
        for (i=0, j=0; i< tamañoNumeros; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
    }

    /**
     * Elimina los multiplos de 1
     * @param i Recorre el vector
     * @param tamañoNumeros
     * @param esPrimo
     */
    private static void eliminarMultiplosDeUno(int i, int tamañoNumeros, boolean[] esPrimo) {
        int j;
        if (esPrimo[i]) {
            // Eliminar los múltiplos de i
            for (j = 2 * i; j < tamañoNumeros; j += i) {
                esPrimo[j] = false;
            }
        }
    }

    /**
     * Elimina el 0 y el 1 al no ser primos
     * @param esPrimo
     */
    private static void eliminarZerosYUnos(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }

    /**
     * Vacia el vector
     * @return Devuelve un vector vacio
     */
    private static int[] vaciarVector() {
        return new int[0];
    }
}