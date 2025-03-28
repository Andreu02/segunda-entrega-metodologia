package TiposDeExcepciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NumberFormatTest {

    @Test
    public void testMain() {
        // Captura la salida de la consola al ejecutar main()
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // Ejecuta el método main de la clase NumberFormat
            NumberFormat.main(new String[]{});
        } catch (Exception e) {
            // Si se lanza alguna excepción inesperada fuera de main, la prueba fallará
            fail("Se produjo una excepción inesperada: " + e.getMessage());
        } finally {
            // Restaura la salida estándar
            System.setOut(originalOut);
        }

        // Verifica que la salida de la consola contiene el mensaje esperado
        String salidaEsperada = "No se puede convertir la cadena a numero";
        assertTrue(outContent.toString().contains(salidaEsperada), "La salida no contiene el mensaje esperado.");
    }
}
