package Ejemplos;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScannerFromFileWithCatch {
    // CAPTURAMOS LA EXCEPCION CON TRY-CATCH
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new File("test.in"));
            // do something if no exception ...
            System.out.println("Archivo encontrado y abierto correctamente.");
        } catch (FileNotFoundException ex) {
            System.out.println("Error: No se pudo encontrar el archivo 'test.in'.");
        }
    }
}
