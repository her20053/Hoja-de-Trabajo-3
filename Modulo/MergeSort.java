package Modulo;

/**
 * Clase Merge Sort Complejidad del Algoritmo O(n)
 * Referencia a la implementacion:
 * https://www.geeksforgeeks.org/merge-sort/ Contribuido por Mayank Tyagi
 */
public class MergeSort 
{ 
    /**
     * Este metodo combina dos subArrays de las cuales toma como parametro una y crea la segunda
     * a base de una posicion +1 de la original [ m+1 .. r]
     * @param arr
     * @param l
     * @param m
     * @param r
     */
    static void merge(int arr[], int l, int m, int r) 
    { 
        // Encontrar el size de las subArrays para ser combinadas:
        int numero1 = m - l + 1; 
        int numero2 = r - m; 
        // Se crean las matrices temporales haciendo referencia a Left y Right
        int Izquierda[] = new int [numero1]; 
        int Derecha[] = new int [numero2]; 
        // Se copia la informacion de la matriz original hacia las temporales:
        for (int i = 0; i < numero1; ++i) 
            Izquierda[i] = arr[l + i]; 
        for (int j = 0; j < numero2; ++j) 
            Derecha[j] = arr[m + 1+ j]; 
        // Se crean los indices principales de las subArrays creadas previamente:
        int iniciali = 0, inicialj = 0; 
        // Indice principal de la subArray creada
        int indicek = l; 
        while (iniciali < numero1 && inicialj < numero2) 
        { 
            if (Izquierda[iniciali] <= Derecha[inicialj]) 
            { 
                arr[indicek] = Izquierda[iniciali]; 
                iniciali++; 
            } 
            else
            { 
                arr[indicek] = Derecha[inicialj]; 
                inicialj++; 
            } 
            indicek++; 
        } 
        // Copiar los elementos restantes de la array Izquierda si quedan:
        while (iniciali < numero1) 
        { 
            arr[indicek] = Izquierda[iniciali]; 
            iniciali++; 
            indicek++; 
        } 
  
        // Copiar los elementos restantes de la array Derecha si quedan:
        while (inicialj < numero2) 
        { 
            arr[indicek] = Derecha[inicialj]; 
            inicialj++; 
            indicek++; 
        } 
    } 
    public static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2;    
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    } 
} 