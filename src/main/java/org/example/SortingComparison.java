package org.example;

import java.util.Arrays;

public class SortingComparison {

    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < 100; i++) {
            array[i] = (int) (Math.random() * 1000);
        }

        int[] arrayHeapSort = Arrays.copyOf(array, array.length);
        int[] arrayQuickSort = Arrays.copyOf(array, array.length);

        int heapSortOperations = heapSort(arrayHeapSort);
        System.out.println("Heap Sort Operations: " + heapSortOperations);

        int quickSortOperations = quickSort(arrayQuickSort, 0, arrayQuickSort.length - 1);
        System.out.println("Quick Sort Operations: " + quickSortOperations);
    }

    private static int heapSort(int[] array) {
        int n = array.length;
        int operations = 0;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            operations++;
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
            operations++;
        }

        return operations;
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }

    private static int quickSort(int[] array, int low, int high) {
        int operations = 0;

        if (low < high) {
            int partitionIndex = partition(array, low, high);
            operations++;

            operations += quickSort(array, low, partitionIndex - 1);
            operations += quickSort(array, partitionIndex + 1, high);
        }

        return operations;
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
