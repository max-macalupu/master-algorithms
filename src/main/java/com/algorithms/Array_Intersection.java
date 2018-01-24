package com.algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Array_Intersection {
    public static void main(String[] args) {

        String[] array_01 = {"4", "10", "11", "33"};
        String[] array_02 = {"4", "12", "11", "3"};

        Set<Integer> firstIntersection = intersectionFirstWay(array_01, array_02);
        firstIntersection.forEach(System.out::println);
    }

    private static Set<Integer> intersectionFirstWay(String[] array_01, String[] array_02) {
        Set set_01 = Stream.of(array_01).map(x -> Integer.valueOf(x)).sorted().collect(Collectors.toSet());
        Set set_02 = Stream.of(array_02).map(x -> Integer.valueOf(x)).sorted().collect(Collectors.toSet());
        List<Integer> allValues = new ArrayList<>();
        allValues.addAll(set_01);
        allValues.addAll(set_02);
        Set<Integer> duplicateList = new HashSet();
        return allValues.stream().filter( x -> !duplicateList.add(x)).collect(Collectors.toSet());
    }
}
