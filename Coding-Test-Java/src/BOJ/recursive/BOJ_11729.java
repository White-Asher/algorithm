package BOJ.recursive;

import java.util.*;
import java.io.*;

public class BOJ_11729 {
    static StringBuilder sb;
    static BufferedReader br;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        hanoi(n, 1, 3, 2);

        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void hanoi(int n, int start, int end, int sub){
        if(n == 1){
            move(1, start, end);
            return;
        }

        else {
            hanoi(n-1, start, sub, end);
            move(n, start, end);
            hanoi(n-1, sub, end, start);
        }
    }

    // 원판을 옮기는 함수
    public static void move(int n, int start, int end){
        count++;
        sb.append(start).append(" ").append(end).append("\n");
    }
}