/*
제목 : 오픈채팅방
알고리즘 유형 : #자료구조
플랫폼 : #Programmers 
난이도 : L2
문제번호 : 43888
시간 : 30
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42888
특이사항 : #2019 KAKAO BLIND RECRUITMENT
*/

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        String[] answer;
        List<RecordClass> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        int idx = 0;
        int size = 0;
        
        for (String r : record) {
            String[] rs = r.split(" ");
            String command = rs[0];
            String userId = rs[1];
            
            if(command.equals("Enter") ) {
                map.put(userId, rs[2]);
                list.add(new RecordClass(idx++, userId, command));
                size++;
            } else if(command.equals("Leave")) {
                list.add(new RecordClass(idx++, userId, command));
                size++;
            } else if(command.equals("Change")) {
                map.put(userId, rs[2]);
            }
        }
        
        answer = new String[size];
        int cc = 0;
        
        for(RecordClass r : list) {
            StringBuilder sb = new StringBuilder();
            String user = r.user;
            String nickname = map.get(user);
            String state = r.state;
            sb.append(nickname+"님이 ");
            
            if (state.equals("Enter")) {
                sb.append("들어왔습니다.");
            } else if (state.equals("Leave")) {
                sb.append("나갔습니다.");
            }
            
            answer[cc++] = sb.toString();
        }
     
        return answer;
    }
}

class RecordClass {
    int seq;
    String user;
    String state;
    
    public RecordClass(int seq, String user, String state) {
        this.seq = seq;
        this.user = user;
        this.state = state;
    }
    
}