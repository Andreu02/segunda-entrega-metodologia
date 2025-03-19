package PilaDeLlamadas;

import javax.swing.plaf.synth.SynthTextAreaUI;

public class MethodCallStackDemo {
    // Firma que se usa en el Main
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
    public static void methodC() {
        System.out.println("Enter methodC()");
        System.out.println(1 / 0); // divide-by-0 triggers an ArithmeticException
        System.out.println("Exit methodC()");
    }
}
