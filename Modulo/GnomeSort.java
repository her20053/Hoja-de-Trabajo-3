package Modulo;

/**
 * Clase Gnome Sort Complejidad del Algoritmo O(n2)
 * Referencia a la implementacion:
 * https://www.geeksforgeeks.org/gnome-sort-a-stupid-one/ Contribuido por Mohit Gupta_OMG 
 */
public class GnomeSort {
    
    public static void sort(int[] estructura, int largo){ 
        int puntero = 0; 
        
        while (puntero < largo) {
            if (puntero == 0) 
                puntero++; 
            if (estructura[puntero] >= estructura[puntero - 1]) 
                puntero++; 
            else { 
                int temporal = 0; 
                temporal = estructura[puntero]; 
                estructura[puntero] = estructura[puntero - 1]; 
                estructura[puntero - 1] = temporal; 
                puntero--; 
            } 
        } 
      } 

}
