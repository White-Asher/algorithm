package _temp.BOJ_2467_용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467_용액 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long result = Long.MAX_VALUE;
        long sum = 0 ;
        int start = 0;
        int end = N-1;
        long rs = 0;
        long re = 0;

        while (start < end) {
            sum = Math.abs(arr[start] + arr[end]);
            if (sum < result) {
                result = sum;
                rs = arr[start];
                re = arr[end];
                end--;
            } else {
                end--;
            }
        }

        System.out.println(rs + " "+re);
    }
}
