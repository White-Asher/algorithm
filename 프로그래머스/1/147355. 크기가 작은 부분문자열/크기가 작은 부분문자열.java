import java.util.*;

class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        
        for(int i = 0; i <= t.length() - size; i++) {
            String tt = t;
            String a = tt.substring(i, i+size);
            if(Long.parseLong(a) <= Long.parseLong(p)) {
                answer++;
            }
        }
        
        return answer;
    }
}