package BOJ.Backtracking.BOJ_14888_S1_연산자끼워넣기;

import java.io.*;
import java.util.*;

public class BOJ_14888_S1_연산자끼워넣기_250623 {
    static int N;
    static int[] arr;
    static int[] command;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        command = new int[4];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(MAX);
        System.out.println(MIN);

    }

    static void dfs(int ans, int idx) {
        if(idx == N) {
            MAX = Math.max(MAX, ans);
            MIN = Math.min(MIN, ans);
        }

        // 덧셈
        if(command[0] > 0) {
            command[0]--;
            dfs(ans + arr[idx], idx+1);
            command[0]++;
        }
        // 뺄셈
        if(command[1] > 0) {
            command[1]--;
            dfs(ans - arr[idx], idx+1);
            command[1]++;
        }
        // 곱셉
        if(command[2] > 0) {
            command[2]--;
            dfs(ans * arr[idx], idx+1);
            command[2]++;
        }
        // 나눗셈
        if(command[3] > 0) {
            command[3]--;
            dfs((ans / arr[idx]), idx+1);
            command[3]++;
        }

    }
}
