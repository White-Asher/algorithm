package Softeer.unsolve;

import java.util.*;
import java.io.*;

public class 로봇이지나간경로 {

    static StringTokenizer st;
    // 북 동 남 서
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    static String[][] arr;
    static int H, W;
    static StringBuilder sb;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new String[H][W];

        for (int h = 0; h < H; h++) {
            String[] input = br.readLine().split("");
            for (int w = 0; w < W; w++) {
                arr[h][w] = input[w];
            }
        }

        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                // 시작점을 찾았다면 BFS
                int dire = ss(h, w);
                if(dire != -1) {
                    BFS(h, w, dire);
                    // System.exit(0);
                }
            }
        }
    }

    public static void BFS(int y, int x, int dire) {
        sb = new StringBuilder();
        sb.append(y+1).append(" ").append(x+1).append("\n");
        sb.append(ddd(dire)).append("\n");

        boolean[][] visit = new boolean[H][W];
        Queue<Robot> queue = new ArrayDeque<>();
        queue.add(new Robot(y, x, dire));
        visit[y][x] = true;

        while(!queue.isEmpty()) {

            Robot robot = queue.poll();
            int qy = robot.y;
            int qx = robot.x;
            int qd = robot.dire;

            for(int d = 0; d < 4; d++) {
                int ny = qy + dy[d] * 2;
                int nx = qx + dx[d] * 2;
                int nny = qy + dy[d];
                int nnx = qx + dx[d];
                if(ny < 0 || nx < 0 || ny >= H || nx >= W) continue;
                if(!arr[ny][nx].equals("#")) continue;
                if(visit[ny][nx]) continue;
                visit[ny][nx] = true;
                visit[nny][nnx] = true;
                // System.out.println("qd: "+ qd + "  d: "+ d);
                if(qd != d){
                    sb.append(pri(qd, d));
                }
                sb.append("A");
                queue.add(new Robot(ny, nx, d));
            }
        }
        System.out.println(sb);
    }

    public static String pri(int cd, int md){
        // 북 동 남 서
        if(cd == 0) {
            if(md == 3){
                return "L";
            } else if(md == 1) {
                return "R";
            }
        } else if (cd == 1) {
            if(md == 0) {
                return "L";
            } else if (md == 2) {
                return "R";
            }
        } else if (cd == 2) {
            if(md == 1) {
                return "L";
            } else if (md == 3) {
                return "R";
            }
        } else {
            if(md == 2) {
                return "L";
            } else if (md == 0) {
                return "R";
            }
        }
        return "E";
    }

    public static int ss(int y, int x) {
        int cnt = 0;
        int dire = 0;
        if(!arr[y][x].equals("#")){
            return -1;
        }
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
            if(arr[ny][nx].equals("#")) {
                cnt++;
                dire = d;
            }
        }
        if(cnt == 1) {
            return dire;
        }
        return -1;
    }

    public static String ddd(int dire){
        // 북 동 남 서
        if(dire == 0) {
            return "^";
        } else if(dire == 1){
            return ">";
        } else if (dire == 2) {
            return "v";
        } else if (dire == 3) {
            return "<";
        }
        return "ERROR";
    }
}

class Robot {
    int x;
    int y;
    int dire;

    public Robot (int y, int x, int dire){
        this.x = x;
        this.y = y;
        this.dire = dire;
    }

}