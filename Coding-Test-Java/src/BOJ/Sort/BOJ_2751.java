package BOJ.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2751 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        mergeSort(arr);
        for(int i : arr){
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int[] sorted;
    private static void mergeSort(int[] arr) {
        sorted = new int[arr.length];
        mergeSort(arr, 0, arr.length-1);
        sorted = null;
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left == right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int ls = left;
        int rs = mid + 1;
        int idx = left;

        while (ls <= mid && rs <= right) {
            if (arr[ls] <= arr[rs]) sorted[idx++] = arr[ls++];
            else sorted[idx++] = arr[rs++];
        }
        if (ls > mid) {
            while (rs <= right) {
                sorted[idx++] = arr[rs++];
            }
        } else {
           while (ls <= mid) {
               sorted[idx++] = arr[ls++];
           }
        }
        for (int i = left; i <= right ; i++) {
            arr[i] = sorted[i];
        }
    }
}
