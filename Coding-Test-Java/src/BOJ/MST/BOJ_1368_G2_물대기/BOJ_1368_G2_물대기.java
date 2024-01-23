/*
제목 : 물대기
알고리즘 유형 : #MST
플랫폼 : #BOJ
난이도 : G2
문제번호 : 1368
시간 : 40m
해결 : O
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/1368
특이사항 : -
*/

package BOJ.MST.BOJ_1368_G2_물대기;

import java.io.*;
import java.util.*;

public class BOJ_1368_G2_물대기 {
    static int E, V;
    static StringTokenizer st;
    static int[] parent;
    static int[] price;
    static PriorityQueue<Edge> edgeList = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        E = Integer.parseInt(br.readLine());
        price = new int[E + 1];
        parent = new int[E + 1];
        for (int i = 1; i <= E; i++) {
            price[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
        }

        for (int e = 1; e <= E; e++) {
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= E; i++) {
                int temp = Integer.parseInt(st.nextToken());
                if(e == i) edgeList.add(new Edge(0, i, price[i]));
                else edgeList.add(new Edge(e, i, temp));
            }
        }

        int ans = 0;
        while(!edgeList.isEmpty()) {
            Edge edge = edgeList.poll();
            int u = edge.start;
            int v = edge.end;
            if(find(u) == find(v))continue;
            union(u, v);
            ans += edge.value;
        }
        System.out.println(ans);

    }

    public static boolean union(int a, int b) {
        int aRoot = parent[a];
        int bRoot = parent[b];
        if(aRoot == bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }

    public static int find(int a) {
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int value;
        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }


        @Override
        public int compareTo(Edge o) {
            return value - o.value;
        }
    }
}
