package BOJ.Greedy.BOJ_14916_S4_거스름돈;

import java.util.*;
import java.io.*;

public class BOJ_14916_S4_거스름돈_250621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int c5 = N / 5;
        int c5p = N % 5;
        if(c5p == 0) {
            System.out.println(c5);
            return;
        }

        int c2 = c5p / 2;
        int c2p = c5p % 2;
        if(c2p == 0) {
            System.out.println(c5 + c2);
            return;
        }
        c5p+=5;
        System.out.println(c5 > 0 ? c5 - 1 + (c5p/2) : -1);
    }
}

