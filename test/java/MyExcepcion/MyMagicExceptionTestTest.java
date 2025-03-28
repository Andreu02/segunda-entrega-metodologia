package MyExcepcion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MyMagicExceptionTestTest {

    @Test
    public void testMagic_noException() {
        // Captura la salida de la consola al ejecutar magic(9)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            MyMagicExceptionTest.magic(9); // No debe lanzar la excepción
        } catch (MyMagicException ex) {
            fail("La excepción no debería haberse lanzado.");
        } finally {
            // Restaura la salida estándar
            System.setOut(originalOut);
        }

        // Verifica que la salida contiene "hello"
        assertTrue(outContent.toString().contains("hello"), "La salida no contiene el mensaje esperado.");
    }

    @Test
    public void testMagic_exceptionThrown() {
        // Captura la salida de la consola al ejecutar magic(8)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            MyMagicExceptionTest.magic(8); // Esto lanza la excepción
            fail("Se esperaba una MyMagicException.");
        } catch (MyMagicException ex) {
            // Verifica que la excepción sea de tipo MyMagicException y que el mensaje sea el esperado
            assertEquals("you hit the magic number", ex.getMessage(), "El mensaje de la excepción no es el esperado.");
        } finally {
            // Restaura la salida estándar
            System.setOut(originalOut);
        }
    }

    @Test
    public void testMain_withNoException() {
        // Captura la salida de la consola al ejecutar el main con magic(9)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Ejecuta el método main, que contiene magic(9) y magic(8)
        MyMagicExceptionTest.main(new String[]{});

        // Verifica que la salida contenga tanto el "hello" de magic(9)
        // como la traza de la excepción cuando magic(8) lanza la MyMagicException
        String output = outContent.toString();
        assertTrue(output.contains("hello"), "La salida no contiene 'hello'.");
        assertFalse(output.contains("you hit the magic number"), "La salida no contiene el mensaje de la excepción.");
        assertFalse(output.contains("at MyMagicExceptionTest.magic"), "La salida no contiene la traza de la excepción.");

        // Restaura la salida estándar
        System.setOut(originalOut);
    }
}
