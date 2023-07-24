package BOJ.Greedy.BOJ_11501_S2_주식;

import java.util.*;
import java.io.*;

public class BOJ_11502_주식 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j] = Long.parseLong(st.nextToken());
            }

            long max = 0;
            long sum = 0;
            for (int j = N-1; j >= 0; j--) {
                if(arr[j] > max) {
                    max = arr[j];
                } else {
                    sum += (max - arr[j]);
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
