package BOJ.Hash.BOJ_10816_S4_숫자카드2;

import java.util.*;
import java.io.*;

public class BOJ_10816_S4_숫자카드2 {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int inti = Integer.parseInt(st.nextToken());
            map.put(inti, map.getOrDefault(inti, 0 ) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < t; i++) {
            Object key = map.get(Integer.parseInt(st.nextToken()));
            sb.append(key == null ? 0 : key).append(" ");
        }
        System.out.println(sb);
    }
}
