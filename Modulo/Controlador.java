package Modulo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controlador {

  private static int[] listaDesordenada;
  
  public static void main(String[] args) {
      
      vista();

      generarArchivoNumeros();
      
      GnomeSort.sort(listaDesordenada, listaDesordenada.length);

      QuickSort.sort(listaDesordenada, 0, listaDesordenada.length - 1);
      
      MergeSort.sort(listaDesordenada, 0, listaDesordenada.length - 1);

      RadixSort.sort(listaDesordenada, listaDesordenada.length);

      BubbleSort.sort(listaDesordenada);

      System.out.println(Arrays.toString(listaDesordenada));

  }

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
  private static void generarArchivoNumeros(){

      System.out.println("\n[Consola] Generando lista de numeros..");

      File aEliminar = new File("numerosAleatorios.txt"); 
      if (aEliminar.delete()) { 
      System.out.println("[Consola] Archivo de datos anterior eliminado: " + aEliminar.getName());
      } else {
      System.out.println("[Consola] No se ha reconocido ningun archivo previo .txt, continuando.");
      }
      
      try {
      File aCrear = new File("numerosAleatorios.txt");
          if (aCrear.createNewFile()) {
            System.out.println("[Consola] Archivo creado: " + aCrear.getName());
          }
        } catch (IOException e) {
          System.out.println("[Consola] Error al crear archivo.");
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
          System.out.println("[Consola] Se han escrito los datos correctamente al archivo.");
        } catch (IOException e) {
          System.out.println("[Consola] Ocurrio un error.");
          e.printStackTrace();
        }

        System.out.println("\n\n\n");
    }
  
}
