package PilaDeLlamadas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class MethodCallStachDemoMethodD2Test {

    @Test
    void testMain() {
        // Capturar salida de consola
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Ejecutar el main
        MethodCallStachDemoMethodD2.main(new String[]{});

        // Restaurar salida estándar
        System.setOut(System.out);

        // Validar que se captura la excepción y se imprime el mensaje correcto
        String output = outContent.toString().trim();
        assertTrue(output.contains("Enter main()"));
        assertTrue(output.contains("Enter methodA()"));
        assertTrue(output.contains("Enter methodB()"));
        assertTrue(output.contains("Enter methodC()"));
        assertTrue(output.contains("Enter methodD()"));
        assertTrue(output.contains("Excepcion aritmética capturada"));
    }

    @Test
    void testMethodA() {
        assertThrows(ArithmeticException.class, MethodCallStachDemoMethodD2::methodA);
    }

    @Test
    void testMethodB() {
        assertThrows(ArithmeticException.class, MethodCallStachDemoMethodD2::methodB);
    }

    @Test
    void testMethodC() {
        assertThrows(ArithmeticException.class, MethodCallStachDemoMethodD2::methodC);
    }

    @Test
    void testMethodD() {
        assertThrows(ArithmeticException.class, MethodCallStachDemoMethodD2::methodD);
    }
}