package BOJ.BFSDFS.BOJ_7576_G5_토마토;

import java.util.*;
import java.io.*;

public class BOJ_7576_G5_토마토_250603 {
    static int M, N;
    static StringTokenizer st;
    static int[][] arr;
    static Queue<Tomato> queue = new ArrayDeque<>();
    static int[][] check;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);
        arr = new int[N][M];
        check = new int[N][M];


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    queue.add(new Tomato(i, j, 0));
                    check[i][j] = 1;
                }
            }
        }

        int max = 0;
        while(!queue.isEmpty()) {
            Tomato cur = queue.poll();
            for(int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];
                int nd = cur.day + 1;
                if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if(arr[ny][nx] == -1 || arr[ny][nx] == 1) continue;
                if(check[ny][nx] == 1) continue;
                check[ny][nx] = 1;
                arr[ny][nx] = 1;
                max = Math.max(nd, max);
                queue.add(new Tomato(ny, nx, nd));
            }
        }
        boolean isAll = true;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    isAll = false;
                    break;
                }
            }
        }

        System.out.println(isAll ? max : -1);

    }

    static class Tomato {
        int y;
        int x;
        int day;
        public Tomato (int _y, int _x, int _day) {
            y = _y;
            x = _x;
            day = _day;
        }
    }
}
