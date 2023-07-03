package _UnsolvedProblem.BOJ_13023_G5_ABCDE;

import java.io.*;
import java.util.*;

public class BOJ_13023_ABCDE {
    static StringTokenizer st;
    static int N, M;
    static boolean[] check;
    static List<Integer>[] list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N];
        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }
        for(int i = 0; i < N; i++) {
            check = new boolean[N];
            DFS(i, 0);
        }
        System.out.println(0);

    }

    public static void DFS(int x, int len) {
        if(len == 4) {
            System.out.println(1);
            System.exit(0);
        }
        check[x] = true;
        for (int i = 0; i < list[x].size(); i++) {
            int target = list[x].get(i);

            if(check[target]) continue;
            check[target] = true;
            DFS(target, len+1);
            check[target] = false;

        }
    }
}
