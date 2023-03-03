package Softeer.level2;

import java.util.*;
import java.io.*;

public class GBC {
    static StringTokenizer st;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 0;

        // 제한 속도 배열
        int[] limit = new int[101];
        int cur = 1;
        // 제한속도 넣기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = cur; j < a+cur;j++){
                limit[j] = b;
            }
            cur+=a;
        }
        cur = 1;

        int[] vlimit = new int[101];
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int k = cur; k<cur+a;k++){
                vlimit[k] = b;
            }
            cur+=a;
        }

        for(int i = 1; i<=100; i++){
            ans = Math.max(ans, vlimit[i]-limit[i]);
        }

        System.out.println(ans);

    }
}
