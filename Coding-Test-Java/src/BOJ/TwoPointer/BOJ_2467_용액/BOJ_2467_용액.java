package BOJ.TwoPointer.BOJ_2467_용액;

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
        int start = 0;
        int end = N-1;
        int rs = 0;
        int re = 0;

        while (start < end) {
            long sum = Math.abs(arr[start] + arr[end]);
            if (sum < result) {
                result = sum;
                rs = start;
                re = end;
            }
            if (arr[start] + arr[end] > 0){
                end--;
            } else {
                start++;
            }
        }

        System.out.println(arr[rs] + " "+ arr[re]);
    }
}
