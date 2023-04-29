package Softeer.level2;

import java.util.*;
import java.io.*;

public class 비밀메뉴 {

    public static int M, N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        StringBuilder mlist = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < M; i++) {
            mlist.append(st.nextToken());
        }

        StringBuilder nlist = new StringBuilder();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < N; i++) {
            nlist.append(st.nextToken());
        }

        if(N < M) System.out.println("normal");
        else {
            if(nlist.toString().contains(mlist.toString())) {
                System.out.println("secret");
            } else {
                System.out.println("normal");
            }
        }
    }
}