package BOJ._BRONZE.BOJ_25304_B4_영수증;

import java.util.*;
import java.io.*;

public class BOJ_25304_B4_영수증_250715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            temp += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        System.out.println(sum == temp ? "Yes" : "No");
    }
}
