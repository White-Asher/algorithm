import java.util.*;

class Solution {
    static List<Car> list;
    
    public int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        
        list = new ArrayList<>();
        for(int[] r : routes) {
            list.add(new Car(r[0], r[1]));
        }
        list.sort((o1, o2) -> o1.end - o2.end);
        
        for(int i = 0; i < list.size(); i++) {
            if(min < list.get(i).start) {
                min = list.get(i).end;
                answer++;
            }
        }
        
        return answer;
    }
    
}

class Car {
    int start;
    int end;

    public Car(int s, int e) {
        start = s;
        end = e;
    }
}

