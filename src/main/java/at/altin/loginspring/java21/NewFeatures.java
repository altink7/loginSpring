package at.altin.loginspring.java21;

import java.util.Collections;
import java.util.List;

/**
 * new java 21 switch
 */
public class NewFeatures {

    public static void mapObject(Object o) {
        switch (o) {
            case Integer _ -> System.out.println("Integer");
            case String _ -> System.out.println("String");
            case Double _ -> System.out.println("Double");
            case Long _ -> System.out.println("Long");
            default -> System.out.println("Unknown");
        }
    }


    public static void stringTemplate(String name) {
        System.out.println(STR."Hello \{name}!");
    }

    public static void justNormalCoding(List<String> strList) {
        strList.forEach(System.out::println);
        strList.forEach(_ -> System.out.println("Hello"));

        //do alot of lambda stuff
        strList.stream()
                .map(String::toUpperCase)
                .mapMultiToInt((s, consumer) -> {
                    if (s.startsWith("A")) {
                        consumer.accept(s.length());
                    }
                })
                .mapToObj(i -> STR."die Laenge:\{i} ")
                .forEach(System.out::println);


    }
}
