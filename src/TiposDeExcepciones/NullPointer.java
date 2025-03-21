package TiposDeExcepciones;

public class NullPointer {

    // Lanzada por la JVM cuando nuestro código intenta usar una referencia a un objeto que en
    // realidad es nula, como por ejemplo

    public static void main(String[] args) {
        // ZONA DE ATRIBUTOS
        String[] strs = new String[3];

        // ZONA DE METODOS
        try {
            System.out.println(strs[0].length());
        }
        catch (NullPointerException ex){
            System.out.println("Excepcion capturada");
        }
    }

}
