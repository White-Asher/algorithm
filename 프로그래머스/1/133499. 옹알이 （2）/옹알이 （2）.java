import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] str = {"aya", "ye", "woo", "ma"};
        for (String a : babbling) {
            String b = a;
            for(int i = 0; i < 4; i++) {
                b = b.replace(String.valueOf(str[i]+str[i]), "0");
                b = b.replace(str[i], " ");
            }
            
            b = b.replace(" ", "");

            if(b.length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}