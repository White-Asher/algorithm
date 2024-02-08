package _UnsolvedProblem.BOJ_11725_S2_트리의부모찾기;

import java.util.*;
import java.io.*;

public class BOJ_11725_트리의부모찾기 {
    static int N;
    static int[] parent;
    static boolean[] visit;
    static List<Integer>[] list;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        visit = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
        }

        DFS(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void DFS(int x) {
        visit[x] = true;
        for (int i = 0; i < list[x].size(); i++) {
            int target = list[x].get(i);
            if(!visit[target]) {
                parent[target] = x;
                DFS(target);
            }
        }
    }
}
