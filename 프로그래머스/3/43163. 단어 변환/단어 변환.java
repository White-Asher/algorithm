import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public static void dfs(String current, String target, String[] words, int cnt) {
        if(current.equals(target)) {
            answer = cnt;
            return;
        }
        
        // 단어를 전부 탐색하기
        for(int i = 0; i < words.length; i++) {
            
            // 이미 사용된 단어면 넘어가기
            if(visited[i]) {
                continue;
            }
            
            int same = 0;
            for(int j = 0; j < current.length(); j++) {
                if(current.charAt(j) == words[i].charAt(j)) {
                    same++;
                }
            }
            
            if(same == current.length() - 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visited[i] = false;
            }
            
        }
        
    }
}