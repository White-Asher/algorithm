package BOJ.String.BOJ_5525_IOIOI;

import java.io.*;
import java.util.*;

public class BOJ_5525_IOIOI {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        Integer M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int cnt = 0;
        int res = 0;
        for (int i = 1; i < M-1; i++) {
            if(S[i-1] == 'I' && S[i] == 'O' && S[i+1] == 'I') {
                cnt++;
                if(cnt == N) {
                    cnt--;
                    res++;
                }
                i+=1;
            }
            else {
                cnt = 0;
            }
        }
        System.out.println(res);
    }
}
