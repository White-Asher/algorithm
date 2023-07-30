package BOJ.Implementation.BOJ_14500_G4_테트로미노;

import java.io.*;
import java.util.*;

public class BOJ_14500_테트로미노 {
    static int N, M;
    static StringTokenizer st;
    static int[][] arr;
    // 상, 하, 좌, 우
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    // ㅏ 모양 방향
    static int[][] dd = {{0,2,1},{2,1,3},{0,3,1},{2,0,3}};
    static boolean[][] visited;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        ans = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 전체 블럭 돌면서 가장 큰 값 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                search(i, j);
            }
        }
        System.out.println(ans);
    }
    
    // 가장 큰 값 찾기
    public static void search(int y, int x) {
        visited[y][x] = true;
        DFS(y, x, 0, 0);
        visited[y][x] = false;
        findH(y, x);
    }
    
    // ㅏ 모양 큰 값 찾기
    public static void findH(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int sum = arr[y][x];
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                int ny = y + dy[dd[i][j]];
                int nx = x + dx[dd[i][j]];

                if(ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    flag = true;
                    break;
                }
                sum += arr[ny][nx];
            }
            if(!flag) {
                ans = Math.max(sum, ans);
            }
        }
    }

    // 다른 모양들 재귀식으로 찾기
    public static void DFS(int y, int x, int cnt, int sum) {
        if(cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            // 여기가 핵심..
            if(!visited[ny][nx]) {
                visited[ny][nx] = true;
                DFS(ny, nx, cnt + 1, sum + arr[ny][nx]);
                visited[ny][nx] = false;
            }

        }
    }

}
