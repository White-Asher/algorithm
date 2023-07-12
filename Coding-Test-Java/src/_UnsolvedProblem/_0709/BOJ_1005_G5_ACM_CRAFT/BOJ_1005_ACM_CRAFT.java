package _UnsolvedProblem._0709.BOJ_1005_G5_ACM_CRAFT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1005_ACM_CRAFT {
    static StringTokenizer st;
    static int N, K;
    static int[] time;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // tc
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            time = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] lists = new ArrayList[N+1];
            for (int i = 0; i <= N; i++) {
                lists[i] = new ArrayList<>();
            }
            int[] indegree = new int[N  + 1];
            for (int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                lists[s].add(e);
                indegree[e]++;
            }

            int w = Integer.parseInt(br.readLine());

            int ans = topoSort(indegree, lists, w);
            System.out.println(ans);
        }
    }

    public static int topoSort(int[] indegree, List<Integer>[] lists, int w) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] result = new int[N + 1];
        
        // 건물 기본 소요시간
        for (int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                result[i] = time[i];
                queue.offer(i);
            }
        }

        // 총 소요시간 = 이전 건물까지의 소요시간 + 현재 건물 소요시간
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < lists[cur].size(); i++) {
                result[i] = Math.max(result[i], result[cur] + time[i]);
                indegree[i]--;

                if(indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return result[w];
    }
}
