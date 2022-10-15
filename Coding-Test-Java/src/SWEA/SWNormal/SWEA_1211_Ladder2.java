package SWEA.SWNormal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1211_Ladder2 {
    static StringTokenizer st;
    static int[][] map;
    static List<Integer> startList;
    // 하 좌 우
    static int[] dy = {-1, 0, 0};
    static int[] dx = {0, -1, 1};
    static int ans, min;
    // 방향
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            int c = Integer.parseInt(br.readLine());
            ans = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            map = new int[100][100];

            startList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(i == 0) {
                        if(map[i][j] == 1) {
                            startList.add(j);
                        }
                    }
                }
            } //input - end

            for (int index = 0; index < startList.size(); index++) {
                simulateBFS(startList.get(index));
            }

            System.out.printf("#%d %d\n", t, ans);

        } // test-case end
    }

    private static void simulateBFS(int start) {
        int[][] visited = new int[100][100];
        visited[0][start] = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, start});

        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int qy = q[0];
            int qx = q[1];

            int ny = qy;
            int nx = qx;

            if(isLeftTurn(qy, qx) && visited[qy][qx-1] == 0) nx-=1;
            else if(isRightTurn(qy, qx) && visited[qy][qx+1] == 0) nx+=1;
            else ny +=1;

            if(ny >= 100) {
                if(visited[99][nx] <= min){
                    min = visited[99][nx];
                    ans = Math.max(start, ans);
                }
                break;
            }
            visited[ny][nx] = visited[qy][qx] + 1;
            queue.add(new int[]{ny, nx});
        }

    }

    public static boolean isLeftTurn(int y, int x){
        boolean flag1 = true;
        if(x - 1 < 0) flag1 = false;
        else
            if(map[y][x-1] == 0) flag1 = false;
        return flag1;
    }
    public static boolean isRightTurn(int y, int x){
        boolean flag2 = true;
        if(x + 1 >= 100) flag2 = false;
        else
            if (map[y][x+1] == 0) flag2 = false;
        return flag2;
    }
}
