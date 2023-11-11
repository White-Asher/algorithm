import java.util.*;
import java.io.*;

class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        DFS(0, 0, numbers.length, target, numbers);
        return answer;
    }
    
    public void DFS(int num, int idx, int len, int target, int[] numbers) {
        if (idx == len) {
            if(num == target) {
                answer++;
            }
            return;
        }
        
        DFS(num + numbers[idx], idx+1, len, target, numbers);
        DFS(num - numbers[idx], idx+1, len, target, numbers);
        
        
    }
}