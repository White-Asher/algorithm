package BOJ.BinarySearch.BOJ_2805_나무자르기;

import java.util.*;
import java.io.*;

public class BOJ_2805_S1_나무자르기_TRY2 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long max = 0;
        long[] tree = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            max = Math.max(tree[i], max);
        }

        long left = 1;
        long right = max + 1;
        while(left <= right) {
            long mid = (left + right) / 2 ;
            long len = 0;

            for (int i = 0; i < N; i++) {
                if(tree[i] > mid) {
                    len += (tree[i] - mid);
                }
            }

            if(len >= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left - 1);
    }
}
