package BOJ.Greedy.BOJ_11047_S4_동전;

import java.util.*;
import java.io.*;

public class BOJ_11047_S4_동전_250621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = arr.length - 1;
        int cnt = 0;
        while(K > 0) {
            while(K >= arr[idx]) {
                K -= arr[idx];
                cnt++;
            }
            if(K == 0) break;
            idx--;
        }

        System.out.println(cnt);

    }
}
