/*
 제목 : 문자열나누기
 알고리즘 유형 : #문자열
 플랫폼 : #Programmers
 난이도 : L1
 문제번호 : 140108
 시간 : 30
 해결 : O
 저장 : O
 해결언어 : java
 문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/140108
 특이사항 : X
 */

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        int start = 0;
        int cnt = 0;
        while(true) {
            if(index > s.length() - 1) break;
            if(index >= start + cnt*2) {
                start = index;
                cnt = 0;
                answer++;
            }
            if(s.charAt(start) == s.charAt(index)) {
                cnt++;
            }
            index++;
        }
        
        return answer;
    }
}