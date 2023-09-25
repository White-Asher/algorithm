import java.util.*;
import java.io.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 0;
        long right = (long) n * times[times.length - 1]; // 가장 최악의 경우 = 오래 걸리는 시간
        System.out.println(left);
        System.out.println(right);
        while(left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for(int t = 0; t < times.length; t++) {
                sum += mid / times[t];
            }
            
            if(sum < n) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
                answer = mid;
            }
        }
    
        return answer;
    }
}