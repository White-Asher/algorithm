import java.util.*;
import java.io.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0)
            return cities.length * 5;
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < cities.length; i++) {
            boolean flag = false;
            String tar = cities[i].toUpperCase();
            for(int j = 0; j < list.size(); j++) {
                if(tar.equals(list.get(j))) {
                    list.remove(tar);
                    list.add(tar);
                    answer+=1;
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                answer+=5;
                if(list.size() >= cacheSize) {
                    list.remove(0);
                }    
                list.add(tar);
            }
        }
        
        return answer;
    }
}