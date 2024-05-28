package BOJ.Math.BOJ_23971_B3_ZOAC4;

import java.util.*;
import java.io.*;

public class BOJ_23971_B3_ZOAC4 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = ( ( (H - 1) / (N + 1) ) + 1 ) * (( (W - 1) / (M + 1)) + 1);

        System.out.println(ans);
    }
}
