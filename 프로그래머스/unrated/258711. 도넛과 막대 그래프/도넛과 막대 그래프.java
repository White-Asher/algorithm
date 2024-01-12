import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] ans = new int[4];
        Map<Integer, int[]> node = new HashMap<>();
        
        // 간선정보 setting
        for(int[] e : edges) {
            int start = e[0];
            int end = e[1];
            if(!node.containsKey(start)) {
                node.put(start, new int[]{0,0});
            }
            if(!node.containsKey(end)) {
                node.put(end, new int[]{0,0});
            }
            node.get(start)[0]++; // start -> end 개수
            node.get(end)[1]++; // end -> start 개수
        }
        
        for (Map.Entry<Integer, int[]> entry : node.entrySet()) {
            int key = entry.getKey();
            int[] n = entry.getValue();
            
            // 출발간선 두개, 도착간선 0개라면 정점
            if(n[0] >= 2 && n[1] == 0) {
                ans[0] = key;
            } 
            // 막대그래프
            else if(n[0] == 0 && n[1] > 0) {
                ans[2]++;
            } 
            // 8자 그래프
            else if(n[0] >= 2 && n[1] >= 2) {
                ans[3]++;
            }
        }
        // 정점에 연결된 그래프 - 막대그래프 - 8자 그래프 = 도넛그래프
        ans[1] = node.get(ans[0])[0] - ans[2] - ans[3];
        
        return ans;
    }
}