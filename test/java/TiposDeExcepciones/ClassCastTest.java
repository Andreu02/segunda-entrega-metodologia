package TiposDeExcepciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Arrays;

public class ClassCastTest {

    @Test
    public void testClassCastException() {
        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecutar el método main
            ClassCast.main(new String[]{});
        } finally {
            // Restaurar la salida estándar
            System.setOut(originalOut);
        }

        // Obtener y limpiar la salida
        List<String> outputLines = Arrays.asList(outContent.toString().trim().split("\r?\n"));
        List<String> expectedLines = Arrays.asList("No se puede convertir el objeto a Integer");

        assertEquals(expectedLines, outputLines, "La salida no coincide con lo esperado");
    }
}
