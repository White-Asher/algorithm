package BOJ.MST.BOJ_1647_G4_도시분할;

import java.util.*;
import java.io.*;

// https://www.acmicpc.net/board/view/98875 << 참고하기
public class BOJ_1647_G4_도시분할 {
    static int N, M; // 집의 개수, 길이 개수
    static StringTokenizer st;
    static int[] p;
    static List<Edge> edgeList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int total = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(from, to, weight));
            total += weight;
        }

        edgeList.sort((o1, o2) -> o1.weight - o2.weight);
        make();
        int ans = 0;
        int cnt = 0;
        if(N == 2) {
            System.out.println(ans);
        } else {
            for (Edge edge : edgeList) {
                if(union(edge.from, edge.to)) {
                    ans += edge.weight;
                    if(++cnt == N - 2) break;
                }
            }
            System.out.println(ans);
        }

    }

    public static void make() {
        p = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
    }

    public static int find(int a) {
        if(a == p[a]) return a;
        return p[a] = find(p[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        p[bRoot] = aRoot;
        return true;
    }

    static class Edge {
        int from, to, weight;
        public Edge(int from_, int to_, int weight_) {
            from = from_;
            to = to_;
            weight = weight_;
        }

    }
}
