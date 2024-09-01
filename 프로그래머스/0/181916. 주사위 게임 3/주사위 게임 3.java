import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] dice = new int[7];
        dice[a]++;
        dice[b]++;
        dice[c]++;
        dice[d]++;
        
        for(int i = 6; i >= 1; i--) {
            if(dice[i] >= 4) {
                return 1111*i;
            } else if(dice[i] >= 3) {
                for(int j = 1; j <= 6; j++) {
                    if(dice[j] == 1) {
                        return (10 * i + j) * (10 * i + j);
                    }
                }
            } else if(dice[i] >= 2){
                for(int j = 1; j <= 6; j++) {
                    if(j == i) continue;
                    
                    if (dice[j] == 2) {
                        return (i + j) * Math.abs(i - j);
                    } else if (dice[j] == 1) {
                        for(int k = 1; k <= 6; k++) {
                            if(k == j) continue;
                            if(dice[k] == 1) {
                                return k*j;
                            }
                        }
                    }
                }
            }
        }
        for(int i = 1; i <= 6; i++) {
            if(dice[i] == 1){
                return i;
            }
        }
        
        return 0;
    }
}