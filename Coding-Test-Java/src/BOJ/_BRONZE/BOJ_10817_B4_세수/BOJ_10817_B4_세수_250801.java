package BOJ._BRONZE.BOJ_10817_B4_세수;

import java.util.*;
import java.io.*;

public class BOJ_10817_B4_세수_250801 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}
