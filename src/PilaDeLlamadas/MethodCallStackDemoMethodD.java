package PilaDeLlamadas;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class MethodCallStackDemoMethodD {
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
    public static void methodC() { // no exception declared
        try {
            System.out.println("Enter methodC()");
            methodD();
        }
        catch (ArithmeticException ex) {
            System.out.println("Excepcion aritmética capturada");
        } catch (NullPointerException ex) {
        System.out.println("Excepcion NulPointer capturada");
        }
        finally {
            System.out.println("Pasamos al metodo B aunque la excepcion esta capturada en el B");
        }
    }

    public static void methodD() throws ArithmeticException, NullPointerException {
        System.out.println("Enter methodD()");
        System.out.println(1 / 0);
        System.out.println("Exit methodD()");
    }
}
