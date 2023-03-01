package _Playground.Theory.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = new int[]{22, 50, 17, 25, 18, 32, 33, 44, 29, 8};

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
