package PilaDeLlamadas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Arrays;

public class MethodCallStackDemoMethodDTest {

    @Test
    public void testMethodCallStackWithException() {
        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecutar el programa principal
            MethodCallStackDemoMethodD.main(new String[]{});
        } finally {
            // Restaurar la salida estándar
            System.setOut(originalOut);
        }

        // Obtener y limpiar la salida
        List<String> outputLines = Arrays.asList(outContent.toString().trim().split("\r?\n"));

        // Mensajes esperados
        List<String> expectedLines = Arrays.asList(
                "Enter main()",
                "Enter methodA()",
                "Enter methodB()",
                "Enter methodC()",
                "Enter methodD()",
                "Excepcion aritmética capturada",    // Captura de ArithmeticException en methodC()
                "Pasamos al metodo B aunque la excepcion esta capturada en el B", // Mensaje del finally
                "Exit methodB()",
                "Exit methodA()",
                "Exit main()"
        );

        // Verificación de las salidas
        assertEquals(expectedLines, outputLines, "La salida no coincide con lo esperado");
    }
}
