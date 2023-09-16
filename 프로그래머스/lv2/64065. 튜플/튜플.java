import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        Set<String> set = new LinkedHashSet<>();
        String[] tuple = s.substring(2, s.length()-2).split("},\\{");
        Arrays.sort(tuple, (a,b) -> (a.length()-b.length()));
        for(String str : tuple) {
            String[] temp = str.split(",");
            for(String tar : temp) {
                set.add(tar);
            }
        }
        
        int[] answer = new int[set.size()];
        int idx = 0;
        for(String setData : set) {
            answer[idx++] = Integer.parseInt(setData);
        }
        
        return answer;
    }
}