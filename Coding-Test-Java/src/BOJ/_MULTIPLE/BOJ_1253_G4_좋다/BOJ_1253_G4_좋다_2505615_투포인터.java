package BOJ._MULTIPLE.BOJ_1253_G4_좋다;

import java.util.*;
import java.io.*;

public class BOJ_1253_G4_좋다_2505615_투포인터 {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        // END-INPUT
        int ans = 0;

        Arrays.sort(arr);

        for (int k = 0; k < N; k++) {
            long search = arr[k];
            int start = 0;
            int end = N - 1;
            while(start < end) {
                if(start == k) {
                    start++;
                    continue;
                }
                if(end == k) {
                    end--;
                    continue;
                }
                long sum = arr[start] + arr[end];

                if(sum == search) {
                    ans++;
                    break;
                } else if (sum < search) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(ans);

    }
}
