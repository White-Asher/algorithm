package BOJ.BinarySearch.BOJ_2343_S1_기타레슨;

import java.util.*;
import java.io.*;

public class BOJ_2343_S1_기타레슨_250730 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
            sum += arr[i];
        }

        int left = max;
        int right = sum;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(check(arr, mid, M)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    public static boolean check(int[] arr, int mid, int M) {
        int temp = 0;
        int cnt = 1;
        for (int j : arr) {
            temp += j;
            if (temp > mid) {
                temp = j;
                cnt++;
            }
        }
        return cnt <= M;
    }
}
