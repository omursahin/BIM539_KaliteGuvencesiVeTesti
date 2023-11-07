package org.breaking_software;

public class FloatingPointError {

    public static void main(String[] args) {
	final double SOME_VALUE = 857.0; // Bu satirda gerceklesiyor
	double oneVal = 1.0 / SOME_VALUE;
	double total = oneVal * SOME_VALUE;

	System.out.println("toplam 1.0 olmali ancak aslinda: " + total);

	boolean areEqual = (total == 1.0);

	System.out.println("Java Bey, bunlar esit mi? " + areEqual);
    }
}
