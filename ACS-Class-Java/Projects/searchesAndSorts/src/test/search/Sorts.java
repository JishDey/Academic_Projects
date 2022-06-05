package test.search;

import java.util.Arrays;

public class Sorts {
    public void verifySorted(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i+1]){
                System.out.println(false);
                return;
            }
        }

        System.out.println(true);
        return;
    }

    private static void swap(int[] array, int firstnumi, int secondnumi) {
        int store1 = array[firstnumi];
        array[firstnumi] = array[secondnumi];
        array[secondnumi] = store1;
    }

    private static void merge(int[] merged, int[] firstA, int[] secondA){
        int firstLength = firstA.length;
        int secondLength = secondA.length;
        int i = 0, j = 0, k = 0;
        while (i < firstLength && j < secondLength) {
            if (firstA[i] <= secondA[j]){
                merged[k] = firstA[i];
                k++;
                i++;
            }
            else{
                merged[k] = secondA[j];
                k++;
                j++;
            }
        }
        while(i < firstLength){
            merged[k] = firstA[i];
            k++;
            i++;
        }
        while(j < secondLength){
            merged[k] = secondA[j];
            k++;
            j++;
        }
    }

    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int a = i;

            for (int j = i + 1; j < array.length; j++) {
                
                if (array[j] < array[a])
                    a = j;
            }
            swap(array, i, a);
        }
    }

    public void bubbleSort(int[] array) {
        boolean sorted = false;
        for (int i = 0; i < array.length - 1 && !sorted; i++) {

            for (int j = 0; j < (array.length - 1) - i ; j++) {

                sorted = true;

                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    sorted = false;
                }
            }
        }
    }

   
    public int[] mergeSort(int[] array) {
        int arraylength = array.length;
        if(arraylength < 2) {
            return array;
        }
        int mid = arraylength/2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, arraylength);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
        return array;
    }

}