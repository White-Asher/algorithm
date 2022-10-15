package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            long diff = 0;
            int maxVal = 0;
            int[] num = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
            for (int j = N - 1; j >= 0; j--) {
                if (num[j] > maxVal) maxVal = num[j];
                diff += maxVal - num[j];
            }
            System.out.printf("#%d %d\n", t, diff);
        }
    }

}

