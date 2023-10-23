import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
        PriorityQueue<Integer> pqL = new PriorityQueue<>();
        PriorityQueue<Integer> pqH = new PriorityQueue<>(Collections.reverseOrder());
        int low = 0;
        int high = 0;
        
        for(int i = 0; i < operations.length; i++) {
            String[] s = operations[i].split(" ");
            if ("I".equals(s[0])) {
                pqL.add(Integer.parseInt(s[1]));
                pqH.add(Integer.parseInt(s[1]));
            } else {
                String d = s[1];
                if(pqL.size() == 0) {
                    continue;
                } else if("1".equals(d)) {
                    high = pqH.peek();
                    pqH.poll();
                    pqL.remove(high);
                } else if ("-1".equals(d)) {
                    low = pqL.peek();
                    pqL.poll();
                    pqH.remove(low);
                }
            }
            
        }
        if (pqL.size() == 0) {
           answer = new int[] {0, 0};
        } else {
            answer = new int[] {pqH.peek(), pqL.peek()};
        }
        
        
        return answer;
    }
}