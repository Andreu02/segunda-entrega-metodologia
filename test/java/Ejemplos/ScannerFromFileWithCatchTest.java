package Ejemplos;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ScannerFromFileWithCatchTest {

    private void deleteFileIfExists(File file) {
        if (file.exists()) {
            boolean deleted = file.delete();
            if (!deleted) {
                System.gc(); // Sugerir recolección de basura para liberar recursos
                file.delete(); // Intentar de nuevo
            }
        }
    }

    @Test
    public void testFileExists() throws IOException {
        // Crear un archivo de prueba
        File testFile = new File("test.in");
        PrintWriter writer = new PrintWriter(new FileWriter(testFile));
        writer.println("Hola, mundo!");
        writer.close();

        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecutar el programa principal
            ScannerFromFileWithCatch.main(new String[]{});
        } finally {
            // Restaurar la salida estándar
            System.setOut(originalOut);
        }

        // Debería imprimir el mensaje de éxito
        String output = outContent.toString().trim();
        assertTrue(output.contains("Archivo encontrado y abierto correctamente."), "Salida obtenida: " + output);

        // Eliminar el archivo de prueba
        deleteFileIfExists(testFile);
    }

    @Test
    public void testFileNotFound() {
        // Asegurar que el archivo no existe
        File testFile = new File("test.in");
        deleteFileIfExists(testFile);

        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecutar el programa principal cuando el archivo no existe
            ScannerFromFileWithCatch.main(new String[]{});
        } finally {
            // Restaurar la salida estándar
            System.setOut(originalOut);
        }

        // Verificar que se captura la excepción correctamente
        String output = outContent.toString().trim();
        assertTrue(output.contains("Error: No se pudo encontrar el archivo 'test.in'."), "Salida obtenida: " + output);
    }
}