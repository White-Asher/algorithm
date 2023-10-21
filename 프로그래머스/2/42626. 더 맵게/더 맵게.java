import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (true) {
            if (pq.size() <= 1 && pq.peek() < K) {
                answer = -1;
                break;
            }
            if (pq.peek() >= K) {
                break;
            }
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.offer(s1 + s2*2);
            answer++;
            
        }
        return answer;
    }
}