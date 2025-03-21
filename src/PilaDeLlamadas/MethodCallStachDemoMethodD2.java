package PilaDeLlamadas;

public class MethodCallStachDemoMethodD2 {

    public static void main(String[] args) {
        try {
            System.out.println("Enter main()");
            methodA();
            System.out.println("Exit main()");
        }
        catch (ArithmeticException ex){
            System.out.println("Excepcion aritmética capturada");
        }
    }


    // ZONA DE METODOS
    public static void methodA() {
        System.out.println("Enter methodA()");
        methodB();
        System.out.println("Exit methodA()");
    }
    public static void methodB() {
        System.out.println("Enter methodB()");
        methodC();
        System.out.println("Exit methodB()");
    }
    public static void methodC() throws ArithmeticException, NullPointerException{ // no exception declared
        System.out.println("Enter methodC()");
        methodD();
        System.out.println("Exit methodC()");
    }

    public static void methodD() throws ArithmeticException, NullPointerException {
        System.out.println("Enter methodD()");
        System.out.println(1 / 0);
        System.out.println("Exit methodD()");
    }
}
