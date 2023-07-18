package BOJ.Math.BOJ_2023_G5_신기한소수;

import java.io.*;
import java.util.*;

public class BOJ_2023_신기한소수_SOL1 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("", 0);
        System.out.println(sb.toString());
    }

    public static void dfs(String s, int cnt) {
        if (cnt == N) {
            sb.append(s).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (isPrime(Integer.parseInt(s+i))){
                dfs(s+i, cnt + 1);
            }
        }
    }
    
    public static boolean isPrime(int num){
        if(num < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
