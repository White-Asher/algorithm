/*
제목 : 신규 아이디 추천
알고리즘 유형 : #문자열
플랫폼 : #Programmers
난이도 : L1
문제번호 : 72410
시간 : 0
해결 : X
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72410
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/

import java.util.*;

class Solution {
    public String solution(String newId) {
        // 1
        newId = newId.toLowerCase();
        // 2
        newId = newId.replaceAll("[^a-z0-9\\-_.]", "");
        // 3
        newId = newId.replaceAll("\\.+", ".");
        // 4
        newId = newId.replaceAll("^\\.+|\\.+$", "");
        // 5
        if (newId.isEmpty()) newId = "a";
        // 6
        if (newId.length() >= 16) { 
            newId = newId.substring(0, 15);            
            newId = newId.replaceAll("\\.+$", "");        
        }
        // 7
        while (newId.length() < 3) {            
            newId += newId.charAt(newId.length() - 1);        
        }
        return newId;    
    }
}