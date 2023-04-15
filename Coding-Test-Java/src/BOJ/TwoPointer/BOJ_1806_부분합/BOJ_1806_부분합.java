package BOJ.TwoPointer.BOJ_1806_부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while(start <= N && end <= N) {
            if(sum >= S && min > end - start) {
                min = end - start;
            }

            if(sum < S) {
                sum += arr[end++];
            } else {
                sum -= arr[start++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);

    }
}
