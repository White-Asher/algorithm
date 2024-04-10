package BOJ.Hash.BOJ_1302_S4_베스트셀러;

import java.util.*;
import java.io.*;

public class BOJ_1302_S4_베스트셀러 {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        int max = 0;

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        List<String> list = new ArrayList<>();
        for(int i = 0; i < entryList.size(); i++) {
            int curVal = entryList.get(i).getValue();
            if (curVal > max) {
                max = curVal;
                list.clear();
                list.add(entryList.get(i).getKey());
            } else if (curVal == max) {
                list.add(entryList.get(i).getKey());
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
}
