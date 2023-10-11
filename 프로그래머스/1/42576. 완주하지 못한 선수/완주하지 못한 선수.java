import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s : completion) {
            map.put(s, map.get(s) - 1);
        }
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() != 0) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
        
    }
}
// sort
/*
class Solution {
    public String solution(String[] participant, String[] completion) {
        String ans = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0; i < participant.length; i++) {
            if(i == participant.length - 1) {
                ans = participant[i];
                break;
            }
            if(!participant[i].equals(completion[i])) {
                ans = participant[i];
                break;
            }
        }
        return ans;
    }
}
*/