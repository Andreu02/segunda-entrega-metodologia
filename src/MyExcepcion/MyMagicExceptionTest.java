package MyExcepcion;

public class MyMagicExceptionTest {
    // This method "throw MyMagicException" in its body.
    // MyMagicException is checked and need to be declared in the method's signature
    public static void magic(int number) throws MyMagicException {
        if (number == 8) {
            throw (new MyMagicException("you hit the magic number"));
        }
        System.out.println("hello"); // skip if exception triggered
    }
    public static void main(String[] args) {
        try {
            magic(9); // does not trigger exception
            magic(8); // trigger exception
        } catch (MyMagicException ex) { // exception handler
            ex.printStackTrace();
        }
    }
}
