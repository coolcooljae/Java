package com.jinsol.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by jaejo on 10/6/16.
 */
public class MapTraverse {

    public static void main(String[] args) {

        Map<String, String> myMap = new HashMap<String, String>();
        myMap.put("1", "Jan");
        myMap.put("2", "Feb");
        myMap.put("3", "Mar");
        myMap.put("4", "Feb");

        //loop a Map
        for (Map.Entry<String, String> entry : myMap.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }

        //Java 8 only, forEach and Lambda
        myMap.forEach((k,v)->System.out.println("Key : " + k + " Value : " + v));

        // another lamda
        System.out.println("\n2nd test to convert to find months who value is Feb");
        String what = myMap.entrySet().stream()
                .filter(map -> "Feb".equals(map.getValue()))
                .map(map->map.getKey())
                .collect(Collectors.joining());
        System.out.println(what);

        // more test
        System.out.println("\nanother test to convert to list with months > 2");
        List list = myMap.entrySet().stream()
                .filter(map -> Integer.parseInt(map.getKey()) > 2 )
                .map(map->map.getValue())
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
