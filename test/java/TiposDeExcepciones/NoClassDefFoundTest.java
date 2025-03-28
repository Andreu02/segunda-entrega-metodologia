package TiposDeExcepciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NoClassDefFoundTest {

    @Test
    public void testMain() {
        // Captura la salida de la consola al ejecutar main()
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Se espera que main lance un NoClassDefFoundError
        assertThrows(NoClassDefFoundError.class, () -> NoClassDefFound.main(new String[]{}));

        // Restaurar la salida estándar
        System.setOut(originalOut);
    }
}
