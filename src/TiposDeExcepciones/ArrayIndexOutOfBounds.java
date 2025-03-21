package TiposDeExcepciones;

public class ArrayIndexOutOfBounds {

    // Lanzada por la JVM cuando intentas acceder a una posición de un array
    // que está fuera del rango creado, como por ejemplo

    public static void main(String[] args) {
        // ZONA DE ATRIBUTOS
        int[] array = {1, 2, 3, 4, 5}; // Tiene 4 posiciones, pues empieza en la posicion 0

        // ZONA DE METODOS
        try {
            System.out.println(array[5]);
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("Indice fuera de rango");
        }
    }

}
