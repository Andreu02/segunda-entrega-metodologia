package TiposDeExcepciones;

public class IllegalArgument {

    // Lanzada a nivel de programación para indicar que un método ha recibido argumentos no
    // apropiados. Este tipo de excepción puede usarse en nuestros propios métodos para lanzarla cuando recibimos parámetros con
    // valores que hacen que nuestro método falle

    public static void main(String[] args) {
        // ZONA DE ATRIBUTOS
        int numero = -9; // Número negativo para probar la excepción

        // ZONA DE MÉTODOS
        try {
            double resultado = calcularRaizCuadrada(numero);
            System.out.println("La raíz cuadrada es: " + resultado);
        }
        catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static double calcularRaizCuadrada(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz cuadrada de un número negativo.");
        }
        return Math.sqrt(numero);
    }
}
