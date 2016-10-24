package com.jinsol.misc;

/**
 * Created by jaejo on 5/5/16.
 */
public class PrimitiveReference {

    public static void main(String[] args) {

        int[] myValue = {2};
        modifyIt(myValue);
        System.out.println("myValue has " + myValue[0]);
    }

    static void modifyIt(int[] value) {
        value[0]++;
    }
}
