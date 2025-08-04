package BOJ.DiviedandConquer.BOJ_2447_G5_별찍기10;

import java.util.*;
import java.io.*;

public class BOJ_2447_G5_별찍기10_250803 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }
        }

        draw(0,0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    private static void draw(int y, int x, int size) {
        if(size == 1) {
            arr[y][x] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) continue;
                draw(y + (i * newSize) , x + (j * newSize), newSize);
            }
        }
    }


}
