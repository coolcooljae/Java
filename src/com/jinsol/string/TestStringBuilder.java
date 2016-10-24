package com.jinsol.string;

/**
 * Created by jaejo on 9/7/16.
 */
public class TestStringBuilder {

    public static void main(String[] args) {

        StringBuilder myBuilder = new StringBuilder("initial");
        myBuilder.append(' ');
        myBuilder.append("string is ");
        myBuilder.append("Hello World!");
        System.out.println(myBuilder.toString());

        TestStringBuilder tsb = new TestStringBuilder();
        StringBuilder myStr = new StringBuilder("hey");
//        tsb.testScope(myStr); // "hey ho yes finally!!!"
        tsb.testScope(myStr);
        System.out.println(myStr.toString());
    }

    void testScope(StringBuilder input) {

        input = new StringBuilder("new");

        try {
            input.append(" ho");
        }
        catch(Exception e) {
            input.append(" in exception");
        }
        finally {
            input.append(" yes finally!!!");
        }
    }

}
