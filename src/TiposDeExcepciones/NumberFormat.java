package TiposDeExcepciones;

public class NumberFormat {

    // Se lanza a nivel de programa (p.ej. por Integer.parseInt()) cuando se intenta convertir
    // una cadena a un número, pero la cadena no tiene el formato apropiado. Por ejemplo

    public static void main(String[] args) {
        // ZONA DE ATRIBUTOS


        // ZONA DE METODOS
        try {
            Integer.parseInt("abc");
        }
        catch (NumberFormatException ex){
            System.out.println("No se puede convertir la cadena a numero");
        }
    }
}
