package Ejemplos;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerFromFileWithThrow {

    // CAPTURAMOS LA EXCEPCION CON EL METODO QUE LLAMA A ESTE METODO, LO LANZAMOS HACIA ARRIBA

    // Método que lanza la excepción hacia el método que lo llama
    public static void readFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File("test.in"));
        System.out.println("Archivo encontrado y abierto correctamente.");
    }

    public static void main(String[] args) {
        try {
            readFile(); // Llamamos al método que puede lanzar la excepción
        } catch (FileNotFoundException ex) {
            System.out.println("Error: No se pudo encontrar el archivo 'test.in'.");
        }
    }
}

