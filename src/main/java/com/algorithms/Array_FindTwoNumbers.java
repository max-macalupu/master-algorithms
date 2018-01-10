package com.algorithms;


import java.util.*;

//Give a array find the two index's numbers that add up the target
//
public class Array_FindTwoNumbers {

    public static void main(String[] args) {
        List<Integer> initialList = Arrays.asList(4,1,6,10,20,30);
        Integer target = 31;
        getIndex(initialList, target).forEach(x -> System.out.println(x));
    }

    private static List<Integer> getIndex(List<Integer> numbersArray, Integer target) {
        List<Integer> indexList = new ArrayList<>();
        Map<Integer, Integer> remaindData = new HashMap<>();
        for(int i =0; i<numbersArray.size(); i++) {
            Integer remaindIndex = remaindData.get(numbersArray.get(i));
            if (remaindIndex == null) {
                remaindData.put(target - numbersArray.get(i), i);
            } else {
                indexList.add(remaindIndex);
                indexList.add(i);
                return indexList;
            }
        }
        return indexList;
    }

}
