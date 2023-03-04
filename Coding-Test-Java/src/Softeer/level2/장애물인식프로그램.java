package Softeer.level2;

import java.util.*;
import java.io.*;

public class 장애물인식프로그램 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] visited;
    static int[][] arr;
    static int n;

    public static void main(String args[]) throws Exception {

        // 셋팅
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        // 값 넣기
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 탐색

        List<Integer> value = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    value.add(BFS(i, j));
                }
            }
        }

        Collections.sort(value);

        // 출력
        System.out.println(value.size());
        for(int i = 0; i< value.size(); i++) {
            System.out.println(value.get(i));
        }
    }

    public static int BFS(int x, int y) {
        int startX = x;
        int startY = y;
        visited[startX][startY] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        int cnt = 1;

        while(queue.size() != 0) {
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];

            for(int d = 0; d < 4; d++) {
                int nx = qx + dx[d];
                int ny = qy + dy[d];

                // 범위 이탈 & 방문한곳 제외
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(visited[nx][ny]) continue;
                if(arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
                cnt++;
            }
        }
        return cnt;
    }
}
