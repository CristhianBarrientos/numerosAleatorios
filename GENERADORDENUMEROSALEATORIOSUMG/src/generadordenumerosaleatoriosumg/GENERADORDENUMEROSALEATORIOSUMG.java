/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package generadordenumerosaleatoriosumg;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alejandro Barrientos
 */
public class GENERADORDENUMEROSALEATORIOSUMG {

    /**
     * @param args the command line arguments
     */
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
                    System.out.println("Ingrese una opcion correcta.");
            }
        }
    }

    public static void generarNumeros() {
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

    public static void leerNumeros() {
        String archEscribir = "numerosAleatorios.txt";
        String archLectura = "numerosOrdenados.txt";

        ArrayList<Integer> numeros = new ArrayList<>(1000000);

        try (BufferedReader lector = new BufferedReader(new FileReader(archEscribir)); PrintWriter escritor = new PrintWriter(new BufferedWriter(new FileWriter(archLectura)))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                int numero = Integer.parseInt(linea);
                numeros.add(numero);
            }

            Collections.sort(numeros);

            for (int numero : numeros) {
                System.out.println(numero);
                escritor.println(numero);
            }

            System.out.println("Se leyeron numeros del archivo " + archEscribir + " y se colocaron en el archivo: " + archLectura);

        } catch (IOException e) {
        }
    }
    
}
