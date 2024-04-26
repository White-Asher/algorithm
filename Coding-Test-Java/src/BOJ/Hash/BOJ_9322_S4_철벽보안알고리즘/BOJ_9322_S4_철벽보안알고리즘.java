package BOJ.Hash.BOJ_9322_S4_철벽보안알고리즘;

import java.util.*;
import java.io.*;

public class BOJ_9322_S4_철벽보안알고리즘 {
    static StringTokenizer st;
    public static void main (String[]args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> amap = new HashMap<>();
            Map<Integer, Integer> bmap = new HashMap<>();
            String[] res = new String[n];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                amap.put(st.nextToken(), i);
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                String str = st.nextToken();
                bmap.put(i, amap.get(str));
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                res[bmap.get(i)] = st.nextToken();
            }
            for (String re : res) {
                sb.append(re).append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
