package Theory.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{34, 6, 41, 16, 38, 36, 28, 19, 45, 43, 49};

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                // 현재 인덱스의 값이 다음 인덱스의 값보다 클 경우 실행
                if(array[j] > array[j + 1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
