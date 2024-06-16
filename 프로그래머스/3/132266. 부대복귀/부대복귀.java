import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        dijkstra(n, destination);
        
        //soucre => 도착지점
        for(int i = 0; i < sources.length; i++) {
            if(dist[sources[i]] < Integer.MAX_VALUE) {
                answer[i] = dist[sources[i]];
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
    
    public void dijkstra(int n, int destination) {
        dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        Queue<Integer> queue = new LinkedList<>();
        dist[destination] = 0; // 출발지점의 거리는 0으로 설정
        queue.add(destination);
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int i = 0; i < graph.get(cur).size(); i++) {
                // 최솟값 갱신
                int next = graph.get(cur).get(i);
                if(dist[cur] + 1 < dist[next]) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
            
        }
        
    }
}

