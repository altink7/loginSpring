package at.altin.loginspring.java21;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

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


    public static void testVirtualThread(int numberOfThreads) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor();

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                int _ = IntStream.range(0, 1000000)
                        .parallel()
                        .map(j -> j * j)
                        .sum();
            }, executor);
            futures.add(future);
        }

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        try {
            allOf.get();
        } catch (Exception ignored) {
        }

        executor.shutdown();

        long endTime = System.currentTimeMillis();
        System.out.println(STR."Virtual Thread Performance: \{endTime - startTime} ms");
    }

    public static void testNormalThread(int numberOfThreads) {
        long startTime = System.currentTimeMillis();

        List<Thread> normalThreads = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            Thread normalThread = new Thread(() -> {
                int _ = IntStream.range(0, 1000000)
                        .parallel()
                        .map(j -> j * j)
                        .sum();
            });
            normalThread.start();
            normalThreads.add(normalThread);
        }

        for (Thread normalThread : normalThreads) {
            try {
                normalThread.join();
            } catch (InterruptedException ignored) {
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println(STR."Normal Thread Performance: \{endTime - startTime} ms");
    }
}
