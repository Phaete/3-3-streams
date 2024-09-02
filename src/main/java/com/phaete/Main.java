package com.phaete;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        List<String> list = List.of("Banana", "Apple", "Pear", "Pineapple", "Grapefruit", "Coconut");
//
//        // So far:
//        for (String fruit : list) {
//            if (fruit.contains("a")) {
//                System.out.println(fruit);
//            }
//        }
//
//        // Now with streams
//        list.stream()
//                .filter(fruit -> fruit.contains("a"))
//                .map(fruit -> "Fruit in basket is: " + fruit)
//                .peek(System.out::println) // .peek(fruit -> System.out.println(fruit))
//                .map(String::length) // .map(fruit -> fruit.length())
//                .forEach(System.out::println); // .forEach(fruit -> System.out.println(fruit));
//
//        int sum = list.stream()
//                .filter(fruit -> fruit.contains("a"))
//                .map(fruit -> "Fruit in basket is: " + fruit)
//                .peek(System.out::println) // .peek(fruit -> System.out.println(fruit))
//                .map(String::length) // .map(fruit -> fruit.length())
//                .reduce(0, Integer::sum); // .reduce(0, (a,b) -> a + b)
//        System.out.println(sum);
//
//        String collection = list.stream()
//                .filter(fruit -> fruit.contains("a"))
//                .map(fruit -> "Fruit in basket is: " + fruit)
//                .peek(System.out::println) // .peek(fruit -> System.out.println(fruit))
//                .collect(Collectors.joining(", ")); // turns the whole stream into a single string using the delimiter
//        System.out.println(collection);
//
//
//        // lazy stream: find the first that goes through all filters
//        // parallel stream: runs all checks in parallel instead of sequential

        List<Integer> numberList = List.of(11, 26, 13, 4, 75, 16, 57, 83, 29, 10);
        // Only print even numbers
        System.out.println("Even numbers:");
        numberList.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
        System.out.println("_____________________________");


        // multiply each filtered number by 2
        System.out.println("Each number x2: ");
        numberList.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .forEach(System.out::println);
        System.out.println("_____________________________");


        // sort numbers in ascending order
        numberList.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
        System.out.println("_____________________________");


        // sum all numbers
        Integer sum = numberList.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .sorted(Comparator.naturalOrder())
                .reduce(0, Integer::sum);
        System.out.println("Sum is: " + sum);
        System.out.println("_____________________________");


        // collect all processed numbers in a new list using collect
        List<Integer> newNumberList = numberList.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted list: " + newNumberList);
        System.out.println("_____________________________");



        // Bonus
        System.out.println("Bonus 1 - print students.csv");
        try {
            Files.lines(Path.of("src/main/resources/students.csv"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("_____________________________");

        System.out.println("Bonus 2 - remove header from students.csv");
        try {
            Files.lines(Path.of("src/main/resources/students.csv"))
                    .skip(1)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("_____________________________");

        System.out.println("Bonus 4 - remove invalid and duplicate lines");
        try {
            Files.lines(Path.of("src/main/resources/students.csv"))
                    .skip(1)
                    .distinct()
                    .filter(line -> !line.isEmpty())
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("_____________________________");

        System.out.println("Bonus 3 - convert each line into the class student");
        List<Student> studentList = new ArrayList<>();
        try {
            Files.lines(Path.of("src/main/resources/students.csv"))
                    .skip(1)
                    .distinct()
                    .filter(line -> !line.isEmpty())
                    .forEach(line -> studentList.add(new Student(
                            Integer.parseInt(line.split(",")[0]), // id
                            line.split(",")[1], // firstName
                            Integer.parseInt(line.split(",")[2]), // postal code
                            Integer.parseInt(line.split(",")[3]) // age
                    )));
            System.out.println(studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("_____________________________");

    }
}