/*
제목 : 양치기꿍
알고리즘 유형 : #bfs
플랫폼 : #BOJ
난이도 : S1
문제번호 : 3187
시간 : 10m
해결 : O
저장 : X
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/3187
특이사항 :
*/

package BOJ.BFSDFS.BOJ_3187_S1_양치기꿍;

import java.io.*;
import java.util.*;

public class BOJ_3187_S1_양치기꿍 {
    static StringTokenizer st;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int r, c;
    static int as, aw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String str = String.valueOf(br.readLine());
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(visited[i][j] || arr[i][j] == '#') continue;
                bfs(i, j);
            }
        }

        System.out.println(as + " " + aw);

    }

    private static void bfs(int i, int j) {
        int sheep = 0;
        int wolf = 0;

        if(arr[i][j] == 'k') sheep++;
        if(arr[i][j] == 'v') wolf++;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {

            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(ny >= r || nx >= c || ny < 0 || nx < 0) continue;
                if(arr[ny][nx] == '#' || visited[ny][nx]) continue;
                if(arr[ny][nx] == 'k') sheep++;
                if(arr[ny][nx] == 'v') wolf++;
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }

        if(sheep > wolf) {
            as += sheep;
        } else {
            aw += wolf;
        }
    }
}
