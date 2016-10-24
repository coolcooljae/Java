package com.jinsol.equal;

/**
 * Created by jaejo on 9/22/16.
 *
 * https://www.owasp.org/index.php/Java_gotchas#Immutable_Objects_.2F_Wrapper_Class_Caching
 */
public class BooleanEqaulTest {

    public static void main(String[] args) {

        boolean value = false;
        if ( value = true ) { // should be "=="
            System.out.println("value is true");
            // The result of any assignment expression is the value of the variable following the assignment.
            // Therefore, the above will always result in "theTruth is true". This only applies to booleans,
            // so for example the following will not compile and would therefore be caught by the compiler:
        }
        else {
            System.out.println("value is false");
        }
    }
}