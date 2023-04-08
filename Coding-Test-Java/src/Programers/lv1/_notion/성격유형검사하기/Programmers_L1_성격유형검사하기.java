package Programers.lv1._notion.성격유형검사하기;

import java.util.HashMap;
import java.util.Map;

public class Programmers_L1_성격유형검사하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //TC1
//        System.out.println(solution.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
        //TC2
        System.out.println(solution.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }
}

class Solution {
    static StringBuilder sb = null;
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        int surveyCnt = survey.length;

        for (int i = 0; i < surveyCnt; i++) {
            if (choices[i] < 4) {
                char type = survey[i].charAt(0);
                int cnt =  4 - choices[i];
                map.put(type, map.getOrDefault(type, 0) + cnt);
            } else if(choices[i] > 4) {
                char type = survey[i].charAt(1);
                int cnt = choices[i] - 4;
                map.put(type, map.getOrDefault(type, 0) + cnt);
            }
        }

        sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
                .append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
                .append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
                .append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');
        return sb.toString();
    }
}