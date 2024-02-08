package _UnderstandNOT.BOJ_3020_G5_개똥벌레;

import java.util.*;
import java.io.*;

public class BOJ_3020_G5_개똥벌레 {
    static int N, H, min, cnt;
    static StringTokenizer st;
    static int[] top;
    static int[] bottom;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        top = new int[H+1];
        bottom = new int[H+1];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N / 2; i++) {
            int topInput = Integer.parseInt(br.readLine());
            int bottomInput = Integer.parseInt(br.readLine());
            top[topInput]++;
            bottom[bottomInput]++;
        }

        for (int i = 1; i <= H; i++) {
            top[i] += top[i - 1];
            bottom[i] += bottom[i - 1];
        }
        int[] sum = new int[H + 1];

        for (int i = 1; i <= H; i++) {
            sum[i] = bottom[H] - bottom[i - 1] + top[H] - top[i - 1];
            if (sum[i] < min) {
                cnt = 1;
                min = sum[i];
            } else if(sum[i] == min) {
                cnt++;
            }
        }
        System.out.println(min + " "+cnt);
    }
}
