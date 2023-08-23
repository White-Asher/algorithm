import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int a = 0;
        for(int i = 0; i < d.length; i++) {
            if(a + d[i] > budget) {
                return answer;
            } else {
                a += d[i];
                answer++;
            }
        }
        return answer;
    }
}