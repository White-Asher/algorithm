package BOJ.Hash.BOJ_1620_S4_나는야포켓몬마스터이다솜;

import java.util.*;
import java.io.*;

public class BOJ_1620_S4_나는야포켓몬마스터이다솜 {
    static StringTokenizer st;
    static int N, M;
    static Map<Integer, String> map = new HashMap<>();
    static Map<String, Integer> smap = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            map.put(i, input);
            smap.put(input, i);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            try{
                int a = Integer.parseInt(input);
                sb.append(map.get(a)).append("\n");
            } catch (Exception e) {
                sb.append(smap.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
