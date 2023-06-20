package BOJ.BFSDFS.BOJ_2583_영역구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2853_영역구하기 {

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] box;
    static boolean[][] visit;
    static StringTokenizer st;
    static int N, M, K;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        box = new boolean[M][N];
        visit = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int j = y1; j < y2; j++) {
                for (int k = x1; k < x2; k++) {
                    box[j][k] = true;
                }
            }
        }

        int area = 0;
        list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!box[i][j]) {
                    if(visit[i][j]) continue;
                    BFS(i, j);
                    area++;
                }
            }
        }

        System.out.println(area);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        
    }

    public static void BFS(int y, int x) {
        Queue<int[]> queue = new ArrayDeque<>();
        visit[y][x] = true;
        queue.add(new int[]{y,x});
        int a = 1;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            int qy = q[0];
            int qx = q[1];

            for (int i = 0; i < 4; i++) {
                int ny = qy + dy[i];
                int nx = qx + dx[i];
                if(ny < 0 || nx < 0 || ny >= M || nx >= N) continue;
                if(visit[ny][nx]) continue;
                if(box[ny][nx]) continue;
                visit[ny][nx] = true;
                a++;
                queue.add(new int[]{ny, nx});
            }
        }
        list.add(a);
    }
}
