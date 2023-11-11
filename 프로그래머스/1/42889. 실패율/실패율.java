// note
import java.util.*;

// best 
class Solution {
    public int[] solution(int N, int[] lastStages) {
        int nPlayers = lastStages.length;
        int[] nStagePlayers = new int[N + 2];
        for (int stage : lastStages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<>();
        for (int id = 1 ; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        Collections.sort(stages, Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }

    class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id_, double failure_) {
            id = id_;
            failure = failure_;
        }

        @Override
        public int compareTo(Stage o) {
            if (failure < o.failure ) {
                return -1;
            }
            if (failure > o.failure ) {
                return 1;
            }
            return 0;
        }
    }
}


// 시도한 solution
/*
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
*/
