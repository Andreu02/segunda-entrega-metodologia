package TiposDeExcepciones;

public class NoClassDefFound {

    // Lanzada por la JVM cuando se solicita una clase que no puede ser encontrada (no se ha
    // programado, o se ha situado en una carpeta distinta a la esperada, ya sea en la del programa, en las bibliotecas o en el classpath).

    public static void main(String[] args) {
        try {
            // Intentamos usar una clase que no existe o no está en el classpath
            Class.forName("ClaseInexistente"); // Esto lanza ClassNotFoundException
        }
        catch (ClassNotFoundException ex) {
            // Simulamos el NoClassDefFoundError lanzándolo manualmente
            throw new NoClassDefFoundError("No se pudo encontrar la clase esperada: " + ex.getMessage());
        }
        catch (NoClassDefFoundError ex) {
            // Esta línea captura el error y lo maneja
            System.out.println("Error capturado: " + ex.getMessage());
        }
    }
}
