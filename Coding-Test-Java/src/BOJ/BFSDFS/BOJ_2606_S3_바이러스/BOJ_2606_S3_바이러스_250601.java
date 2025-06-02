package BOJ.BFSDFS.BOJ_2606_S3_바이러스;


import java.util.*;
import java.io.*;

public class BOJ_2606_S3_바이러스_250601 {
    static boolean[][] com;
    static boolean[] check;
    static int N, M;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        com = new boolean[N+1][N+1];
        check = new boolean[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            com[start][end] = true;
            com[end][start] = true;
        }
        bfs();
        System.out.println(ans - 1);
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            check[cur] = true;
            ans++;

            for(int i = 1; i <= N; i++) {
                if(cur == i) continue;
                if(!com[cur][i]) continue;
                if(check[i]) continue;
                check[i] = true;
                queue.add(i);
            }

        }

    }
}
