package BOJ.Greedy.BOJ_13164_G5_행복유치원;

import java.util.*;
import java.io.*;

public class BOJ_13164_G5_행복유치원_250615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] marr = new int[N];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            marr[i] = arr[i] - arr[i - 1];
        }

        Arrays.sort(arr);
        Arrays.sort(marr);

        long sum = 0;

        for (int i = 1; i <= arr.length - K; i++) {
            sum += marr[i];
        }

        System.out.println(sum);

    }
}
