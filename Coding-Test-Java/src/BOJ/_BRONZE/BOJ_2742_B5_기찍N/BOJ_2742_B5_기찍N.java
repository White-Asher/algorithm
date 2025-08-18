package BOJ._BRONZE.BOJ_2742_B5_기찍N;

import java.util.*;
import java.io.*;

public class BOJ_2742_B5_기찍N {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = n; i >= 1; i--) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
