package BOJ.Backtracking.BOJ_1182_S2_부분수열의합;

import java.io.*;
import java.util.*;

public class BOJ_1182_S2_부분수열의합_250718_002 {
    static int N;
    static int SUM;
    static int ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        SUM = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sequence( 0, 0);

        if(SUM == 0) ans--;
        System.out.println(ans);

    }

    public static void sequence(int idx, int curSum) {
        if(idx == N) {
            if(curSum == SUM) ans++;
            return;
        }
        sequence(idx + 1, curSum + arr[idx]);
        sequence(idx + 1, curSum);
    }
}
