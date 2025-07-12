package BOJ.Math.BOJ_2749_G2_피보나치수3;

import java.util.*;
import java.io.*;

public class BOJ_2749_G2_피보나치수3_250706 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        int mod = 1000000;
        int pisanoPeriod = 1500000;

        int tarIdx = (int) (n % pisanoPeriod);
        int[] fibo = new int[pisanoPeriod + 1];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= tarIdx; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % mod;
        }
        System.out.println(fibo[tarIdx]);

    }
}
