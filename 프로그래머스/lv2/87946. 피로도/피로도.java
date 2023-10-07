import java.util.*;

class Solution {
    static int[] input;
    static boolean[] check;
    static int status, size, answer, cur;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        
        input = new int[dungeons.length];
        check = new boolean[k];
        size = input.length;
        
        per(0, dungeons, k);
        
        return answer;
    }
    
    static void calc (int[][] dungeons) {
        int temp = 0;
        for(int i = 0; i < size; i++) {
            int tar = input[i]; // 타겟 인덱스
            int min = dungeons[tar][0];
            int consume = dungeons[tar][1];
            if(cur >= min) {
                cur-=consume;
                temp++;
            }
        }
        answer = Math.max(temp, answer);
    }
    
    static void per(int cnt, int[][] dungeons, int k) {
        if(cnt == size) {
            cur = k;
            // System.out.println(Arrays.toString(input));
            calc(dungeons);
            return;
        }
        
        for(int i = 0; i < size; i++) {
            if(check[i]) continue;
            input[cnt] = i;
            check[i] = true;
            per(cnt + 1, dungeons, k);
            check[i] = false;
        }
    }
    
}