import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        String[] s = number.split("");
        
        int len = s.length - k;
        int start = 0;
        
        for (int i = 0; i < len; i++) {
            int max = 0;
            for(int j = start; j <= i + k; j++) {
                int tar = Integer.parseInt(s[j]);
                if(tar == 9) {
                    max = 9;
                    start = j + 1;
                    break;
                } else if (tar > max) {
                    max = tar;
                    start = j + 1;
                } 
            }
            
            sb.append(String.valueOf(max));
        }
        if(sb.toString().equals("")) {
            return "0";
        }
        return sb.toString();
    }
}