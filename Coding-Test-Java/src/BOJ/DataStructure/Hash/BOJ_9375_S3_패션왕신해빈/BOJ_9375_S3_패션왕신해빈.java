package BOJ.DataStructure.Hash.BOJ_9375_S3_패션왕신해빈;

import java.util.*;
import java.io.*;

public class BOJ_9375_S3_패션왕신해빈 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                map.put(b, map.getOrDefault(b, 0) + 1);
            }
            int ans = 1;
            for (Map.Entry<String, Integer> entry: map.entrySet()) {
                ans *= (entry.getValue() + 1);
            }
            sb.append(ans - 1).append("\n");

        }

        System.out.println(sb);
    }
}
