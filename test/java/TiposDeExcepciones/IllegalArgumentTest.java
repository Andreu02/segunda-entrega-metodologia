package TiposDeExcepciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IllegalArgumentTest {

    @Test
    public void testCalcularRaizCuadrada_NumeroPositivo() {
        // ✅ Verifica que la raíz cuadrada de 25 es 5.0
        double resultado = IllegalArgument.calcularRaizCuadrada(25);
        assertEquals(5.0, resultado, "La raíz cuadrada de 25 debería ser 5.0");
    }

    @Test
    public void testCalcularRaizCuadrada_NumeroCero() {
        // ✅ Verifica que la raíz cuadrada de 0 es 0.0
        double resultado = IllegalArgument.calcularRaizCuadrada(0);
        assertEquals(0.0, resultado, "La raíz cuadrada de 0 debería ser 0.0");
    }

    @Test
    public void testCalcularRaizCuadrada_NumeroNegativo() {
        // ✅ Verifica que al ingresar un número negativo se lanza la excepción
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            IllegalArgument.calcularRaizCuadrada(-9);
        });
        assertEquals("No se puede calcular la raíz cuadrada de un número negativo.", exception.getMessage());
    }

    @Test
    public void testMain() {
        // ✅ Captura la salida de la consola al ejecutar main()
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            IllegalArgument.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        // ✅ Verifica la salida esperada
        String salidaEsperada = "Error: No se puede calcular la raíz cuadrada de un número negativo.";
        assertTrue(outContent.toString().trim().contains(salidaEsperada));
    }
}
