package BOJ.TwoPointer.BOJ_28353_S3_고양이카페;

import java.util.*;
import java.io.*;;

public class BOJ_28353_S3_고양이카페_250727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        int start = 0;
        int end = N - 1;
        int ans = 0;
        while(start < end) {
            long sum = arr[start] + arr[end];
            if(sum > K) {
                end--;
            } else {
                ans++;
                end--;
                start++;
            }
        }
        System.out.println(ans);
    }
}
