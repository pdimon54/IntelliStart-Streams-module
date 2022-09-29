package com.IntelliStart;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> people = new ArrayList<>();
        people.add("Sasha");
        people.add("Masha");
        people.add("Dasha");
        people.add("Vasyl");
        people.add("Vlad");
        people.add("Dima");
        people.add("Oleg");
        System.out.println("Task 1");
        System.out.println(getUnmatchedPeopleList(people));

        System.out.println("Task 2");
        System.out.println(getSortedCapsLookPeopleList(people));

        String[] array = {"1, 2, 0","4, 5"};
        System.out.println("Task 3");
        showIntFormatStringArray(array);

        System.out.println("Task 4");
        //generateLongStreamValue(25214903917,11,Math.pow(2,48));

        System.out.println("Task 5");

    }

    private static String getUnmatchedPeopleList(List<String> people){
        return IntStream.range(0, people.size()).
                filter(n->n%2==0).mapToObj(people::get)
                .collect(Collectors.joining(" ,"));

    }

    private static List<String> getSortedCapsLookPeopleList(List<String> people) {
        return people.stream().sorted(Comparator.reverseOrder()).map(String::toUpperCase).toList();
    }

    private static void showIntFormatStringArray(String[] array){
        List<Integer> strings1 = Arrays.stream(Arrays.stream(array).map(s -> s.replace(",",""))
                .reduce("", (partialString, element) -> partialString + " " + element)
                .split(" ")).filter(s -> !s.equals("")).map(s -> Integer.parseInt(s)).sorted().toList();
        System.out.println(strings1);
    }

    private static Stream<Long> generateLongStreamValue(long a, long c,long m){
        return LongStream.iterate(0, n-> n == -1, x -> 1 + (a*x + c) %m).boxed();

    }

    /*public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

    }*/

}
