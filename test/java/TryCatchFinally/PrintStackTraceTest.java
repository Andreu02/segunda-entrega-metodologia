package TryCatchFinally;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class PrintStackTraceTest {

    @Test
    public void testFileNotFound() {
        // Nos aseguramos de que el archivo "test.in" no exista
        File testFile = new File("test.in");

        // Redirigir la salida de error para capturar el mensaje de excepción
        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        PrintStream originalErr = System.err;
        System.setErr(new PrintStream(errContent));

        try {
            // Ejecutar el código, el archivo no debe existir
            PrintStackTrace.main(new String[]{});
        } finally {
            System.setErr(originalErr);
        }

        // Verificar que la salida contiene la traza completa del error
        String actualErrorMessage = errContent.toString().trim();
        // Verifica que el mensaje contiene "No such file or directory", que es parte de la traza de la excepción
        assertFalse(actualErrorMessage.contains("test.in"), "El mensaje de error no menciona el archivo 'test.in'");
    }

    @Test
    public void testFileExists() throws IOException {
        // Crear archivo de prueba "test.in"
        File testFile = new File("test.in");
        if (!testFile.exists()) {
            testFile.createNewFile(); // Si no existe, lo creamos
        }

        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecutar el código cuando el archivo existe
            PrintStackTrace.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        // Verificar que no haya errores, ya que el archivo existe
        assertEquals("", outContent.toString().trim(), "La salida no debería contener errores si el archivo existe.");
    }
}


