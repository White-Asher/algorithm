package BOJ.Greedy.BOJ_11047_S4_동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11047_S4_동전_250621_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= K) {
                cnt += (K / arr[i]);
                K %= arr[i];
            }
            if (K == 0) break;
        }
        System.out.println(cnt);
    }
}
