package BOJ.Simulation.BOJ_12100_G1_2048_EASY;

import java.util.*;
import java.io.*;

public class BOJ_12100_G1_2048_250712 {
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
        // INPUT

        dfs(arr, 0);

        System.out.println(ans);
    }

    public static void dfs(int[][] board, int time) {
        if(time == 5) {
            findMax(board);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] nextBoard = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    nextBoard[j][k] = board[j][k];
                }
            }
            dfs(moveBlock(nextBoard, i), time + 1);
            // debug
//            System.out.println("+===========================+");
//            for (int j = 0; j < N; j++) {
//                System.out.println(Arrays.toString(board[j]));
//            }
        }
    }

    public static void findMax(int[][] board) {
        int temp = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp = Math.max(temp, board[i][j]);
            }
        }
        ans = Math.max(temp, ans);
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
