package Softeer.level2;

import java.util.*;
import java.io.*;

public class 바이러스{
    static StringTokenizer st;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long sum = a;

        for(int i = 0; i < c; i++){
            sum = sum*b;
            sum = sum%(long)1000000007;
        }

        System.out.print(sum);
    }
}