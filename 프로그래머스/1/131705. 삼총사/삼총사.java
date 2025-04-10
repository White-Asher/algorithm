import java.util.*;

class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for(int i = 0 ; i < number.length; i++) {
            for(int j = i + 1; j < number.length; j++) {
                if(j == i) continue;
                for(int k = j + 1; k < number.length; k++) {
                    if(k == j || k == i) continue;
                        if(number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }
        return answer;
    }
}