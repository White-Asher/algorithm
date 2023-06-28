package BOJ.BFSDFS.BOJ_3184_S1_양;

import java.io.*;
import java.util.*;

public class BOJ_3184_양_DFS_Sol {
    static StringTokenizer st;
    static int R, C, oNum, vNum, oT, vT;
    static char[][] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        oNum = 0;
        vNum = 0;

        arr = new char[R][C];

        for (int i = 0; i < R; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[i][j] = str[j].charAt(0);
            }
        }

        boolean[][] visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(visited[i][j]) continue;
                oT = 0;
                vT = 0;
                DFS(i, j, visited);
                if (oT > vT) {
                    oNum += oT;
                } else {
                    vNum += vT;
                }
            }
        }
        System.out.println(oNum + " " + vNum);
    }

    public static void DFS(int y, int x, boolean[][] visited) {
        if(y < 0  || x < 0 || y >= R || x >= C) return;
        if(visited[y][x]) return;
        if(arr[y][x] == '#') return;
        if(arr[y][x] == 'v') vT++;
        if(arr[y][x] == 'o') oT++;
        visited[y][x] = true;
        DFS(y + 1, x, visited);
        DFS(y, x + 1, visited);
        DFS(y - 1, x, visited);
        DFS(y, x - 1, visited);
    }
}
