package at.altin.loginspring.java21;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public static void justNormalCoding(List<Object> strList) {
        strList.forEach(System.out::println);
        strList.forEach(_ -> System.out.println("Hello"));

        strList.stream()
                .filter(s -> s instanceof String)
                .map(s -> (String) s)
                .map(String::toUpperCase)
                .mapMultiToInt((s, consumer) -> {
                    if (s.startsWith("A")) {
                        consumer.accept(s.length());
                    }
                })
                .mapToObj(i -> STR."die Laenge:\{i} ")
                .forEach(System.out::println);

        strList.stream()
                .flatMap(s -> STR."Hello \{s}!".lines())
                .forEach(System.out::println);

        strList.stream()
                .filter(Objects::nonNull)
                .filter(s -> s instanceof String)
                .forEach(_ -> System.out.println("Hello das ist ohne Variable nur einmal"));

    }
}
