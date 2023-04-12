package BOJ.BinarySearch.BOJ_1920_수찾기;

import java.io.*;
import java.util.*;

public class BOJ_1920_수찾기 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int[] aarr = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            aarr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(aarr);

        int b = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b; i++) {
            sb.append(binarySearch(aarr, Integer.parseInt(st.nextToken())) == -1 ? 0 : 1).append("\n");
        }

        System.out.println(sb);

    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
