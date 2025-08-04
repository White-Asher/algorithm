package BOJ.Greedy.BOJ_2212_G5_센서;

import java.util.*;
import java.io.*;

public class BOJ_2212_G5_센서_250804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N-1];
        Arrays.fill(arr, 0);
        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);

        int a = temp[0];
        for (int i = 0; i < N - 1; i++) {
            int b = temp[i+1];
            arr[i] = b - a;
            a = b;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int ans = 0;
        for (int i = K - 1; i < N - 1; i++) {
            ans += arr[i];
        }
        System.out.println(ans);
    }
}
