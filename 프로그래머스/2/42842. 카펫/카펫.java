import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        for(int i = 3; i <= 5000; i++) {
            for(int j = 3; j <= i; j++){
                int total = i * j;
                int cyellow = total - (j * 2 + (i - 2) * 2);
                int cbrown = total - cyellow;
                if(cbrown == brown && cyellow == yellow) {
                    return new int[]{i, j};
                }
            }
        }
        
        return null;
    }
}