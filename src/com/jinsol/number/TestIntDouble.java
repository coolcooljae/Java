package com.jinsol.number;

/**
 * Created by jaejo on 9/1/16.
 */
public class TestIntDouble {

    public static void main(String[] args) {

        double mortage = 1000000;
        double duration = 30; // years
        double monthlyPayment = mortage / duration / 12;

        System.out.println(monthlyPayment);
        System.out.println( "ceiling: " + Math.ceil(monthlyPayment) );
        System.out.println( "floor: " + Math.floor(monthlyPayment) );
        System.out.println( "round: " + Math.round(monthlyPayment) );

        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println( Math.round(Math.random() * 100) );
        }
    }
}
