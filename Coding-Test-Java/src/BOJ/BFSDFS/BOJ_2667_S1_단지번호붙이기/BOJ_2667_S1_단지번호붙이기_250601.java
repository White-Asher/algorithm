package BOJ.BFSDFS.BOJ_2667_S1_단지번호붙이기;

import java.util.*;
import java.io.*;

public class BOJ_2667_S1_단지번호붙이기_250601 {
    static int N;
    static int[][] arr;
    static int[][] check;
    static int[] dy = {-1,1, 0,0,};
    static int[] dx = {0,0,-1,1};
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new int[N][N];
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
            }
        }
        int apt = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] != 0 && check[i][j]!=1) {
                    bfs(i, j, apt++);
                }
            }
        }
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        StringBuilder sb = new StringBuilder();
        sb.append(map.size()).append("\n");
        for(Map.Entry<Integer, Integer> entry : entryList){
            sb.append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int y, int x, int tar) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        int cnt = 1;
        check[y][x] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if(arr[ny][nx] != 1) continue;
                if(check[ny][nx] == 1) continue;
                cnt++;
                check[ny][nx] =  1;
                q.add(new int[]{ny, nx});
            }
        }
        map.put(tar, cnt);
    }
}
