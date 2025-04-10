import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        int start = 0;
        int cnt = 0;
        while(true) {
            if(index > s.length() - 1) break;
            if(index >= start + cnt*2) {
                start = index;
                cnt = 0;
                answer++;
            }
            if(s.charAt(start) == s.charAt(index)) {
                cnt++;
            }
            index++;
        }
        
        return answer;
    }
}