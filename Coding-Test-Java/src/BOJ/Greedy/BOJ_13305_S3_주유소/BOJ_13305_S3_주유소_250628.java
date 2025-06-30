package BOJ.Greedy.BOJ_13305_S3_주유소;

import java.util.*;
import java.io.*;

public class BOJ_13305_S3_주유소_250628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N - 1];
        long[] arr2 = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
        }

        long min = Long.MAX_VALUE;
        long ans = 0L;
        for (int i = 0; i < N - 1; i++) {
            min = Math.min(min, arr2[i]);
            ans += min *arr[i];
        }
        System.out.println(ans);
    }
}
