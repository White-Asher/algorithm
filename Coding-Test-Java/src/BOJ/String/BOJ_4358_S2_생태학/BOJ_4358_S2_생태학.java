package BOJ.String.BOJ_4358_S2_생태학;

import java.util.*;
import java.io.*;

public class BOJ_4358_S2_생태학 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new TreeMap<>(); // TreeMap은 sort기본동작
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input == null || input.isEmpty()) {
                break;
            }
            cnt++;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            double per = (double) (entry.getValue()*100) / cnt ;
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", per)).append("\n");
        }

        System.out.println(sb);
    }
}
