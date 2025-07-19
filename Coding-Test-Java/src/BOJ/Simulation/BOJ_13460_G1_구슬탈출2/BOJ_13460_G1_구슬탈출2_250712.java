package BOJ.Simulation.BOJ_13460_G1_구슬탈출2;

import java.util.*;
import java.io.*;

public class BOJ_13460_G1_구슬탈출2_250712 {
    static int N, M;
    static int[] dy = {-1, 1, 0, 0}; // 상, 하
    static int[] dx = {0, 0, - 1, 1}; // 좌, 우
    static boolean[][][][] visited;
    static char[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int initRedY = 0;
        int initRedX = 0;
        int initBlueY = 0;
        int initBlueX = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char tar = line.charAt(j);
                board[i][j] = tar;
                if(tar == 'R') {
                    initRedY = i; initRedX = j;
                    board[i][j] = '.';
                } else if(tar == 'B') {
                    initBlueY = i; initBlueX = j;
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(initRedY, initRedX, initBlueY, initBlueX));
    }


    // 탐색
    static public int bfs(int a, int b, int c, int d) {
        Queue<Gusle> queue = new ArrayDeque<>();
        queue.add(new Gusle(0, a,b,c,d));
        visited[a][b][c][d] = true;

        while(!queue.isEmpty()) {
            Gusle cur = queue.poll();

            // 카운트가 10번이상 초과되면 실패
            if(cur.moveCnt == 10) {
                continue;
            }

            // 상하좌우 탐색
            for (int dire = 0; dire <4; dire++) {
                // 빨간구슬, 파란구슬 다음 위치 확인.
                int rny = cur.redY;
                int rnx = cur.redX;
                int bny = cur.blueY;
                int bnx = cur.blueX;

                // 빨간 구슬을 벽 또는 구멍을 만날때까지 계속 반복함
                while (true) {
                    int nextRedY = rny + dy[dire];
                    int nextRedX = rnx + dx[dire];
                    if(nextRedY < 0 || nextRedX < 0 || nextRedY >= N || nextRedX >= M) break;
                    if (board[nextRedY][nextRedX] == '#') break;
                    rny = nextRedY;
                    rnx = nextRedX;
                    if (board[rny][rnx] == 'O') break;
                }

                // 파란구슬을 벽 또는 구멍을 만날때까지 반복함
                while (true) {
                    int nextBlueY = bny + dy[dire];
                    int nextBlueX = bnx + dx[dire];
                    if(nextBlueY < 0 || nextBlueX < 0 || nextBlueY >= N || nextBlueX >= M) break;
                    if (board[nextBlueY][nextBlueX] == '#') break;
                    bny = nextBlueY;
                    bnx = nextBlueX;
                    if (board[bny][bnx] == 'O') break;
                }

                // 파란구슬이 구멍에 빠지면 실패임 (다른 방향 탐색)
                if(board[bny][bnx] == 'O') {
                    continue;
                } else if(board[rny][rnx] == 'O' && board[bny][bnx] != 'O') {
                    return cur.moveCnt + 1;
                }

                // 두 구슬이 같은 방향으로 할때 같은 라인에 있다면 구슬 하나를 이전방향으로 밀어내야함
                if(rny == bny && rnx == bnx) {
                    switch (dire){
                        case 0: // 상
                            if(cur.redY > cur.blueY) rny++; else bny++;
                            break;
                        case 1: // 하
                            if(cur.redY < cur.blueY) rny--; else bny--;
                            break;
                        case 2: // 좌
                            if(cur.redX > cur.blueX) rnx++; else bnx++;
                            break;
                        case 3: // 우
                            if(cur.redX < cur.blueX) rnx--; else bnx--;
                            break;
                    }
                }

                if(!visited[rny][rnx][bny][bnx]){
                    visited[rny][rnx][bny][bnx] = true;
                    queue.add(new Gusle(cur.moveCnt+1, rny, rnx, bny, bnx));
                }

            }

        }

        return -1;
    }

    static class Gusle {
        int moveCnt;
        int redY;
        int redX;
        int blueY;
        int blueX;

        public Gusle(int a, int b, int c, int d, int e){
            moveCnt = a;
            redY = b;
            redX = c;
            blueY = d;
            blueX = e;
        }
    }

}
