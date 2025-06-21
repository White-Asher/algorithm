package BOJ.Greedy.BOJ_1789_S5_수들의합;

import java.util.*;
import java.io.*;

public class BOJ_1789_S5_수들의합_250621 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long num = 0;
        long c = 0;
        while(num <= S) {
            num += ++c;
        }
        System.out.println(c-1);
    }
}
