package BOJ.DP.BOJ_9465_S1_스티커;

import java.io.*;
import java.util.*;

public class BOJ_9465_S1_스티커_250625_ADV {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int[][] arr =  new int[2][100001];
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[0][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[1][i] = Integer.parseInt(st.nextToken());
            }

            int prevTop = arr[0][0];
            int prevBot = arr[1][0];
            int prevNone = 0;

            for (int i = 1; i < n; i++) {
                int curTop = Math.max(prevBot, prevNone) + arr[0][i];
                int curBot = Math.max(prevTop, prevNone) + arr[1][i];
                int curNone = Math.max(prevTop, Math.max(prevBot, prevNone));

                prevTop = curTop;
                prevBot = curBot;
                prevNone = curNone;
            }
            sb.append(Math.max(prevTop, Math.max(prevBot, prevNone))).append("\n");
        }
        System.out.println(sb);
    }
}
