/*
제목 : 달리기 경주
알고리즘 유형 : #string , #hashmap
플랫폼 : #Programmers 
난이도 : L1
문제번호 : 178871
시간 : 10m
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/178871?language=java
특이사항 : #프로그래머스-고득점 
*/

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> hash = new HashMap<>();
        
        for(int i = 0; i < players.length; i++ ) {
            hash.put(players[i], i);
        }
        
        for(String p : callings) {
            int rank = hash.get(p);
            String front = players[rank-1];
            hash.put(p, rank-1);
            hash.put(front, rank);
            players[rank] = front;
            players[rank-1] = p;
        }
        
        return players;
    }
}

/*
// 시간초과
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        for(String s : callings) {
            for(int i = 0; i < players.length; i++ ) {
                if(s.equals(players[i])) {
                    String temp = players[i];
                    players[i] = players[i-1];
                    players[i-1] = temp;
                    break;
                }
            }
        }
        
        return players;
    }
}
*/