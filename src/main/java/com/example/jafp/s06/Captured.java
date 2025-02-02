/*
 * Introduction to Functional Programming with Java
 * 
 * https://github.com/egalli64/jafp
 */
package com.example.jafp.s06;

/**
 * Closure on instance/class data member and local variable
 */
public class Captured {
    private static int classValue = 42;
    private double instanceValue = Math.E;

    /**
     * Create runnables capturing different types of variable, than pass them to a
     * method in another class that run it. Notice the called has access to caller
     * private/local data!
     */
    private void capturing() {
        double local = Math.PI;

        /* a lambda capturing an instance field, creo un oggetto runnable e lo passo 
         * alla execute che fa la run
         */
        Runnable r1 = () -> System.out.println("Modifying the instance variable " + ++instanceValue);
        CapturedUser.execute(r1);

        // a lambda capturing a static field
        Runnable r2 = () -> System.out.println("Modifying the class variable " + ++classValue);

        CapturedUser.execute(r2);

        // a lambda capturing a local variable - must be final or effectively final
        Runnable r3 = () -> System.out.println(local);
        CapturedUser.execute(r3);
    }

    public static void main(String[] args) {
        new Captured().capturing();
    }
}
