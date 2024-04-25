package BOJ.String.BOJ_1427_S5_소트인사이드;

import java.io.*;
import java.util.*;

public class BOJ_1427_S5_소트인사이드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        Arrays.sort(input);
        StringBuilder sb = new StringBuilder();
        for (int i = input.length - 1; i >= 0; i--) {
            sb.append(input[i]);
        }
        System.out.println(sb);

    }
}
