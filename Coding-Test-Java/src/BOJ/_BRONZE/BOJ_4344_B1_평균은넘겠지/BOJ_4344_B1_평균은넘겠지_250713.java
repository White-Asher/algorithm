package BOJ._BRONZE.BOJ_4344_B1_평균은넘겠지;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class BOJ_4344_B1_평균은넘겠지_250713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.000");
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            float sum = 0;
            float[] arr = new float[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Float.parseFloat(st.nextToken());
                sum += arr[j];
            }

            // 평균
            float r1 = sum / N;
            float r2 = 0;
            for (int j = 0; j < N; j++) {
                if(arr[j] > r1) {
                    r2++;
                }
            }
            sb.append(df.format(r2/N * 100L)).append("%\n");
            
        }
        System.out.println(sb);

    }
}
