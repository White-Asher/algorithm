package BOJ.Greedy.BOJ_1052_G5_물병;

import java.io.*;
import java.util.*;

public class BOJ_1052_G5_물병_250615_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int ans = 0;

        while(cntBit(num) > K) {
            num++;
            ans++;
        }
        System.out.println(ans);

    }
    public static int cntBit(int num) {
        int count = 0;
        while(num > 0) {
            if((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }
}
