package com.jinsol.collection;

import java.util.*;

/**
 * Created by jaejo on 10/20/16.
 */
public class CollectionFrequency {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("a");
        list.add("a");
        list.add("a");

        System.out.println("\nExample 1 - Count 'a' with frequency");
        System.out.println("a : " + Collections.frequency(list, "a"));

        System.out.println("\nExample 2 - Count all with frequency");
        Set<String> uniqueSet = new HashSet<String>(list);
        for (String temp : uniqueSet) {
            System.out.println(temp + ": " + Collections.frequency(list, temp));
        }
    }
}
