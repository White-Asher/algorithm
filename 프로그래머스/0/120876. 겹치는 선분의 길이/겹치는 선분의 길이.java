// IMOS

import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] imos = new int[202];
        
        // 각 선분에 대해 imos 배열에 시작점과 끝점 표시.
        for(int[] line : lines) {
            imos[line[0] + 100]++;
            imos[line[1] + 100]--;
        }
        
        // 누적합 계산, imop 배열의 각 위치에 대해 이전 값을 더한다. 
        for(int i = 0; i < imos.length - 1; i++) {
            imos[i + 1] += imos[i];
        }
                
        for(int i = 0; i < imos.length; i++) {
            if(imos[i] > 1) {
                answer++;
            }
        }
        
        return answer;
    }
}