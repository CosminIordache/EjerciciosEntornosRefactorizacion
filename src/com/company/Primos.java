package com.company;


public class Primos {
    // Generar números primos de 1 a max

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


    private static void rellenarVector(int tamañoNumeros, boolean[] esPrimo, int[] primos) {
        int j;
        int i;
        for (i=0, j=0; i< tamañoNumeros; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
    }


    private static void eliminarMultiplosDeUno(int i, int tamañoNumeros, boolean[] esPrimo) {
        int j;
        if (esPrimo[i]) {
            // Eliminar los múltiplos de i
            for (j = 2 * i; j < tamañoNumeros; j += i) {
                esPrimo[j] = false;
            }
        }
    }

    static void eliminarZerosYUnos(boolean[] esPrimo) {
        esPrimo[0] = esPrimo[1] = false;
    }


    private static int[] vaciarVector() {
        return new int[0];
    }
}