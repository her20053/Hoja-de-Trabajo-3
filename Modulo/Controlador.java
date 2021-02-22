package Modulo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * @author Jose Hernandez Guerra 20053
 * Implementacion de sorts Algoritmos y Estructura de datos
 * Ultima modificacion 20 de febrero 2021
 */
public class Controlador {
  /**
   * Aqui es almacenada la lista de numeros generados cada instancia de sort:
   */
  private static int[] listaDesordenada;
  /**
   * Main, Cada vez que se ejecuta el programa este es el encargado de ejecutar
   * las distintas clases de Sort que hay, no retorna nada al ser void.
   * @param args
   */
  public static void main(String[] args) {
    // Llamada a la funcion de vista:
    vista();
    // Se generan 3000 numeros aleatorios:
    generarArchivoNumeros();
    // Se toma el tiempo principal antes de realizar el sort:
    long tiempoGnome = System.nanoTime();
    // Se llama a la clase estatica GnomeSort y se le pasa como parametros la lista y su length:
    GnomeSort.sort(listaDesordenada, listaDesordenada.length);
    // Se imprime la informacion de cuantos milisegundos tardo el sort en realizarse:
    System.out.println("[ GnomeSort ] Tiempo en milisegundos: " + (System.nanoTime() - tiempoGnome));

    // Se generan 3000 numeros aleatorios:
    generarArchivoNumeros();
    // Se toma el tiempo principal antes de realizar el sort:
    long tiempoQuick = System.nanoTime();
    // Se llama a la clase estatica QuickSort y se le pasa como parametros la lista y su length:
    QuickSort.sort(listaDesordenada, 0, listaDesordenada.length - 1);
    // Se imprime la informacion de cuantos milisegundos tardo el sort en realizarse:
    System.out.println("[ QuickSort ] Tiempo en milisegundos: " + (System.nanoTime() - tiempoQuick));

    // Se generan 3000 numeros aleatorios:
    generarArchivoNumeros();
    // Se toma el tiempo principal antes de realizar el sort:
    long tiempoMerge = System.nanoTime();
    // Se llama a la clase estatica MeregeSort y se le pasa como parametros la lista y su length:
    MergeSort.sort(listaDesordenada, 0, listaDesordenada.length - 1);
    // Se imprime la informacion de cuantos milisegundos tardo el sort en realizarse:
    System.out.println("[ MergeSort ] Tiempo en milisegundos: " + (System.nanoTime() - tiempoMerge));

    // Se generan 3000 numeros aleatorios:
    generarArchivoNumeros();
    // Se toma el tiempo principal antes de realizar el sort:
    long tiempoRadix = System.nanoTime();
    // Se llama a la clase estatica RadixSort y se le pasa como parametros la lista y su length:
    RadixSort.sort(listaDesordenada, listaDesordenada.length);
    // Se imprime la informacion de cuantos milisegundos tardo el sort en realizarse:
    System.out.println("[ RadixSort ] Tiempo en milisegundos: " + (System.nanoTime() - tiempoRadix));

    // Se generan 3000 numeros aleatorios:
    generarArchivoNumeros();
    // Se toma el tiempo principal antes de realizar el sort:
    long tiempoBuble = System.nanoTime();
    // Se llama a la clase estatica BubbleSort y se le pasa como parametros la lista:
    BubbleSort.sort(listaDesordenada);
    // Se imprime la informacion de cuantos milisegundos tardo el sort en realizarse:
    System.out.println("[ BubleSort ] Tiempo en milisegundos: " + (System.nanoTime() - tiempoBuble));
  }

  /**
   * Metodo Vista, no toma parametros y esta encargada de introducir al usuario 
   * al programa, lo que se pleanea hacer y requerir que presione enter para ejecutar
   * el codigo.
   * @param null
   * @return void
   */
  private static void vista(){
      System.out.println("\n" + "-".repeat(80));
      System.out.println(" > ] Bienvenido, un archivo sera generado con numeros desde 0 < x < 3001.");
      System.out.println("     El programa creara archivos por cada metodo de Sort posteriormente..\n");
      System.out.println(" 1 ] Gnome  sorting algorithm.");
      System.out.println(" 2 ] Merge  sorting algorithm.");
      System.out.println(" 3 ] Quick  sorting algorithm.");
      System.out.println(" 4 ] Radix  sorting algorithm.");
      System.out.println(" 5 ] Buble  sorting algorithm.\n");
      var sc = new Scanner(System.in);
      System.out.print(" > ] Presione ENTER para comenzar el recorrido.. ");
      sc.nextLine();
      sc.close();
  }
  /**
   * Metodo encargado de generar 3000 numeros y guardarlos en un archivo de texto, estos numeros seran guardados
   * en una Array[] para su posterior uso en los sorts una vez que esta funcion sea llamada.
   * @param null
   * @return void
   */
  private static void generarArchivoNumeros(){
      //System.out.println("\n[Consola] Generando lista de numeros..");
      File aEliminar = new File("numerosAleatorios.txt"); 
      if (aEliminar.delete()) { 
      //System.out.println("[Consola] Archivo de datos anterior eliminado: " + aEliminar.getName());
      } else {
      //System.out.println("[Consola] No se ha reconocido ningun archivo previo .txt, continuando.");
      }
      try {
      File aCrear = new File("numerosAleatorios.txt");
          if (aCrear.createNewFile()) {
            //System.out.println("[Consola] Archivo creado: " + aCrear.getName());
          }
        } catch (IOException e) {
          //System.out.println("[Consola] Error al crear archivo.");
          e.printStackTrace();
      }
      try {
          FileWriter myWriter = new FileWriter("numerosAleatorios.txt");
          ArrayList<Integer> lista = new ArrayList<>();
          for(int i = 1; i < 3001; i++){
              lista.add(i);
          }
          Collections.shuffle(lista);
          listaDesordenada = new int[lista.size()];
          for(int i = 0; i < lista.size(); i++){
            listaDesordenada[i] = lista.get(i);
          }
          String objetoTString = lista.stream().map(Object::toString).collect(Collectors.joining(" "));
          myWriter.write(objetoTString);
          myWriter.close();
         // System.out.println("[Consola] Se han escrito los datos correctamente al archivo.");
        } catch (IOException e) {
         // System.out.println("[Consola] Ocurrio un error.");
          e.printStackTrace();
        }
        System.out.println("");
    }
}
