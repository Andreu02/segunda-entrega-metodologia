package TiposDeExcepciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IllegalStateTest {

    @Test
    public void testDispensarProducto_ConEstadoListo() {
        // ✅ Verifica que el producto se dispensa cuando el estado es "LISTO"
        assertDoesNotThrow(() -> IllegalState.dispensarProducto("LISTO"));
    }

    @Test
    public void testDispensarProducto_ConEstadoVacio() {
        // ✅ Verifica que se lanza IllegalStateException cuando el estado no es "LISTO"
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            IllegalState.dispensarProducto("VACIO");
        });
        assertEquals("La máquina expendedora está vacía. No se puede dispensar un producto.", exception.getMessage());
    }

    @Test
    public void testMain() {
        // ✅ Captura la salida de la consola al ejecutar main()
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            IllegalState.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        // ✅ Verifica la salida esperada
        String salidaEsperada = "Error: La máquina expendedora está vacía. No se puede dispensar un producto.";
        assertTrue(outContent.toString().trim().contains(salidaEsperada));
    }
}
