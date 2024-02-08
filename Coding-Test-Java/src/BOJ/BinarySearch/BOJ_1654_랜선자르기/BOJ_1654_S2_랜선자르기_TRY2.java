package BOJ.BinarySearch.BOJ_1654_랜선자르기;

import java.util.*;
import java.io.*;

public class BOJ_1654_S2_랜선자르기_TRY2 {
    static StringTokenizer st;
    static int K, N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max + 1;

        while(left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt+=arr[i] / mid;
            }
            if(cnt >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left - 1);

    }
}
