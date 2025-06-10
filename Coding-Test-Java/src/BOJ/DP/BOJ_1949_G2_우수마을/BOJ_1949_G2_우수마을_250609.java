package BOJ.DP.BOJ_1949_G2_우수마을;

import java.io.*;
import java.util.*;

public class BOJ_1949_G2_우수마을_250609 {
    static int[] population ;
    static List<List<Integer>> villageList = new ArrayList<>();
    static int[] visit;
    static int[][] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N+1];
        dp = new int[N+1][2];
        visit = new int[N+1];

        // 마을 주민수 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= N; i++) {
            villageList.add(new ArrayList<>());
        }

        // 인접마을 넣기
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            villageList.get(start).add(end);
            villageList.get(end).add(start);
        }

        dfs(1);

        System.out.println(Math.max(dp[1][1], dp[1][0]));

    }

    public static void dfs(int start) {
        // 일단 방문체크
        visit[start] = 1;
        
        // dp[마을][1] : 우수마을 선정
        // dp[마을][0] : 우수마을 미선정
        dp[start][1] = population[start];
        dp[start][0] = 0;
        
        // 자식노드들 탐색
        for (int target : villageList.get(start)) {
            if(visit[target] == 0) {
                // 자식노드들까지 전부 리프노드 나올때까지 재귀
                dfs(target);
                // 대상 마을이 우수마을이라면, 자식마을들은 우수마을이 아님
                dp[start][1] = dp[start][1] + dp[target][0];
                // 대상 마을이 우수마을이 아니여도, 자식마을이 우수마을이던아니던 상관없음
                dp[start][0] = dp[start][0] + Math.max(dp[target][0], dp[target][1]);
            }
        }
        
    }
}

/* input
7
1000 3000 4000 1000 2000 2000 7000
1 2
2 3
4 3
4 5
6 2
6 7
*/