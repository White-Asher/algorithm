import java.util.*;
import java.io.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        long ans = 0;
        Map<Double, Integer> map = new HashMap<>();
        for (int w : weights) {
            double w1 = w * 1.0;
            double w2 = (w * 2) / 3.0;
            double w3 = (w * 1.0) / 2.0;
            double w4 = (w * 3.0) / 4.0;
            
            if(map.containsKey(w1)) ans += map.get(w1);
            if(map.containsKey(w2)) ans += map.get(w2);
            if(map.containsKey(w3)) ans += map.get(w3);
            if(map.containsKey(w4)) ans += map.get(w4);
            
            map.put(w1 , map.getOrDefault(w1, 0) + 1);
            
        }
        
        return ans;
    }
}