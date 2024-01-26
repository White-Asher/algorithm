package BOJ.Implementation.BOJ_21609_G2_상어중학교;

import java.util.*;
import java.io.*;

public class BOJ_21609_G2_상어중학교 {
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int[][] bombBlock;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static List<Block> blockList;
    static int gcount;
    static int gRainbowCnt;
    static int score;
    static int gx;
    static int gy;

    static class Block{
        int y, x, count, rainbowCnt;

        public Block(int y, int x, int count, int rainbowCnt) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.rainbowCnt = rainbowCnt;
        }

        @Override
        public String toString() {
            return "Block{" +
                    "y=" + y +
                    ", x=" + x +
                    ", count=" + count +
                    ", rainbowCnt=" + rainbowCnt +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // input :: end

        // 탐색하기
        int iii = 0;
        while(true) {
            blockList = new ArrayList<>();
            boolean flag = true;
            gcount = 0;
            gRainbowCnt = 0;
            gx = -1;
            gy = -1;
            bombBlock = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int[] result = find(i, j, visited);
                    if(result[0] >= 2 && result[0] != result[1]) {
                        blockList.add(new Block(i, j, result[0], result[1]));
                    }

                    // 무지개 블록은 방문처리를 하지 말아야 한다.
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N; l++) {
                            if(map[k][l] == 0) visited[k][l] = false;
                        }
                    }
                }
            }
            if(blockList.isEmpty()) break;

            blockList.sort(new Comparator<Block>() {
                @Override
                public int compare(Block o1, Block o2) {
                    if(o1.count == o2.count) {
                        if(o1.rainbowCnt == o2.rainbowCnt) {
                            if(o1.y ==  o2.y) {
                                return o2.x - o1.x;
                            }
                            return o2.y - o1.y;
                        }
                        return o2.rainbowCnt - o1.rainbowCnt;
                    }
                    return o2.count - o1.count;
                }
            });
            for (int i = 0; i < blockList.size(); i++) {
                System.out.println(blockList.get(i));
            }

            Block cur = blockList.get(0);
            System.out.println(cur);
            boolean[][] v2 = new boolean[N][N];
            find(cur.y, cur.x, v2);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(v2[i][j]) bombBlock[i][j] = 1;
                }
            }

            // 점수 획득
            getScore();
            // 중력 작용
            gravity();
            // 반시계 회전
            rotate();
            gravity();
            debug();
            System.out.println("score : " + score);
        }

        System.out.println(score);
    }

    public static void rotate() {
        // 임시 배열 복사
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = map[i][j];
            }
        }
        // 배열 돌리기
        int idx = 0;
        for (int j = N - 1; j >= 0; j--) {
            for (int i = 0; i < N; i++) {
                map[idx][i] = temp[i][j];
            }
            idx++;
        }
    }

    public static void debug() {
        System.out.println("________________________________");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println("________________________________");
    }

    public static void gravity() {
        // 가로
        for (int x = 0; x < N; x++) {
            // 세로
            List<int[]> list = new ArrayList<>(); // 임시리스트
            for (int y = N - 1; y >= 0; y--) {
                if(map[y][x] == -9) continue;
                list.add(new int[]{map[y][x], y});
                if(map[y][x] == -1) continue;
                map[y][x] = -9;
            }
            int yy = N - 1;
            for (int i = 0; i < list.size(); i++) {
                int[] cur = list.get(i);
                int value = cur[0];
                int row = cur[1];
                if(value != -1) {
                    map[yy][x] = value;
                    yy--;
                } else if (value == -1){
                    yy=row-1;
                }
            }
        }
    }

    public static void getScore() {
        int cnt = 0;
        System.out.println("getscore debug");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(bombBlock[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(bombBlock[i][j] == 1) {
                    map[i][j] = -9;
                    cnt++;
                    bombBlock[i][j] = 0;
                }
            }
        }

        System.out.println("cnt : " + cnt);
        score += (int) Math.pow(cnt, 2);
    }

    public static int[] find(int y, int x, boolean[][] visited) {
        int block = map[y][x];
        if(block == -1 || block == -9 || block == 0) return new int[]{0,0};
//        System.out.println("block : " + block);
        int count = 1;
        int rainbowCnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == block || map[ny][nx] == 0) {
                    if(map[ny][nx] == 0) rainbowCnt++;
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                    count++;
                }
            }
        }
        if(count < 2) return new int[]{count, rainbowCnt};
//        if(gcount < count) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    bombBlock[i][j] = 0;
//                }
//            }
//            gcount = count;
//            gRainbowCnt = rainbowCnt;
//            gy = y;
//            gx = x;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if(visited[i][j]) bombBlock[i][j] = 1;
//                }
//            }
//
//        } else if (gcount == count) {
//            if(gRainbowCnt == rainbowCnt) {
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < N; j++) {
//                        bombBlock[i][j] = 0;
//                    }
//                }
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < N; j++) {
//                        if(visited[i][j]) bombBlock[i][j] = 1;
//                    }
//                }
//
//            }
//            gy = y;
//            gx = x;
//        }
        return new int[]{count, rainbowCnt};
    }
}
