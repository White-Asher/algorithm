/*
제목 : 이상한 문자 만들기
알고리즘 유형 : #문자열
플랫폼 : #Programmers
난이도 : L1
문제번호 : 12926
시간 : -
해결 : O
저장 : O
해결언어 : java
문제링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=java
특이사항 : #[도서실습] 프로그래머스 코딩 테스트 문제 풀이 전략: 자바편
*/
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int worldIdx = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                if (worldIdx % 2 == 0) {
                    answer += String.valueOf(Character.toUpperCase(s.charAt(i)));
                } else {
                    answer += String.valueOf(Character.toLowerCase(s.charAt(i)));
                }
                worldIdx++;
            } else {
                answer += String.valueOf(s.charAt(i));
                worldIdx = 0;
            }
        }
        
        return answer;
    }
}
