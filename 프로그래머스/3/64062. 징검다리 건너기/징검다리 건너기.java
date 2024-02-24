import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 0;
        for(int stone : stones) {
            right = Math.max(stone, right);
        }
        
        while(left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(mid, stones, k)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    static boolean isPossible(int mid, int[] stones, int k) {
        int zeroCnt = 0;
        for(int stone : stones) {
            if(stone - mid <= 0) {
                zeroCnt++;
                if(zeroCnt >= k) {
                    return false;
                }
            } else {
                zeroCnt = 0;
            }
        }
        return true;
    }
}