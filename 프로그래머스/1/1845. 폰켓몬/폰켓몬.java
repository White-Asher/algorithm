import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = (nums.length == 1 ? 1 : nums.length / 2);
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : nums) {
            set.add(i);
        }
        answer = Math.min(set.size(), answer);            
        return answer;
    }
}