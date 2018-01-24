package com.algorithms;

import java.util.Arrays;

public class Array_QuickSort {

    public static void main(String[] args) {
       Integer [] arrayNumbers = {7, 2, 4, 1, 3, 10, 5, 5};
       Integer[] quickSort = new QuickSort(arrayNumbers).order().getArray();
       Arrays.stream(quickSort).forEach(System.out::println);
    }

    private static class QuickSort {
        private Integer [] array;
        private int length;

        public Integer[] getArray() {
            return array;
        }

        public QuickSort(Integer[] array) {
            this.array = array;
            this.length = array.length;
        }

        public QuickSort order() {
            quickSort(this.array, 0, length - 1);
            return this;
        }

        private void quickSort(Integer[] array, int low, int high) {
            if (low < high) {
                int mid = getPartition(array, low, high);
                quickSort(array, low, mid - 1);
                quickSort(array, mid + 1, high);
            }
        }

        private int getPartition(Integer[] array, int low, int high) {
            int pivot = array[low];
            do {
                while (low < high && array[high] >= pivot) {
                    high --;
                }
                if (low < high) {
                    array[low] = array[high];
                    while (low < high && array[low] <= pivot) {
                        low ++;
                    }
                    array[high] = array[low];
                }
            } while (low < high);
            array[low] = pivot;
            return low;
        }
    }
}
