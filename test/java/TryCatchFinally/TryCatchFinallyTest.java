package TryCatchFinally;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class TryCatchFinallyTest {

    @Test
    public void testFileExists() throws IOException {
        // Crear archivo de prueba
        File testFile = new File("test.in");
        if (!testFile.exists()) { // Solo crearlo si no existe
            FileWriter writer = new FileWriter(testFile);
            writer.write("Test file content");
            writer.close();
        }

        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            TryCatchFinally.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        // Obtener y limpiar la salida
        String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = String.join("\n",
                "Start of the main logic",
                "Try opening a file ...",
                "File Found, processing the file ...",
                "End of the main logic",
                "finally-block runs regardless of the state of exception",
                "After try-catch-finally, life goes on..."
        );

        assertEquals(expectedOutput, actualOutput, "Salida incorrecta cuando el archivo existe");
    }

    @Test
    public void testFileNotFound() {
        // Asegurar que el archivo no existe
        File testFile = new File("test.in");
        if (testFile.exists()) {
            testFile.delete();
        }

        // Redirigir la salida estándar
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            TryCatchFinally.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        // Obtener y limpiar la salida
        String actualOutput = outContent.toString().trim().replace("\r\n", "\n");
        String expectedOutput = String.join("\n",
                "Start of the main logic",
                "Try opening a file ...",
                "File Not Found caught ...",
                "finally-block runs regardless of the state of exception",
                "After try-catch-finally, life goes on..."
        );

        assertNotEquals(expectedOutput, actualOutput, "Salida incorrecta cuando el archivo no existe");
    }
}



