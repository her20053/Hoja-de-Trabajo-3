package Modulo;

import java.util.*; 
/**
 * Clase Radix Sort Complejidad del Algoritmo O(nlog(n))
 * Referencia a la implementacion:
 * https://www.geeksforgeeks.org/radix-sort/ Contribuido por Devesh Agrawal
 */  
class RadixSort { 
    /**
     * Metodo utilizado para obtener el mayor valor de la cadena[]
     * @param cadena
     * @param n
     * @return
     */
    static int getMax(int cadena[], int n) 
    { 
        int maximo = cadena[0]; 
        for (int i = 1; i < n; i++) 
            if (cadena[i] > maximo) 
                maximo = cadena[i]; 
        return maximo; 
    } 
    /**
     * Metodo utilizado para contar el ordenamiento de la cadena[]
     * de acorde a su indice "exp"
     * @param cadena
     * @param n
     * @param exp
     */
    static void countSort(int cadena[], int n, int exp) 
    { 
        // La cadena[] que sera de salida
        int salida[] = new int[n]; 
        int i; 
        int conteo[] = new int[10]; 
        Arrays.fill(conteo, 0); 
        // Almacena las ocurrencias que pasan en conteo[] 
        for (i = 0; i < n; i++) 
            conteo[(cadena[i] / exp) % 10]++; 
        // Cambia el conteo en la posicion i conteo[i] para que
        // almacene la posicion del digito en la salida[]
        for (i = 1; i < 10; i++) 
            conteo[i] += conteo[i - 1]; 
        // Se arma la array que sera de salisa[]
        for (i = n - 1; i >= 0; i--) { 
            salida[conteo[(cadena[i] / exp) % 10] - 1] = cadena[i]; 
            conteo[(cadena[i] / exp) % 10]--; 
        } 
        // Se copia la salida[] a la cadena[] para que cadena[]
        // contenga los numeros ordenados de acuerdo a su indice:
        for (i = 0; i < n; i++) 
            cadena[i] = salida[i]; 
    } 
    /**
     * Metodo inicial, se toma la cadena como parametro y su size,
     * este es el encargado de operar el Radix Sort
     * @param cadena
     * @param n
     */
    public static void sort(int cadena[], int n) 
    { 
        // Find the maximum number to know number of digits 
        int maximo = getMax(cadena, n); 
  
        // Do counting sort for every digit. Note that 
        // instead of passing digit number, exp is passed. 
        // exp is 10^i where i is current digit number 
        for (int exp = 1; maximo / exp > 0; exp *= 10) 
            countSort(cadena, n, exp); 
    } 
  
} 
/* This code is contributed by Devesh Agrawal */
