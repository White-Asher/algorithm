package BOJ.Simulation.BOJ_19236_G1_청소년상어;

import java.util.*;
import java.io.*;

public class BOJ_19236_G1_청소년상어_250720 {
    // 상1, 좌상2, 좌3, 좌하4, 하5, 우하6, 우7, 우상8
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[4][4];
        Fish[] fishes = new Fish[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dire = Integer.parseInt(st.nextToken()) - 1;
                arr[i][j] = num;
                fishes[num] = new Fish(num, i, j, dire, true);
            }
        }

        // 탐색
        dfs(arr, fishes, 0, 0 , 0);

        System.out.println(ans);
    }

    public static void dfs(int[][] curBoard, Fish[] curFishes, int sharkY, int sharkX, int curScore) {
        // 물고기 다음 배열 복사
        Fish[] nextFish = copyFish(curFishes);
        int[][] newBoard = copyBoard(curBoard);

        // 상어 들어왔으니 해당 칸 상어가 먹고 방향을 가지게 됨.
        int targetFish = newBoard[sharkY][sharkX];
        curScore += targetFish;
        newBoard[sharkY][sharkX] = 0;
        nextFish[targetFish].isAlive = false;
        int sharkDire = nextFish[targetFish].dire;

        // 물고기 이동! (작은 물고기 부터)
        for (int i = 1; i <= 16; i++) {
            if(!nextFish[i].isAlive) continue; // 죽은 물고기 이동 X

            // 해당 물고기가 갈 수 있는지 판단.
            int curNum = nextFish[i].num;
            int curY = nextFish[i].y;
            int curX = nextFish[i].x;
            int curDire = nextFish[i].dire;
            int ny = 0;
            int nx = 0;

            // 방향전환
            while(true) {
                // 물고기가 이동가능한지 판별하기
                ny = curY + dy[curDire];
                nx = curX + dx[curDire];
                boolean isMoveAble = true;
                // 해당칸이 벽인가?
                if(ny < 0 || nx < 0 || ny >= 4 || nx >= 4) isMoveAble = false;
                // 해당칸에 상어가 있는가?
                if(isMoveAble && (ny == sharkY && nx == sharkX)) {
                    isMoveAble = false;
                }
                if(isMoveAble) { // 이동가능하다면 멈추기
                    break;
                }
                // 그런데 이동불가능함. -> 계속 방향 돌림
                curDire = (curDire + 1) % 8;
            }

            // 물고기가 이동하려는 칸과 원래 있었던 물고기와 위치 바꾸기

            // 이동하려는 칸에 물고기 있는 경우
            if(newBoard[ny][nx] != 0) {
                int targetFishNum = newBoard[ny][nx]; // 자리를 바꿀 대상 물고기 번호

                // board에서 위치 교환
                newBoard[curY][curX] = targetFishNum;
                newBoard[ny][nx] = curNum;

                // fishes 배열에서 각 객체의 좌표 정보 교환
                // (이동하는 물고기 A는 새 좌표와 새 방향을 가짐)
                nextFish[curNum].y = ny;
                nextFish[curNum].x = nx;
                nextFish[curNum].dire = curDire;
                // (자리를 뺏긴 물고기 B는 A의 옛 좌표를 가짐, 방향은 그대로)
                nextFish[targetFishNum].y = curY;
                nextFish[targetFishNum].x = curX;

            }

            // 빈칸이라면 그냥 이동
            else {
                newBoard[ny][nx] = curNum;
                newBoard[curY][curX] = 0;
                nextFish[curNum] = new Fish(curNum, ny, nx, curDire, true);

            }

        }

        // 상어가 갈수 있는 위치 찾음.
        List<int[]> sharkMoveAbleList = new ArrayList<>();
        int idx = 1;
        while(true) {
            // 상어 다음 위치는?
            int ny = sharkY + dy[sharkDire]*idx;
            int nx = sharkX + dx[sharkDire]*idx;
            if(ny < 0 || nx < 0 || ny >=4 || nx >= 4) break;
            if(newBoard[ny][nx] != 0) {
                sharkMoveAbleList.add(new int[]{ny, nx});
            }
            idx++;
        }

        if (sharkMoveAbleList.isEmpty()) {
            ans = Math.max(ans, curScore);
            return;
        }

        for (int i = 0; i < sharkMoveAbleList.size(); i++) {
            int nextY = sharkMoveAbleList.get(i)[0];
            int nextX = sharkMoveAbleList.get(i)[1];
            dfs(newBoard, nextFish, nextY, nextX, curScore);
        }

    }

    // 현재 보드 복사
    public static int[][] copyBoard(int[][] curBoard) {
        int[][] newBoard = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newBoard[i][j] = curBoard[i][j];
            }
        }
        return newBoard;
    }
    // 물고기 배열 복사
    public static Fish[] copyFish(Fish[] curFishes) {
        Fish[] nextFish = new Fish[17];
        for (int i = 1; i <= 16; i++) {
            nextFish[i] = new Fish(curFishes[i].num, curFishes[i].y, curFishes[i].x, curFishes[i].dire, curFishes[i].isAlive);
        }
        return nextFish;
    }

    // 물고기 정의
    static class Fish{
        int num;
        int y;
        int x;
        int dire;
        boolean isAlive;

        public Fish(int _num, int _y, int _x, int _dire, boolean _isAlive){
            num = _num;
            y = _y;
            x = _x;
            dire = _dire;
            isAlive = _isAlive;
        }

        @Override
        public String toString() {
            return "Fish{" +
                    "num=" + num +
                    ", y=" + y +
                    ", x=" + x +
                    ", dire=" + dire +
                    ", isAlive=" + isAlive +
                    '}';
        }
    }
}
