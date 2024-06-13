package BOJ.DP.BOJ_17484_S3_진우의달여행Small;

import java.io.*;
import java.util.*;

public class BOJ_17484_S3_진우의달여행Small {
    static StringTokenizer st;
    static int[] dd = new int[]{-1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] dp = new int[N][M];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {

        }
    }
}
