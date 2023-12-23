package BOJ.BFSDFS.BOJ_2606_S3_바이러스;

import java.io.*;
import java.util.*;

public class BOJ_2606_S3_바이러스 {
    static boolean[] visited;
    static int n, m;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for(int i=0; i<m; i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        int ans = 0;
        visited[1] = true;
        bfs(1);
        for(boolean b : visited) {
            if(b) ans++;
        }

        System.out.println(ans-1);

    }

    public static void bfs(int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);

        while(!queue.isEmpty()) {
            int q = queue.poll();
            for(int j = 1; j <= n; j++) {
                if(arr[q][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}
