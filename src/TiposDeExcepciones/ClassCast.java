package TiposDeExcepciones;

public class ClassCast {

    // Lanzada por la JVM cuando se intenta cambiar el tipo de un objeto a otro, pero no es posible por no
    // ser compatibles. Por ejemplo

    public static void main(String[] args) {
        // ZONA DE ATRIBUTOS
        Object o = new Object();

        // ZONA DE METODOS
        try {
            Integer i = (Integer)o;
        }
        catch (ClassCastException ex){
            System.out.println("No se puede convertir el objeto a Integer");
        }
    }
}
