package BOJ.DataStructure.Hash.BOJ_10546_S4_배부른마라토너;

import java.util.*;
import java.io.*;

public class BOJ_10546_S4_배부른마라토너 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        for (int i = 0; i < n-1; i++) {
            String input = br.readLine();
            map.put(input, map.get(input) - 1);
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 1) {
                System.out.println(entry.getKey());
                System.exit(0);
                break;
            }
        }
    }
}
