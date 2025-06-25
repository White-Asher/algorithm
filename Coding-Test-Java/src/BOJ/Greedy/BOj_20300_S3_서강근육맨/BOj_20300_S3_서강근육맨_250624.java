package BOJ.Greedy.BOj_20300_S3_서강근육맨;

import java.util.*;
import java.io.*;

public class BOj_20300_S3_서강근육맨_250624 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long max = 0;

        if (n % 2 == 1) {
            max = arr[n - 1];
            n--;
        }

        for (int i = 0; i < n / 2; i++) {
            long current = arr[i] + arr[n - 1 - i];
            if (current > max) {
                max = current;
            }
        }

        System.out.println(max);
    }
}
