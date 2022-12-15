package BOJ.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_6603 {
    static StringBuilder sb = new StringBuilder();
    static int[] lotto;
    static int[] pick;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            pick = new int[6];

            if(n == 0) break;
            else {
                lotto = new int[n];
                for (int i = 0; i < n; i++) {
                    lotto[i] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.sort(lotto);
            combination(0, 0);
            sb.append("\n");

        }


        System.out.println(sb.toString());

    }

    public static void combination(int cnt, int start){
        if(cnt == 6){
            for (int i = 0; i < 6; i++) {
                sb.append(pick[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            pick[cnt] = lotto[i];
            combination(cnt+1, i+1);
        }
    }
}
