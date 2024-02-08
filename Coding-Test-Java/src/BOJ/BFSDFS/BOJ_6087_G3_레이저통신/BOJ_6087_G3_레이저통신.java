package BOJ.BFSDFS.BOJ_6087_G3_레이저통신;

import java.io.*;
import java.util.*;

// https://jamievardy.tistory.com/215
public class BOJ_6087_G3_레이저통신 {
    static StringTokenizer st;
    static int W, H;
    static int[][] visited;
    static char[][] arr;
    static List<Spot> location;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        location = new ArrayList<>();
        arr = new char[H][W];
        visited = new int[H][W];
        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                arr[i][j] = input.charAt(j);
                if(arr[i][j] == 'C') {
                    location.add(new Spot(i, j, 0));
                }
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        // input :: end
        bfs(location.get(0).y, location.get(0).x);

        System.out.println(min);
    }

    public static void bfs(int y, int x) {
        Queue<Spot> queue = new PriorityQueue<>((o1, o2) -> o1.dirCnt - o2.dirCnt);
        queue.add(new Spot(y, x, 0));
        visited[y][x] = 0;

        while(!queue.isEmpty()) {
            Spot cur = queue.poll();
            int cy = cur.y;
            int cx = cur.x;
            int cd = cur.dire;
            int cc = cur.dirCnt;

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(ny >= H || nx >= W || ny < 0 || nx < 0 || arr[ny][nx] == '*') continue;

//                System.out.println("y : " + cy + " x : " + cx);
//                System.out.println("ny : " + ny + " nx : " + nx);
//                System.out.println("===========");
                if(ny == location.get(1).y && nx ==  location.get(1).x) {
                    if(d != cd) {
                        cc++;
                    }
                    min = Math.min(cc, min);
                } else {

                    if(cd != 5 && cd != d) {
                        if(visited[ny][nx] >= cc + 1) {
                            visited[ny][nx] = cc + 1;
                            queue.add(new Spot(ny, nx, d, cc+ 1));
                        }
                    }
                    else {
                        if(visited[ny][nx] >= cc) {
                            visited[ny][nx] = cc;
                            queue.add(new Spot(ny, nx, d, cc));
                        }
                    }
                }

            }

        }

    }

    static class Spot{
        int y;
        int x;
        int dire;
        int dirCnt;
        public Spot(int y_, int x_, int dirCnt_) {
            y = y_;
            x = x_;
            dire = 5;
            dirCnt = dirCnt_;
        }
        public Spot(int y_, int x_, int dire_, int dirCnt_) {
            y = y_;
            x = x_;
            dire = dire_;
            dirCnt = dirCnt_;
        }

    }



}

