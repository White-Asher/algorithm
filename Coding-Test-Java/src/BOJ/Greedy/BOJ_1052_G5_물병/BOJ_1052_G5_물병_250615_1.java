package BOJ.Greedy.BOJ_1052_G5_물병;

import java.util.*;
import java.io.*;

public class BOJ_1052_G5_물병_250615_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int ans = 0;

        while(Integer.bitCount(num) > K) {
            num++;
            ans++;
        }
        System.out.println(ans);

    }
}
