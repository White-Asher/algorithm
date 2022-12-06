package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
    static StringTokenizer st;
    static int startX, startY, W, H;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<int[]> humanqueue;
    static Queue<int[]> firequeue;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new char[W][H];

            humanqueue = new ArrayDeque<>();
            firequeue = new ArrayDeque<>();

            for (int h = 0; h < H; h++) {
                String input = br.readLine();
                for (int w = 0; w < W; w++) {
                    map[h][w] = input.charAt(w);

                    if (map[h][w] == '@') {
                        humanqueue.add(new int[]{h, w});
                        startX = w;
                        startY = h;
                    } else if (map[h][w] == '*') {
                        firequeue.add(new int[]{h, w});
                    }

                }
            }
            int result = BFS();
            System.out.println(result == 0 ? "IMPOSSIBLE" : result);

        }
    }

    public static int BFS() {
        int[][] visited = new int[H][W];
        visited[startY][startX] = 1;

        while (!humanqueue.isEmpty()) {

            // 불 큐
            int firequeuesize = firequeue.size();
            for (int i = 0; i < firequeuesize; i++) {
                int[] q = firequeue.poll();
                int curY = q[0];
                int curX = q[1];

                for (int d = 0; d < 4; d++) {
                    int ny = curY + dy[d];
                    int nx = curX + dx[d];
                    if (map[ny][nx] == '*') continue;
                    if (map[ny][nx] == '#') continue;
                    if (map[ny][nx] == '@') return 0;
                    firequeue.add(new int[]{ny, nx});
                    map[ny][nx] = '*';
                }
            }


            // 탈출 큐
            int humanqueuesize = humanqueue.size();
            for (int i = 0; i < humanqueuesize; i++) {
                int[] q = humanqueue.poll();
                int curY = q[0];
                int curX = q[1];

                for (int d = 0; d < 4; d++) {
                    int ny = curY + dy[d];
                    int nx = curX + dx[d];

                    if (map[ny][nx] == '*') continue;
                    if (map[ny][nx] == '#') continue;

                    if (ny < 0 || nx < 0 || ny >= H || nx >= W) {
                        return visited[curY][curX];
                    }

                }


            }
        }

        return 0;
    }
}
