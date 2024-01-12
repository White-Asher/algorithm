import java.util.*;

class Solution {
    public int[] solution(int[] a, int k) {
        int[] ans = {};
        
        int l = 0;
        int r = 0;
        int m = 1000001;
        int s = 0;
        
        while(true) {
            if (s == k) {
                if(r - l < m) {
                    ans = new int[]{l, r-1};
                    m = r - l;
                    s-=a[l++];
                } else {
                    s-=a[l++];
                }
            } 
            
            if (s > k) {
                s-=a[l++];
            } else if (r >= a.length) {
                break;
            } else if (s < k) {
                s+=a[r++];
            } 
            // System.out.println("l : "+ l + " r : " + r + " s : " + s);
            
        }
        
        return ans;
    }
}