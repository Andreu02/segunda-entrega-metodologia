package TryCatchFinally;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Arrays;

public class MethodCallStackDemoTest {

    @Test
    public void testMethodCallStack() {
        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecutar el programa principal
            MethodCallStackDemo.main(new String[]{});
        } finally {
            // Restaurar la salida estándar
            System.setOut(originalOut);
        }

        // Obtener y limpiar la salida
        List<String> outputLines = Arrays.asList(outContent.toString().trim().split("\r?\n"));

        // Salida esperada del programa
        List<String> expectedLines = Arrays.asList(
                "Enter main()",
                "Enter methodA()",
                "Excepcion capturada",
                "finally in methodA()",
                "Exit methodA()",
                "Exit main()"
        );

        // Verificar que la salida es la esperada
        assertEquals(expectedLines, outputLines, "La salida del programa no coincide con lo esperado");
    }
}
