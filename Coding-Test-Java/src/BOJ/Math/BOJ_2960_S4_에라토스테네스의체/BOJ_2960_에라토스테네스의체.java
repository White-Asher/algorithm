package BOJ.Math.BOJ_2960_S4_에라토스테네스의체;

import java.util.*;
import java.io.*;

public class BOJ_2960_에라토스테네스의체 {
    static StringTokenizer st;
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int cnt = 1;
        int ans = 0;
        boolean[] arr = new boolean[N+1];

        for(int i = 2; i <= N; i++) {
            for(int j = 1; (i * j) <= N; j++) {
                if (!arr[i * j]) {
                    arr[i * j] = true;
                    if (cnt == K) {
                        ans = i * j;
                        System.out.println(ans);
                        System.exit(0);
                    }
                    cnt++;
                }
            }
        }
        System.out.println(ans);
    }
}
