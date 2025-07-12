package BOJ._BRONZE.BOJ_9067_B2_점수집계;

import java.util.*;
import java.io.*;

public class BOJ_9067_B2_점수집계_250707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            if(arr[3] - arr[1] >=4) {
                sb.append("KIN").append("\n");
            } else {
                int temp = arr[1] + arr[2] + arr[3];
                sb.append(temp).append("\n");
            }
        }

        System.out.println(sb);
    }
}
