import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                BFS(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void BFS(int t, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(t);
        visited[t] = true;
        
        while(!queue.isEmpty()) {
            int q = queue.poll();
            for(int j = 0; j < computers.length; j++) {
                
                if(computers[q][j] == 1 && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }                
            }
        }
    }
}