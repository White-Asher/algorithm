package BOJ.Math.BOJ_11441_S3_합구하기;

import java.util.*;
import java.io.*;

public class BOJ_11441_S3_합구하기_250712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i <= n; i++) {
            int nu = Integer.parseInt(st.nextToken());
            arr[i] = nu + arr[i-1];
        }
       // System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(arr[b] - arr[a-1]).append("\n");
        }
        System.out.println(sb);
    }
}
