package BOJ.Backtracking.BOJ_1182_S2_부분수열의합;

import java.util.*;
import java.io.*;

public class BOJ_1182_S2_부분수열의합_250718 {
    static int N;
    static int SUM;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        SUM = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sequence(arr, 0, new boolean[N]);

        System.out.println(ans);

    }

    public static void sequence(int[] arr, int idx, boolean[] check) {
        if(idx == N) {
            int temp = 0;
            boolean no = true;
            for (int i = 0; i < N; i++) {
                if(check[i]) {
                    temp+=arr[i];
                    no = false;
                }
            }
            if(no) return;

            if(temp == SUM) {
                ans++;
            }
            return;
        }

        check[idx] = true;
        sequence(arr, idx + 1, check);
        check[idx] = false;
        sequence(arr, idx + 1, check);
    }
}
