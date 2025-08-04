package BOJ._BRONZE.BOJ_2745_B2_진법변환;

import java.io.*;
import java.util.*;

public class BOJ_2745_B2_진법변환_250802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        int result = Integer.parseInt(N, B);

        System.out.println(result);
    }
}
