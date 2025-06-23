package BOJ.DP.BOJ_2775_B1_부녀회장이될테야;

import java.io.*;

public class BOJ_2775_B1_부녀회장이될테야_250622 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[][] apt = new int[15][15];
        for (int i = 0; i < 15; i++) {
            apt[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
            }
        }
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]).append("\n");
        }
        System.out.print(sb);
    }
}
