import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clo = new int[n+1];
        Arrays.fill(clo, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < reserve.length; i++) {
            clo[reserve[i]] = 2;
        }
        
        for(int i = 0; i < lost.length; i++) {
            clo[lost[i]]-=1;
        }
        
        for(int i = 0; i < lost.length; i++) {
            int tar = lost[i];
            boolean flag = false;
            
            
            if(tar - 1 != 0) {
                if(clo[tar-1] == 2) {
                    clo[tar-1] = 1;
                    clo[tar] = 1;
                    flag= true;
                } 
            }
            if(tar + 1 <= n && !flag) {
                if(clo[tar+1] == 2) {
                    clo[tar+1] = 1;
                    clo[tar] = 1;
                } 
            }
        }
        
        for(int i= 1; i <= n; i++) {
            if(clo[i]>=1) {
                answer++;
            }
        }
        
        System.out.println(Arrays.toString(clo));
        
        return answer;
    }
}