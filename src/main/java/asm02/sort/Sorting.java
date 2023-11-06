package asm02.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {
    public static void bubleSort(double[] a) {
        if(a ==null || a.length==0)
            return;

        int size = a.length;

        System.out.println();
        for (int i = 0; i <size-1 ; i++) {
            System.out.println(Arrays.toString(a));
            for (int j = 0; j <size-i-1 ; j++) {
                //check the adjacent elements

                if(a[j]>a[j+1]){
                    //swap the elements
                    double temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }

        }
    }
    public static void selectionSort(double[] a) {
        if(a==null || a.length==0)
            return;
        int size = a.length;
        for (int i = 0; i < a.length - 1; i++) {
            System.out.println(Arrays.toString(a));
            int iMin = i;
            for (int j = i + 1; j < a.length; j++)
                if (a[j] < a[iMin]) {
                    iMin = j;
                }
            if (i != iMin) {
                double temp = a[i];
                a[i] = a[iMin];
                a[iMin] = temp;
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static void insertionSort(double[] a) {
        double temp;

        for (int i = 1; i < a.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(a[j] < a[j-1]){
                    temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }
    }
    public static void quickSort(double[] a) {
        if(a==null || a.length==0)
            return;
        int size = a.length;
        quickSort(a, 0, size-1);
    }

    static void quickSort(double[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    static int partition(double[] arr, int start, int end) {
        double pivot = arr[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    static void swap(double[] arr, int x, int y) {
        double temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static List<Integer> linearSearch(double[] list, int search) {
        int length = list.length;
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < length; index++) {
            if (list[index] > search) {
                result.add(index);
            }
        }
        return result;
    }
    public static int binarySearch(double[] a, int key) {
        int start = 0;
        int end = a.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (key < a[middle]) {
                end = middle - 1;
            } else if (key > a[middle]) {
                start = middle + 1;
            } else if (key == a[middle]) {
                return middle;
            }
        }
        return -1;
    }
}
