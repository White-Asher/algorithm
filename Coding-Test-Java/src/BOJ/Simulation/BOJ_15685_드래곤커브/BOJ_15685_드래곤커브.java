package BOJ.Simulation.BOJ_15685_드래곤커브;

import java.util.*;
import java.io.*;

public class BOJ_15685_드래곤커브 {
    static StringTokenizer st;
    static boolean[][] check = new boolean[102][102];
    // 우 > 상 > 좌 > 하 (반시계)
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            gen(x, y, d, g);
        }

        // 전체 탐색 하여 만족하는 정사각형 개수 구하기
        for (int y = 0; y <= 100; y++) {
            for (int x = 0; x <= 100; x++) {
                if(check[y][x] && check[y+1][x] && check[y][x+1] && check[y+1][x+1]) ans++;
            }
        }

        System.out.println(ans);
    }

    public static void gen(int x, int y, int d, int g) {
        // 0세대 방향 넣기
        // 리스트는 방향 저장용
        List<Integer> temp = new ArrayList<>();
        temp.add(d);

        while(g-- > 0) {
            int size = temp.size();
            for (int i = size - 1; i >= 0; i--) {
                int tard = (temp.get(i) + 1 ) % 4;
                temp.add(tard);
            }
        }
        // 리스트 방향 꺼내면서 좌표 체크하기
        check[y][x] = true;
        for (Integer integer : temp) {
            x += dx[integer];
            y += dy[integer];
            check[y][x] = true;
        }
    }

}

class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
