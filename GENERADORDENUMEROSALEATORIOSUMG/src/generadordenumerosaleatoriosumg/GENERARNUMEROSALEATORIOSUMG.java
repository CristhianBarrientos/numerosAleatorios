/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generadordenumerosaleatoriosumg;

import static generadordenumerosaleatoriosumg.GENERADORDENUMEROSALEATORIOSUMG.generarNumeros;
import static generadordenumerosaleatoriosumg.GENERADORDENUMEROSALEATORIOSUMG.leerNumeros;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alejandro Barrientos
 */
public class GENERARNUMEROSALEATORIOSUMG {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Generar numeros");
            System.out.println("2. Leer numeros");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    generarNumeros();
                    break;
                case 2:
                    leerNumeros();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static void generarYAlmacenarNumerosAleatorios() {
        String nombreArchivo = "numerosAleatorios.txt";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            Random generadorAleatorio = new Random();

            for (int i = 0; i < 1000000; i++) {
                int numeroAleatorio = generadorAleatorio.nextInt();
                escritor.write(String.valueOf(numeroAleatorio));
                escritor.newLine();
            }

            System.out.println("Se generaron los numeros en el archivo: " + nombreArchivo);
        } catch (IOException e) {
        }
    }

    public static void leerYOrdenarNumerosDelArchivo() {
        String archivoEntrada = "numerosAleatorios.txt";
        String archivoSalida = "numerosOrdenados.txt";

        ArrayList<Integer> numeros = new ArrayList<>(1000000);

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada)); PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(archivoSalida)))) {

            String linea;
            int contadorColumnas = 0;

            while ((linea = lector.readLine()) != null) {
                int numero = Integer.parseInt(linea);
                numeros.add(numero);

                // Imprimir en tres columnas
                System.out.printf("%-15d", numero);
                contadorColumnas++;

                // Si se alcanza la tercera columna, imprimir un salto de línea
                if (contadorColumnas % 5 == 0) {
                    System.out.println();
                }
            }

            // Ordenar la lista de números
            Collections.sort(numeros);

            // Mostrar en pantalla y escribir los números ordenados en el nuevo archivo
            for (int numero : numeros) {
                escritor.println(numero);
            }

            System.out.println("\nSe leyeron y ordenaron los numeros del archivo " + archivoEntrada + " y se almacenaron en el archivo " + archivoSalida);

        } catch (IOException e) {
        }
    }

}
