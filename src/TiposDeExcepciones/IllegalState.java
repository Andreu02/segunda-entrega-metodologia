package TiposDeExcepciones;

public class IllegalState {

    // Se lanza programáticamente cuando se invoca un método y el programa no se encuentra en un
    // estado apropiado para que ese método realice su tarea. Esto ocurre cuando un método se invoca fuera de secuencia, o quizás un
    // método solo se permite invocar una vez y se intenta invocarlo nuevamente

    public static void main(String[] args) {
        // ZONA DE ATRIBUTOS
        String estado = "VACIO"; // Estado inicial de la máquina expendedora

        try {
            dispensarProducto(estado);
        }
        catch (IllegalStateException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void dispensarProducto(String estado) {
        if (estado != "LISTO") {
            throw new IllegalStateException("La máquina expendedora está vacía. No se puede dispensar un producto.");
        }
        System.out.println("Producto dispensado correctamente.");
    }
}
