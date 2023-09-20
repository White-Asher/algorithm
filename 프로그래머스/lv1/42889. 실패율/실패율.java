
// note
import java.util.*;

class Solution {
    public int[] solution(int n, int[] stages) {
        n++;
        int[] answer = new int[n-1];
        Arrays.sort(stages);
        int[] cnt = new int[n+1];
        for(int i = 0; i < stages.length; i++) {
            cnt[stages[i]]++;
        }
        // System.out.println(Arrays.toString(cnt));
        
        int[] cntSum = new int[n+1];
        cntSum[1] = stages.length;
        for(int i = 1; i < n; i++) {
            cntSum[i+1] = cntSum[i] - cnt[i];
        }
        
        // System.out.println(Arrays.toString(cntSum));
        
        Map<Integer, Double> map = new HashMap<>();
        for(int i = 0; i < n-1; i++) {
            double r = 0.0;
            
            if(cnt[i+1] == 0 || cntSum[i+1] == 0) {
                
            } else {
                r = (double)cnt[i+1] / (double)cntSum[i+1];
            }
            map.put(i+1, r);
        }
        
        List<Integer> listKeySet = new ArrayList<>(map.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        int idx = 0;
		for(Integer key : listKeySet) {
			// System.out.println("key : " + key + " , " + "value : " + map.get(key));
            answer[idx++] = key;
		}
        

        return answer;
    }
} 