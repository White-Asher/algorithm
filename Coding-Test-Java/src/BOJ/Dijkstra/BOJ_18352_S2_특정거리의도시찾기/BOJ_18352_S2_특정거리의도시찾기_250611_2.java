package BOJ.Dijkstra.BOJ_18352_S2_특정거리의도시찾기;

import java.io.*;
import java.util.*;

public class BOJ_18352_S2_특정거리의도시찾기_250611_2 {
    static int N, M, K, X;
    static List<List<Integer>> road;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> ans = new ArrayList<>();

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

        Collections.sort(ans);
        if(ans.isEmpty()) {
            System.out.println(-1);
        } else {
            for (Integer an : ans) {
                sb.append(an).append("\n");
            }
            System.out.println(sb);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while(!q.isEmpty()) {
            int cur = q.poll();
            
            // 시간단축 핵심, 결국 K거리인 마을 게산이므로 K 초과인 거리는 볼 필요가 없음
            if(dist[cur] == K) {
                ans.add(cur);
                continue;
            }

            if(road.get(cur) == null || dist[cur] > K) continue;
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
