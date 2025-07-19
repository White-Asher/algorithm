package BOJ.Simulation.BOJ_12094_G1_2048_HARD;

import java.io.*;
import java.util.*;

public class BOJ_12094_G1_2048_HARD_250712 {
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(N == 1) {
            System.out.println(arr[0][0]);
            return;
        }
        // INPUT
        dfs(arr, 0);
        System.out.println(ans);
    }

    public static void dfs(int[][] board, int time) {
        if(time == 10) {
            ans = Math.max(ans, findMax(board));
            return;
        }

        // 현재 상태에서 이론적으로 구할 수 있는 최대값과 비교해서 못 만든다면?
        // 그냥 해당 DFS는 리턴하는게 빠름
        int currentMax = findMax(board);
        int remainMove = 10 - time;
        // 현재값 *  남은 이동수에 2의 제곱 => 이론상 최대값
        // 10번 다 돌아도 이론상 최대값이 현재까지의 전역 최대값보다 작다면? 구해도 무의미함
        if (currentMax * (1 << remainMove) <= ans) {
            return;
        }


        for (int i = 0; i < 4; i++) {
            int[][] copiedBoard = copyArray(board);
            int[][] nextBoard = moveBlock(copiedBoard, i);
            // 이동시켜보았는데 변경된게 없으면 해당 방향으로 연산 수행해도 무의미함.
            if(equalArray(board, nextBoard)) {
                continue;
            }

            dfs(nextBoard, time + 1);
        }
    }

    private static boolean equalArray(int[][] copiedBoard, int[][] nextBoard) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(copiedBoard[i][j] != nextBoard[i][j]) return false;
            }
        }
        return true;
    }

    public static int[][] copyArray(int[][] arr) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
    }

    public static int findMax(int[][] board) {
        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp = Math.max(temp, board[i][j]);
            }
        }

        return temp;
    }

    public static int[][] moveBlock(int[][] arr, int dire) {
        // 방향에 따라 보드 뒤집기
        switch (dire){
            case 1: // 우이동
                arr = rotate(arr, 2);
                break;
            case 2: // 상이동
                arr = rotate(arr, 1);
                break;
            case 3: // 하이동
                arr = rotate(arr, 3);
                break;
        }

        for (int i = 0; i < N; i++) {
            // 한줄씩 뽑기
            int idx = 0;
            Queue<Integer> queue = new ArrayDeque<>();

            for (int j = 0; j < N; j++) {
                if(arr[i][j] != 0) {
                    queue.add(arr[i][j]);
                    arr[i][j] = 0;
                }
            }

            while(!queue.isEmpty()) {
                int block = queue.poll();

                if(arr[i][idx] == 0) {
                    arr[i][idx] = block;
                } else if(arr[i][idx] == block) {
                    arr[i][idx]*=2;
                    idx++;
                } else {
                    idx++;
                    arr[i][idx] = block;
                }
            }

        }
        // 원래방향으로 다시 이동
        switch (dire){
            case 1: // 우이동
                arr = rotate(arr, 2);
                break;
            case 2: // 상이동
                arr = rotate(arr, 3);
                break;
            case 3: // 하이동
                arr = rotate(arr, 1);
                break;
        }
        return arr;
    }

    /*
    좌측이동 : 0번 회전
    우측이동 : 2번 90도 회전한 좌측이동과 같음  --> 우측이동 이후 다시 2번 회전해야함
    상단이동 : 3번 90도 회전한 좌측이동과 같음. --> 상단이동 이후 다시 1번 회전해야함.
    하단이동 : 1번 90도 회전한 좌측이동과 같음. --> 하단이동 이후 다시 3번 회전해야함.
     */
    public static int[][] rotate(int[][] board, int time) {
        int[][] rotateBoard = new int[N][N];
        // COPY
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotateBoard[i][j] = board[i][j];
            }
        }

        for(int t = 0; t < time; t++) {
            int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    temp[i][j] = rotateBoard[N - 1 - j][i];
                }
            }
            rotateBoard = temp;
        }
        return rotateBoard;
    }
}
