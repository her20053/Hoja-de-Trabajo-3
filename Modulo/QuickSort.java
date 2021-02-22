package Modulo;
/**
 * Clase Quick Sort Complejidad del Algoritmo O(n2)
 * Referencia a la implementacion:
 * https://www.geeksforgeeks.org/quick-sort/ Contribuido por Rajat Mishra
 */
public class QuickSort {
    /**
     * Este metodo toma el ultimo elemento como soporte,
     * coloca este soporte en su posicion correspondiente del cadenaeglo
     * y posteriormente coloca todos los elementos mas bajos que el pivote
     * por su izquierda y los mayores a la derecha.
     * @param cadena
     * @param bajo
     * @param alto
     * @return void
     */
       static int partition(int cadena[], int bajo, int alto) 
       { 
           int pivot = cadena[alto];  
           // Se define la posicion del elemento menor:
           int i = (bajo-1);  
           for (int j=bajo; j<alto; j++) 
           { 
               // Si el elemento actual es mas bajo que el pivote:
               if (cadena[j] < pivot) 
               { 
                   i++; 
     
                   // Se intercambia entre cadena[i] y cadena[j]:
                   int temp = cadena[i]; 
                   cadena[i] = cadena[j]; 
                   cadena[j] = temp; 
               } 
           } 
     
           // Cambiar cadena[ i + 1 ] y cadena[alto] o el pivote:
           int temp = cadena[i+1]; 
           cadena[i+1] = cadena[alto]; 
           cadena[alto] = temp; 
     
           return i+1; 
       } 
        /**
         * El sort implementado, cadena es el cadenaeglo y bajo se refiere a su posicion inicial
         * asi como para alto corresponde su ultimo punto.
        * @param cadena
        * @param bajo
        * @param alto
        */
       public static void sort(int cadena[], int bajo, int alto) 
       { 
           if (bajo < alto) 
           { 
               /* pi is partitioning index, cadena[pi] is  
                 now at right place */
               int pivote = partition(cadena, bajo, alto); 
     
               // Recursively sort elements before 
               // partition and after partition 
               sort(cadena, bajo, pivote-1); 
               sort(cadena, pivote+1, alto); 
           } 
       } 
}
