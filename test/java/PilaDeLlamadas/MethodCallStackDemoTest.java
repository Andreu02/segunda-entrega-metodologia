package PilaDeLlamadas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Arrays;

public class MethodCallStackDemoTest {

    @Test
    public void testMethodCallStackWithExit() {
        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecutar el programa principal, que debe lanzar la excepción en methodC()
            MethodCallStackDemo.main(new String[]{});
        } catch (ArithmeticException ex) {
            // Capturar la excepción aquí para que el flujo continúe
            System.out.println("Excepcion aritmética capturada");
        } finally {
            // Restaurar la salida estándar
            System.setOut(originalOut);
        }

        // Obtener y limpiar la salida
        List<String> outputLines = Arrays.asList(outContent.toString().trim().split("\r?\n"));

        // Mensajes esperados, incluyendo las salidas de "Exit" después de capturar la excepción
        List<String> expectedLines = Arrays.asList(
                "Enter main()",
                "Enter methodA()",
                "Enter methodB()",
                "Enter methodC()",
                "Excepcion aritmética capturada" // Mensaje de la excepción capturada
                                  // Después de capturar la excepción
        );

        // Verificación de las salidas
        assertEquals(expectedLines, outputLines, "La salida no coincide con lo esperado");
    }
}

