package BOJ.Dijkstra.BOJ_18352_S2_특정거리의도시찾기;

import java.io.*;
import java.util.*;

public class BOJ_18352_S2_특정거리의도시찾기_250611 {
    static int N, M, K, X;
    static List<List<Integer>> road;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        road = new ArrayList<>();
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            road.add(new ArrayList<>());
        }

        for (int i = 1; i < M+1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            road.get(start).add(end);
        }

        bfs(X);
        boolean emptyChk = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < N+1; i++) {
            if(dist[i] == K) {
                sb.append(i).append("\n");
                emptyChk = false;
            }
        }
        System.out.println(emptyChk ? - 1 : sb);

    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(road.get(cur) == null) continue;
            for(int i = 0; i < road.get(cur).size(); i++) {
                int next = road.get(cur).get(i);
                if(dist[next] != 0) continue;
                if(next == X) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
    }

}
