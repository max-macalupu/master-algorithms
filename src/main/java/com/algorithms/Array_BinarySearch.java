package com.algorithms;

public class Array_BinarySearch {
    public static void main(String[] args) {
        Integer [] array = {1,2,4,6,8,10,11,16,17,20,30,32};
        Integer target = 17;
        int index = getIndexOfValue(array, target);
        System.out.println(index);
    }

    private static int getIndexOfValue(Integer[] array, Integer target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < array[mid]) {
               high = mid - 1;
            } else if (target > array[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}