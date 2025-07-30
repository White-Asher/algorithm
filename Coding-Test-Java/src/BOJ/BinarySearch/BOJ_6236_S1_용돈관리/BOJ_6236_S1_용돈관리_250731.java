package BOJ.BinarySearch.BOJ_6236_S1_용돈관리;

import java.util.*;
import java.io.*;

public class BOJ_6236_S1_용돈관리_250731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        int left = max; 
        int right = sum;

        int ans = 0;
        while(left <= right) {
            
            int cur = 0;
            int cnt = 1;
            int mid = (left + right) / 2;
            for (int i = 0; i < N; i++) {
                cur += arr[i];
                if(cur > mid) {
                    cnt++;
                    cur = arr[i];
                }
            }

            if(cnt <= M) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
            
        }

        System.out.println(ans);
    }
}
