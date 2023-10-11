import java.util.*;

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