package Modulo;
/**
 * Clase Bubble Sort Complejidad del Algoritmo O(n2)
 * Referencia a la implementacion:
 * https://www.geeksforgeeks.org/bubble-sort/ Contribuido por Nikita Tiwari
 */
public class BubbleSort 
{ 
    
    public static void sort(int cadena[]) 
    { 
        int pivote = cadena.length; 
        for (int i = 0; i < pivote-1; i++) 
            for (int j = 0; j < pivote-i-1; j++) 
                if (cadena[j] > cadena[j+1]) 
                { 
                    // swap cadena[j+1] and cadena[j] 
                    int temp = cadena[j]; 
                    cadena[j] = cadena[j+1]; 
                    cadena[j+1] = temp; 
                } 
    } 
}