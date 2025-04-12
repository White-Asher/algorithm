import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        int[][] res = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    void hanoi(int n, int start, int end, int sub) {
        if(n == 1) {
            move(start, end);
            return;
        }
        else {
            hanoi(n - 1, start, sub, end);
            move(start, end);
            hanoi(n -1 , sub, end, start);
        }
    }
    
    void move(int start, int end) {
        list.add(new int[]{start, end});
    }
}