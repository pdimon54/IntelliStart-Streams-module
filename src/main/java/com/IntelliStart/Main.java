package com.IntelliStart;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    String[] array = {"1, 2, 0", "4, 5"};
    System.out.println("Task 3");
    showIntFormatStringArray(array);

    System.out.println("Task 4");
    generateLongStreamValue(25214903917L, 11, (long) Math.pow(2, 48));

    System.out.println("Task 5");
    zip(Stream.of(1, 2, 3, 4, 5), Stream.of(6, 7, 8, 9, 10));

  }

  private static String getUnmatchedPeopleList(List<String> people) {
    return IntStream.range(0, people.size()).
        filter(n -> n % 2 == 0).mapToObj(people::get)
        .collect(Collectors.joining(" ,"));

  }

  private static List<String> getSortedCapsLookPeopleList(List<String> people) {
    return people.stream().sorted(Comparator.reverseOrder()).map(String::toUpperCase).toList();
  }

  private static void showIntFormatStringArray(String[] array) {
    List<Integer> strings1 = Arrays.stream(Arrays.stream(array).map(s -> s.replace(",", ""))
        .reduce("", (partialString, element) -> partialString + " " + element)
        .split(" ")).filter(s -> !s.equals("")).map(s -> Integer.parseInt(s)).sorted().toList();
    System.out.println(strings1);
  }

  private static Stream<Long> generateLongStreamValue(long a, long c, long m) {
    return Stream.iterate(0L, x -> 1 + (a * x + c) % m);

  }

  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
    List firstList = first.collect(Collectors.toList());
    List secondList = second.collect(Collectors.toList());
    Collections.shuffle(firstList);
    Collections.shuffle(secondList);
    Stream.concat(firstList.stream(), secondList.stream()).forEach(System.out::println);
    return Stream.concat(firstList.stream(), secondList.stream());
  }

}
