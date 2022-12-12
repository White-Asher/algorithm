package BOJ.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2210 {
    static int[][] map;
    static Set<String> numSet;
    static int[] dy = {-1,1, 0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numSet = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String str = new String();
                DFS(0, str, i, j);
            }
        }

        System.out.println(numSet.size());

    }

    public static void DFS(int depth, String str, int y, int x){
        if(depth == 6) {
            numSet.add(str);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny >= 5 || nx >= 5 || ny < 0 || nx < 0) continue;
            DFS(depth+1, str+map[ny][nx], ny, nx);
        }

    }
}

// StringBuilder를 이용한 풀이
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.HashSet;
//        import java.util.Set;
//        import java.util.StringTokenizer;
//
//public class Main {
//
//    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//    static StringBuilder sb = new StringBuilder();
//    static StringTokenizer tokens;
//
//    static char[][] map = new char[5][5];
//
//    static Set<String> numsSet = new HashSet<String>();
//
//    public static void main(String[] args) throws IOException {
//        for(int i = 0; i < 5; i++) {
//            tokens = new StringTokenizer(bf.readLine());
//            for(int j = 0; j < 5; j++)
//                map[i][j] = tokens.nextToken().charAt(0);
//        }
//
//        for(int i = 0; i < 5; i++) {
//            for(int j = 0; j < 5; j++) {
//                dfs(i, j, new StringBuilder(), 0);
//            }
//        }
//
//        System.out.println(numsSet.size());
//    }
//
//    static int[] dy = {0, 1,  0, -1};
//    static int[] dx = {1, 0, -1,  0};
//
//    static boolean isIn(int y, int x) {
//        return (0 <= y && y < 5) && (0 <= x && x < 5);
//    }
//
//    static void dfs(int y, int x, StringBuilder str, int depth) {
//        StringBuilder nStr = new StringBuilder(str);
//        nStr.append(map[y][x]);
//
//        if(depth == 5) {
//            numsSet.add(nStr.toString());
//            return;
//        }
//
//        for(int d = 0; d < 4; d++) {
//            int ny = y + dy[d];
//            int nx = x + dx[d];
//
//            if(!isIn(ny, nx))
//                continue;
//
//            dfs(ny, nx, nStr, depth + 1);
//        }
//    }
//}