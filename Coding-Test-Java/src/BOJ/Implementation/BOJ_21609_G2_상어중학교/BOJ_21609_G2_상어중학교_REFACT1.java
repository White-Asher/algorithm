/*
제목 : 상어중학교
알고리즘 유형 : #Implementaion
플랫폼 : #BOJ
난이도 : G2
문제번호 : 21609
시간 : 240m
해결 : O
저장 : O
해결언어 : java
문제링크 : https://www.acmicpc.net/problem/21609
특이사항 : #
*/

package BOJ.Implementation.BOJ_21609_G2_상어중학교;

import java.io.*;
import java.util.*;

public class BOJ_21609_G2_상어중학교_REFACT1 {
    static StringTokenizer st;
    static int N, M, gcount, gRainbowCnt, score, gx, gy;
    static int[][] map;
    static int[][] bombBlock;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static List<Block> blockList;

    static class Block{
        int y, x, count, rainbowCnt;

        public Block(int y, int x, int count, int rainbowCnt) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.rainbowCnt = rainbowCnt;
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

        while(true) {
            blockList = new ArrayList<>();
            bombBlock = new int[N][N];
            gcount = 0;
            gRainbowCnt = 0;
            gx = -1;
            gy = -1;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int[] result = find(i, j, visited);
                    // 블록이 2개 이상 또는 일반블록 한개이상 구성되었을 때 리스트 넣기
                    if(result[0] >= 2 && result[0] != result[1]) {
                        blockList.add(new Block(i, j, result[0], result[1]));
                    }
                    // 무지개 블록은 다시 탐색할 수 있어야 하므로 방문처리 해제
                    for (int k = 0; k < N; k++) {
                        for (int l = 0; l < N; l++) {
                            if(map[k][l] == 0) visited[k][l] = false;
                        }
                    }
                }
            }
            if(blockList.isEmpty()) break;

            // 조건에 맞춰 리스트 정렬
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

            Block cur = blockList.get(0);
            // 조건에 맞는 좌표 다시 들고와서 탐색한 후에 깨야할 블록에 저장
            boolean[][] v2 = new boolean[N][N];
            find(cur.y, cur.x, v2);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(v2[i][j]) bombBlock[i][j] = 1;
                }
            }
            getScore(); // 점수 획득
            gravity(); // 중력 작용
            rotate(); // 반시계 회전
            gravity();
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


    public static void gravity() {
        // 가로
        for (int x = 0; x < N; x++) {
            // 세로
            List<int[]> list = new ArrayList<>(); // 임시리스트
            for (int y = N - 1; y >= 0; y--) {
                // 빈칸이라면 건너뛰기
                if(map[y][x] == -9) continue;
                list.add(new int[]{map[y][x], y});
                // 검은색 벽돌일 때는 해당칸 검정색 벽돌로, 다른 벽돌이면 빈칸으로 변경
                if(map[y][x] == -1) continue;
                map[y][x] = -9;
            }
            // 시작 구간 설정
            int yy = N - 1;
            for (int i = 0; i < list.size(); i++) {
                int[] cur = list.get(i);
                int value = cur[0];
                int row = cur[1];
                // 검은색 벽돌이라면 해당 구간부터 리스트 꺼내서 값 대입
                if(value != -1) {
                    map[yy][x] = value;
                    yy--;
                }
                // 검정색 벽돌 만났다면 다음 칸부터 시작
                else if (value == -1){
                    yy=row-1;
                }
            }
        }
    }

    public static void getScore() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(bombBlock[i][j] == 1) {
                    map[i][j] = -9;
                    cnt++;
                    bombBlock[i][j] = 0;
                }
            }
        }
        score += (int) Math.pow(cnt, 2);
    }

    public static int[] find(int y, int x, boolean[][] visited) {
        int block = map[y][x];
        if(block == -1 || block == -9 || block == 0) return new int[]{0,0};
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
        return new int[]{count, rainbowCnt};
    }
}
