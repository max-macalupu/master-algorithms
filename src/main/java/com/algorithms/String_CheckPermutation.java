package com.algorithms;

public class String_CheckPermutation {

    public static void main(String[] args) {
        String firstParameter = "abcre";
        String secondParameter = "breca";
        boolean isPermutation = checkTwoStringPermutation(firstParameter, secondParameter);
        System.out.println(String.format("Is permutation?: %s", isPermutation));
    }

    private static boolean checkTwoStringPermutation(String firstParameter, String secondParameter) {
        if (firstParameter.length() != secondParameter.length()) return false;
        String firstParamSorted = orderStringByQuickSort(firstParameter);
        String secondSortedParam = orderStringByQuickSort(secondParameter);
        return firstParamSorted.equals(secondSortedParam);
    }

    private static String orderStringByQuickSort(String parameter) {
        int low = 0;
        int high = parameter.length() - 1;
        char[] charArray = getOrderArray(parameter.toCharArray(), low, high);
        return new String(charArray);
    }

    private static char[] getOrderArray(char[] chars, int low, int high) {
        if (low <=high ) {
            int mid = getLocator(chars, low, high);
            getOrderArray(chars, low, mid - 1);
            getOrderArray(chars, mid + 1, high);
        }
        return chars;
    }

    private static int getLocator(char[] chars, int low, int high) {
        char pivot = chars[low];
        do {
            while (low < high && chars[high] >= pivot) {
                high -- ;
            }
            if (low < high) {
                chars[low] = chars[high];
                while (low < high && chars[low] <= pivot) {
                    low ++ ;
                }
                chars[high] = chars[low];
            }
        } while (low < high) ;
        chars[low] = pivot;
        return low;
    }
}