package BOJ.Math.BOJ_1016_G1_제곱ㄴㄴ수;

import java.util.*;
import java.io.*;

public class BOJ_2023_제곱ㄴㄴ수 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] flag = new boolean[(int) (max - min + 1)];
        List<Long> modNum = new ArrayList<>();
        for (long i = 2; i <= Math.sqrt(max); i++) {
            modNum.add(i*i);
        }

        for (int i = 0; i < modNum.size(); i++) {
            long mod = modNum.get(i);
            double target = (double) min / (double) mod;
            long sNum = (long) Math.ceil(target) * (long) mod - min;

            for (long j = sNum; j < flag.length; j += mod) {
                flag[(int) j] = true;
            }

        }
        int cnt = 0;
        for (int i = 0; i < flag.length; i++) {
            if(!flag[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

