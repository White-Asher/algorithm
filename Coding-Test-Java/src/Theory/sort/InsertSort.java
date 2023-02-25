package Theory.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j >= 1; j--) {
                if(array[j] < array[j-1]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                } else break;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
