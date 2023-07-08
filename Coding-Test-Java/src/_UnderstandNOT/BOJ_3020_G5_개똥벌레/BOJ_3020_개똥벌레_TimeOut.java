package _UnderstandNOT.BOJ_3020_G5_개똥벌레;

import java.io.*;
import java.util.*;

public class BOJ_3020_개똥벌레_TimeOut {
    static StringTokenizer st;
    static int N, H;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] sum = new int[H+1];

        for (int i = 1; i <= N; i++) {
            int temp = Integer.parseInt(br.readLine());

            if(i % 2 == 1) {
                for (int j = 1; j <= temp; j++) {
                    sum[j]++;
                }
            }
            else {
                for (int j = H; j > H - temp; j--) {
                    sum[j]++;
                }
            }
        }
        Arrays.sort(sum);

        int cnt = 0;
        for (int i = 1; i < sum.length-1; i++) {
            if(sum[i] == sum[1]){
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(sum[1]+" "+cnt);
    }
}
